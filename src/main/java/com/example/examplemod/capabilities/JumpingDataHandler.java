package com.example.examplemod.capabilities;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.init.ModEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class JumpingDataHandler {
    @CapabilityInject(IJumping.class)
    public static final Capability<IJumping> CAPABILITY_AIR_JUMPS = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(IJumping.class, new Storage(), Jumping::new);
        MinecraftForge.EVENT_BUS.register(new JumpingDataHandler());
    }
    @Nullable
    public static IJumping getHandler(ItemStack item)
    {
        return item.getCapability(CAPABILITY_AIR_JUMPS, Direction.DOWN).orElse(null);
    }
    @SubscribeEvent
    public void attachCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
        ItemStack stack = (ItemStack)event.getObject();
        if(stack.getItem() instanceof ArmorItem){
            ArmorItem item = (ArmorItem)stack.getItem();
            if(item.getEquipmentSlot() == EquipmentSlotType.LEGS){
                event.addCapability(ExampleMod.getId("capability_air_jumps"),new Provider());
            }
            
        }
    }

    public static class Storage implements Capability.IStorage<IJumping> {
        @Nullable
        @Override
        public INBT writeNBT(Capability<IJumping> capability, IJumping instance, Direction side) {
            return IntNBT.func_229692_a_(instance.JumpsAvailable());
        }

        @Override
        public void readNBT(Capability<IJumping> capability, IJumping instance, Direction side, INBT nbt) {
            IntNBT next = (IntNBT) nbt;            
            instance.ResetJump(next.getInt());

        }
        
    }
    public static class Jumping implements IJumping{
        int jumps = 0;
        @Override
        public void SpendJump() {
            jumps--;
        }

        @Override
        public void ResetJump(int amount) {            
            jumps = amount;
        }

        @Override
        public int JumpsAvailable() {
            return jumps;
        }

        @Override
        public boolean JumpsLeft() {
            return jumps > 0;
        }
    }
    public static class Provider implements ICapabilitySerializable<IntNBT>
    {
        final IJumping INSTANCE = CAPABILITY_AIR_JUMPS.getDefaultInstance();

        @Override
        public IntNBT serializeNBT()
        {
            return (IntNBT) CAPABILITY_AIR_JUMPS.getStorage().writeNBT(CAPABILITY_AIR_JUMPS, INSTANCE, null);
        }

        @Override
        public void deserializeNBT(IntNBT compound)
        {
            CAPABILITY_AIR_JUMPS.getStorage().readNBT(CAPABILITY_AIR_JUMPS, INSTANCE, null, compound);
        }

        @Nonnull
        @Override
        public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side)
        {
            return CAPABILITY_AIR_JUMPS.orEmpty(cap, LazyOptional.of(() -> INSTANCE));
        }
    }
}