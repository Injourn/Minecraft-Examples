package com.example.examplemod.enchantment;

import java.util.Map;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.capabilities.IJumping;
import com.example.examplemod.capabilities.JumpingDataHandler;
import com.example.examplemod.init.ModEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.ModId)
public class EnchantmentDoubleJump extends Enchantment {

    public EnchantmentDoubleJump() {
        super(Rarity.RARE, EnchantmentType.ARMOR_LEGS, new EquipmentSlotType[] { EquipmentSlotType.LEGS });
        this.setRegistryName(ExampleMod.getId("double_jump"));
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public int getMinEnchantability(int level) {
        return 4 + 6 * level;
    }

    @Override
    public int getMaxEnchantability(int level) {
        return this.getMinEnchantability(level) + 10;
    }
    @SubscribeEvent
    public static void OnFallDown(LivingFallEvent event){
        if(event.getEntity() instanceof ServerPlayerEntity){
             ServerPlayerEntity player = (ServerPlayerEntity) event.getEntity();
            ItemStack stack = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
            if (!stack.isEmpty()) {
                Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stack);
                if (enchantments.containsKey(ModEnchantments.DOUBLE_JUMP)) {
                    IJumping handler = JumpingDataHandler.getHandler(stack);
                    handler.ResetJump(enchantments.get(ModEnchantments.DOUBLE_JUMP));                   

                }
            
            }
        }
    }
    public static void DoubleJumpHandle(boolean message, ServerPlayerEntity player) {
        ItemStack stack = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
        if (!stack.isEmpty()) {
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stack);
            if (enchantments.containsKey(ModEnchantments.DOUBLE_JUMP)) {
                IJumping handler = JumpingDataHandler.getHandler(stack);
                if (message) {
                    
                    if(handler.JumpsLeft()){
                        player.jump();
                        player.velocityChanged = true;
                        handler.SpendJump();
                    }                                        
                }
                else{
                    handler.ResetJump(enchantments.get(ModEnchantments.DOUBLE_JUMP));
                }
            }
            
        }
        
    }
}