package com.example.examplemod;

import com.example.examplemod.Command.SimpleCommand;
import com.example.examplemod.capabilities.JumpingDataHandler;
import com.example.examplemod.client.ClientHandler;
import com.example.examplemod.init.ModBlocks;
import com.example.examplemod.network.PacketHandler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;


public class SideProxy {
    SideProxy(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, ModBlocks::registerAll);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, ModBlocks::registerAllBlock);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Client::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private static void commonSetup(FMLCommonSetupEvent event){
        PacketHandler.register();
        JumpingDataHandler.register();
    }
    private static void enqueueIMC(final InterModEnqueueEvent event)
    {        
    }

    private static void processIMC(final InterModProcessEvent event)
    {
    }
    @SubscribeEvent
    public static void clientStarting(FMLLoader event){
    }
    @SubscribeEvent
    public static void serverStarting(FMLServerStartingEvent event){
        //SimpleCommand.register(event.getCommandDispatcher());
    }
    
    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event){
        SimpleCommand.register(event.getDispatcher());
    }
    static class Client extends SideProxy{
        Client(){
            
        }
        private static void clientSetup(FMLClientSetupEvent event){
            ClientHandler.setup();
        }
    }
    static class Server extends SideProxy{
        Server(){
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Server::serverSetup);
        }
        private static void serverSetup(FMLDedicatedServerSetupEvent event){

        }
    }
}