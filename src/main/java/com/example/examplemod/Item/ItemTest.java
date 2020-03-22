package com.example.examplemod.Item;

import com.example.examplemod.ExampleMod;

import net.minecraft.item.Item;

public class ItemTest extends Item {
    
    public ItemTest(Properties properties){
        super(properties);
        this.setRegistryName(ExampleMod.getId("test_item"));
    }

    /*@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)*/
    

}