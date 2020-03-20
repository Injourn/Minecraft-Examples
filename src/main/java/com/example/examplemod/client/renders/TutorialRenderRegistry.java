package com.example.examplemod.client.renders;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entities.TutorialEntity;
import com.example.examplemod.init.TutorialEntities;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class TutorialRenderRegistry{
    public static EntityType<TutorialEntity> tutorialEntity;
    public static void registryEntityRenders(){

        RenderingRegistry.registerEntityRenderingHandler((EntityType<TutorialEntity>)TutorialEntities.TUTORIAL_ENTITY, new TutorialEntityRender.RenderFactory());
        
    }
}