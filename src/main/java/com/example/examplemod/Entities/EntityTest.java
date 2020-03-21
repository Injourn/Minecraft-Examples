package com.example.examplemod.Entities;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.init.ModEntities;

import net.minecraft.entity.CreatureEntity;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityTest extends CreatureEntity {
    
    public EntityTest(World worldIn) {
        super(ModEntities.TESTMOB, worldIn);        
    }
    
    public ResourceLocation getTexture(){
        return ExampleMod.getId("textures/entity/white_cow.png");
    }

}