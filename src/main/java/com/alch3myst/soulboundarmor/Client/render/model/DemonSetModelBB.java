// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

/*
public class steve extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer HornL;
	private final ModelRenderer HornsR;
	private final ModelRenderer Body;
	private final ModelRenderer Armour;
	private final ModelRenderer cube_r1;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArmArmour;
	private final ModelRenderer RightArm2_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArmArmour;
	private final ModelRenderer LeftArm4_r1;
	private final ModelRenderer LeftArm3_r1;
	private final ModelRenderer LeftArm2_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Boots;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer BootsL;

	public steve() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		HornL = new ModelRenderer(this);
		HornL.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.addChild(HornL);
		HornL.setTextureOffset(50, 42).addBox(2.0F, -34.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		HornL.setTextureOffset(51, 43).addBox(2.0F, -33.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		HornL.setTextureOffset(51, 42).addBox(2.0F, -33.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		HornsR = new ModelRenderer(this);
		HornsR.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.addChild(HornsR);
		HornsR.setTextureOffset(55, 43).addBox(-3.0F, -33.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		HornsR.setTextureOffset(49, 43).addBox(-3.0F, -33.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		HornsR.setTextureOffset(52, 42).addBox(-3.0F, -34.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		Armour = new ModelRenderer(this);
		Armour.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.addChild(Armour);
		Armour.setTextureOffset(40, 32).addBox(-3.0F, -24.1F, -3.0F, 6.0F, 10.0F, 6.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.8355F, -15.5582F, 2.3F);
		Armour.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.8727F, 0.0F);
		cube_r1.setTextureOffset(51, 38).addBox(-1.5F, -8.5F, -0.5F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightArmArmour = new ModelRenderer(this);
		RightArmArmour.setRotationPoint(5.0F, 22.0F, 0.0F);
		RightArm.addChild(RightArmArmour);
		RightArmArmour.setTextureOffset(44, 38).addBox(-8.7F, -24.2F, -3.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);

		RightArm2_r1 = new ModelRenderer(this);
		RightArm2_r1.setRotationPoint(-8.0F, -20.3244F, 0.0627F);
		RightArmArmour.addChild(RightArm2_r1);
		setRotationAngle(RightArm2_r1, 0.7854F, 0.0F, 0.0F);
		RightArm2_r1.setTextureOffset(49, 39).addBox(-0.5F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.setTextureOffset(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftArmArmour = new ModelRenderer(this);
		LeftArmArmour.setRotationPoint(-5.0F, 22.0F, 0.0F);
		LeftArm.addChild(LeftArmArmour);
		LeftArmArmour.setTextureOffset(42, 38).addBox(5.0F, -24.6F, -3.0F, 4.0F, 3.0F, 6.0F, 0.0F, false);

		LeftArm4_r1 = new ModelRenderer(this);
		LeftArm4_r1.setRotationPoint(9.3F, -22.7F, 0.0F);
		LeftArmArmour.addChild(LeftArm4_r1);
		setRotationAngle(LeftArm4_r1, 0.0F, 0.0F, 1.0385F);
		LeftArm4_r1.setTextureOffset(43, 40).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		LeftArm3_r1 = new ModelRenderer(this);
		LeftArm3_r1.setRotationPoint(8.4F, -24.4F, 0.0F);
		LeftArmArmour.addChild(LeftArm3_r1);
		setRotationAngle(LeftArm3_r1, 0.0F, 0.0F, 0.3491F);
		LeftArm3_r1.setTextureOffset(45, 40).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		LeftArm2_r1 = new ModelRenderer(this);
		LeftArm2_r1.setRotationPoint(6.5F, -25.3F, 0.0F);
		LeftArmArmour.addChild(LeftArm2_r1);
		setRotationAngle(LeftArm2_r1, 0.0F, 0.0F, -0.1745F);
		LeftArm2_r1.setTextureOffset(44, 40).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		Boots = new ModelRenderer(this);
		Boots.setRotationPoint(1.9F, 12.0F, 0.0F);
		RightLeg.addChild(Boots);
		Boots.setTextureOffset(45, 38).addBox(-4.3F, -4.8F, -2.6F, 4.0F, 5.0F, 5.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.setTextureOffset(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		BootsL = new ModelRenderer(this);
		BootsL.setRotationPoint(4.5F, 0.0F, 0.1F);
		LeftLeg.addChild(BootsL);
		BootsL.setTextureOffset(46, 38).addBox(-6.0F, 7.2F, -2.7F, 4.0F, 5.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}*/