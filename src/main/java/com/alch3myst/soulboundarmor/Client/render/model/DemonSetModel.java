package com.alch3myst.soulboundarmor.Client.render.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class DemonSetModel extends BipedModel<LivingEntity> {

	public DemonSetModel(float size) {

		super(size, 0.0F, 64, 64);

		ModelRenderer HornL = new ModelRenderer(this);
		HornL.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedHead.addChild(HornL);
		HornL.setTextureOffset(50, 42).addBox(2.0F, -34.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		HornL.setTextureOffset(51, 43).addBox(2.0F, -33.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		HornL.setTextureOffset(51, 42).addBox(2.0F, -33.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		ModelRenderer HornsR = new ModelRenderer(this);
		HornsR.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedHead.addChild(HornsR);
		HornsR.setTextureOffset(55, 43).addBox(-3.0F, -33.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		HornsR.setTextureOffset(49, 43).addBox(-3.0F, -33.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		HornsR.setTextureOffset(52, 42).addBox(-3.0F, -34.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		ModelRenderer Armour = new ModelRenderer(this);
		Armour.setRotationPoint(0.0F, 24.0F, 0.0F);
		bipedBody.addChild(Armour);
		Armour.setTextureOffset(40, 32).addBox(-3.0F, -24.1F, -3.0F, 6.0F, 10.0F, 6.0F, 0.0F, false);

		ModelRenderer cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.8355F, -15.5582F, 2.3F);
		Armour.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.8727F, 0.0F);
		cube_r1.setTextureOffset(51, 38).addBox(-1.5F, -8.5F, -0.5F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		ModelRenderer RightArmArmour = new ModelRenderer(this);
		RightArmArmour.setRotationPoint(5.0F, 22.0F, 0.0F);
		bipedRightArm.addChild(RightArmArmour);
		RightArmArmour.setTextureOffset(44, 38).addBox(-8.7F, -24.2F, -3.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);

		ModelRenderer RightArm2_r1 = new ModelRenderer(this);
		RightArm2_r1.setRotationPoint(-8.0F, -20.3244F, 0.0627F);
		RightArmArmour.addChild(RightArm2_r1);
		setRotationAngle(RightArm2_r1, 0.7854F, 0.0F, 0.0F);
		RightArm2_r1.setTextureOffset(49, 39).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		ModelRenderer LeftArmArmour = new ModelRenderer(this);
		LeftArmArmour.setRotationPoint(-5.0F, 22.0F, 0.0F);
		bipedLeftArm.addChild(LeftArmArmour);
		LeftArmArmour.setTextureOffset(42, 38).addBox(5.0F, -24.6F, -3.0F, 4.0F, 3.0F, 6.0F, 0.0F, false);

		ModelRenderer LeftArm4_r1 = new ModelRenderer(this);
		LeftArm4_r1.setRotationPoint(9.3F, -22.7F, 0.0F);
		LeftArmArmour.addChild(LeftArm4_r1);
		setRotationAngle(LeftArm4_r1, 0.0F, 0.0F, 1.0385F);
		LeftArm4_r1.setTextureOffset(43, 40).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		ModelRenderer LeftArm3_r1 = new ModelRenderer(this);
		LeftArm3_r1.setRotationPoint(8.4F, -24.4F, 0.0F);
		LeftArmArmour.addChild(LeftArm3_r1);
		setRotationAngle(LeftArm3_r1, 0.0F, 0.0F, 0.3491F);
		LeftArm3_r1.setTextureOffset(45, 40).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		ModelRenderer LeftArm2_r1 = new ModelRenderer(this);
		LeftArm2_r1.setRotationPoint(6.5F, -25.3F, 0.0F);
		LeftArmArmour.addChild(LeftArm2_r1);
		setRotationAngle(LeftArm2_r1, 0.0F, 0.0F, -0.1745F);
		LeftArm2_r1.setTextureOffset(44, 40).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		ModelRenderer RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		bipedRightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		ModelRenderer Boots = new ModelRenderer(this);
		Boots.setRotationPoint(1.9F, 12.0F, 0.0F);
		bipedRightLeg.addChild(Boots);
		Boots.setTextureOffset(45, 38).addBox(-4.3F, -4.8F, -2.6F, 4.0F, 5.0F, 5.0F, 0.0F, false);

		ModelRenderer LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		bipedLeftLeg.setTextureOffset(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		ModelRenderer BootsL = new ModelRenderer(this);
		BootsL.setRotationPoint(4.5F, 0.0F, 0.1F);
		bipedLeftLeg.addChild(BootsL);
		BootsL.setTextureOffset(46, 38).addBox(-6.0F, 7.2F, -2.7F, 4.0F, 5.0F, 5.0F, 0.0F, false);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}