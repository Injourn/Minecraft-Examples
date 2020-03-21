package com.example.examplemod.Entities;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EntityTestRenderer extends MobRenderer<EntityTest, EntityTestModel> {

    public EntityTestRenderer(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new EntityTestModel(), 0.5f);
        
    }

    @Override
    public ResourceLocation getEntityTexture(EntityTest entity) {        
        return entity.getTexture();
    }

}