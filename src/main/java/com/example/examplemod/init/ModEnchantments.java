package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.enchantment.EnchantmentDoubleJump;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ExampleMod.ModId)
@Mod.EventBusSubscriber(modid = ExampleMod.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEnchantments{
    public static final Enchantment DOUBLE_JUMP = null;

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Enchantment> event){
        event.getRegistry().register(new EnchantmentDoubleJump());
    }
}