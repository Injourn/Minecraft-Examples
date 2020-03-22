package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Item.ItemTest;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
 
@ObjectHolder(ExampleMod.ModId)
@Mod.EventBusSubscriber(modid = ExampleMod.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems{
  
  public static final Item ITEMTEST = null;

  @SubscribeEvent  
  public static void register(final RegistryEvent.Register<Item> event)
  {
    
    event.getRegistry().register(new ItemTest(new Item.Properties().maxStackSize(64).group(ItemGroup.MISC)));
  }
}