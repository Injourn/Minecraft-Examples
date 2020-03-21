package com.example.examplemod.init;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.Entities.EntityTest;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = ExampleMod.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities{
    private static final List<EntityType<?>> ENTITY_TYPES = new ArrayList<>();
    public static final EntityType<EntityTest> TESTMOB = build(ExampleMod.getId("example_entity"),EntityTest::new,0.5f,1f);
    
    private static <T extends Entity> EntityType<T> build(ResourceLocation id, Function<World, T> function, float width, float height)
    {
        EntityType<T> type = EntityType.Builder.<T>create((entityType, world) -> function.apply(world), EntityClassification.CREATURE).size(width, height).setCustomClientFactory((spawnEntity, world) -> function.apply(world)).build(id.toString());
        type.setRegistryName(id);
        ENTITY_TYPES.add(type);
        return type;
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void registerTypes(final RegistryEvent.Register<EntityType<?>> event)
    {
        IForgeRegistry<EntityType<?>> registry = event.getRegistry();
        ENTITY_TYPES.forEach(registry::register);
    }
}