package com.example.examplemod.enchantment;

import java.util.Map;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.init.ModEnchantments;

import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.GameType;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;


@Mod.EventBusSubscriber(modid = ExampleMod.ModId)
public class EnchantmentDoubleJump extends Enchantment {

    public EnchantmentDoubleJump() {
        super(Rarity.RARE, EnchantmentType.ARMOR_LEGS, new EquipmentSlotType[] {EquipmentSlotType.LEGS});        
        this.setRegistryName(ExampleMod.getId("double_jump"));        

    }

    @Override
    public int getMinLevel(){
        return 1;
    }

    @Override
    public int getMaxLevel(){
        return 1;
    }
    @Override
    public int getMinEnchantability(int level)
    {
        return level * 15;
    }
    @Override
    public int getMaxEnchantability(int level)
    {
        return this.getMinEnchantability(level);
    }
    
    @SubscribeEvent
    public static void onPlayerJump(InputEvent.KeyInputEvent event){
        Minecraft player = Minecraft.getInstance();
        if(player.playerController.isNotCreative() && player.player.movementInput.jump && !player.player.onGround){
            player.playerController.setGameType(GameType.CREATIVE);         
            //Do stuff here
        }        
    }
}