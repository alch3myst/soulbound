package com.alch3myst.soulboundarmor.Client.render.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class SoulBoundSetModel extends BipedModel<LivingEntity> {

	public SoulBoundSetModel(float size) {

		super(size, 0.0F, 64, 64);

		ModelRenderer headDecoration = new ModelRenderer(this);
		headDecoration.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedHead.addChild(headDecoration);
		headDecoration.setTextureOffset(50, 48).addBox(-1.0F, -33.0F, -5.0F, 2.0F, 11.0F, 5.0F, 0.0F, false);

		ModelRenderer headDecorationLeft = new ModelRenderer(this);
		headDecorationLeft.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedHead.addChild(headDecorationLeft);
		headDecorationLeft.setTextureOffset(56, 51).addBox(2.0F, -29.0F, -5.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);

		ModelRenderer headDecorationRight = new ModelRenderer(this);
		headDecorationRight.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedHead.addChild(headDecorationRight);
		headDecorationRight.setTextureOffset(56, 51).addBox(-3.0F, -29.0F, -5.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);

		ModelRenderer bodyDecoration = new ModelRenderer(this);
		bodyDecoration.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedBody.addChild(bodyDecoration);
		bodyDecoration.setTextureOffset(47, 51).addBox(-1.0F, -26.0F, 5.0F, 2.0F, 11.0F, 1.0F, 0.0F, false);

		ModelRenderer bodyDecorationLeft = new ModelRenderer(this);
		bodyDecorationLeft.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedBody.addChild(bodyDecorationLeft);
		bodyDecorationLeft.setTextureOffset(47, 51).addBox(3.0F, -22.0F, 5.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		ModelRenderer bodyDecorationRight = new ModelRenderer(this);
		bodyDecorationRight.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedBody.addChild(bodyDecorationRight);
		bodyDecorationRight.setTextureOffset(47, 51).addBox(-4.0F, -27.0F, 5.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		ModelRenderer rightLegDec = new ModelRenderer(this);
		rightLegDec.setRotationPoint(1.9F, 12.0F, 0.0F);
		bipedRightLeg.addChild(rightLegDec);
		rightLegDec.setTextureOffset(22, 57).addBox(-5.0F, -2.0F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		ModelRenderer leftLegDec = new ModelRenderer(this);
		leftLegDec.setRotationPoint(-1.9F, 12.0F, 0.0F);
		bipedLeftLeg.addChild(leftLegDec);
		leftLegDec.setTextureOffset(22, 57).addBox(2.0F, -2.0F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		ModelRenderer leftHandDecoration = new ModelRenderer(this);
		leftHandDecoration.setRotationPoint(-5.0F, 22.0F, 0.0F);
		bipedLeftArm.addChild(leftHandDecoration);
		leftHandDecoration.setTextureOffset(22, 57).addBox(3.0F, -15.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);

		ModelRenderer rightHandDecoration = new ModelRenderer(this);
		rightHandDecoration.setRotationPoint(5.0F, 22.0F, 0.0F);
		bipedRightArm.addChild(rightHandDecoration);
		rightHandDecoration.setTextureOffset(22, 57).addBox(-9.0F, -15.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}