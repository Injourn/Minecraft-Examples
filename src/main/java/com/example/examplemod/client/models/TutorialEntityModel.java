package com.example.examplemod.client.models;

import com.example.examplemod.entities.TutorialEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.CowModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TutorialEntityModel extends CowModel<TutorialEntity>/*For custom model EntityModel<TutorialEntity> */ {

    /*@Override
    public void func_225597_a_(TutorialEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_,
            float p_225597_5_, float p_225597_6_) {
        // TODO Auto-generated method stub

    }

    @Override
    public void func_225598_a_(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_,
            float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        // TODO Auto-generated method stub

    }*/

}
