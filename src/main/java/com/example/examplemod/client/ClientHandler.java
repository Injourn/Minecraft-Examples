package com.example.examplemod.client;

import com.example.examplemod.Entities.EntityTestRenderer;
import com.example.examplemod.init.ModEntities;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class ClientHandler{
    public static void setup(){
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TESTMOB, EntityTestRenderer::new);
    }
}