package com.example.examplemod.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Entities.EntityTestRenderer;
import com.example.examplemod.init.ModEntities;
import com.example.examplemod.network.PacketHandler;
import com.example.examplemod.network.message.MessageJump;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.ModId)
public class ClientHandler{
    @OnlyIn(Dist.CLIENT)
    public static void setup(){
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TESTMOB, EntityTestRenderer::new);
    }
    
    @SubscribeEvent
    public static void onKeyPress(InputEvent.KeyInputEvent event){        
        Minecraft player = Minecraft.getInstance(); 
        if(player.gameSettings.keyBindJump.isKeyDown() && event.getAction() == 1 && !player.player.isCreative()){ 
            PacketHandler.instance.sendToServer(new MessageJump(!player.player.onGround));
        }         
    }
}