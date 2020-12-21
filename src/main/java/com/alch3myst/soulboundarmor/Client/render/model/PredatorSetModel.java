package com.alch3myst.soulboundarmor.Client.render.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class PredatorSetModel extends BipedModel<LivingEntity> {

	public PredatorSetModel(float size) {

		super(size, 0.0F, 64, 64);

		ModelRenderer mouthDecoration = new ModelRenderer(this);
		mouthDecoration.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedHead.addChild(mouthDecoration);
		mouthDecoration.setTextureOffset(58, 59).addBox(-0.4F, -26.4F, -5.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		mouthDecoration.setTextureOffset(58, 59).addBox(-2.0F, -25.6F, -4.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		mouthDecoration.setTextureOffset(60, 60).addBox(1.2F, -25.9F, -4.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		mouthDecoration.setTextureOffset(60, 60).addBox(2.6F, -26.1F, -4.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		mouthDecoration.setTextureOffset(60, 60).addBox(-3.4F, -26.1F, -4.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer headDecoration = new ModelRenderer(this);
		headDecoration.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(headDecoration);

		ModelRenderer leftArmDecoration = new ModelRenderer(this);
		leftArmDecoration.setRotationPoint(-5.0F, 22.0F, 0.0F);
		bipedLeftArm.addChild(leftArmDecoration);
		leftArmDecoration.setTextureOffset(52, 56).addBox(9.0F, -20.0F, 0.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		ModelRenderer rightArmDecoration = new ModelRenderer(this);
		rightArmDecoration.setRotationPoint(-14.0F, 23.0F, 0.0F);
		bipedRightArm.addChild(rightArmDecoration);
		rightArmDecoration.setTextureOffset(52, 55).addBox(9.0F, -21.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}