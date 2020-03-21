package com.example.examplemod.init;

import javax.annotation.Nullable;

import com.example.examplemod.ExampleMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
 
public class ModBlocks{
  public static Block blueStone;

  public static void registerAll(RegistryEvent.Register<Block> event){
    if(!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) return;
    Block block = new Block(Block.Properties.create(Material.ROCK)
      .hardnessAndResistance(1.5f,6f)
      .sound(SoundType.STONE));
    blueStone = register("blue_stone", block);
  }
  private static <T extends Block> T register(String name, T block){
    BlockItem item = new BlockItem(block,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
    return register(name,block, item);

  }
  private static <T extends Block> T register(String name, T block, @Nullable BlockItem item){
    ResourceLocation id = ExampleMod.getId(name);
    block.setRegistryName(id);
    ForgeRegistries.BLOCKS.register(block);
    if(item != null){
      ModItems.BLOCKS_TO_REGISTER.put(name,item);
    }
    return block;
  }
}