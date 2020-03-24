package com.example.examplemod.enchantment;

import java.util.Map;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.init.ModEnchantments;
import com.example.examplemod.network.message.MessageJump;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;


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
        
    public static void DoubleJumpHandle(MessageJump message,ServerPlayerEntity player){
        ItemStack stack = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
        if(!stack.isEmpty()){
            Map<Enchantment,Integer> enchantments = EnchantmentHelper.getEnchantments(stack);
            ExampleMod.LOGGER.debug(enchantments.values().toArray()[0]);
            if(enchantments.containsKey(ModEnchantments.DOUBLE_JUMP)){
                player.moveVertical = .4f;
                ExampleMod.LOGGER.debug("DoubleJumpActive");
            }
        }
    }
}