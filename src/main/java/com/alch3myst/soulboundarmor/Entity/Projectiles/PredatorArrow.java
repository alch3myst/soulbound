package com.alch3myst.soulboundarmor.Entity.Projectiles;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class PredatorArrow extends ArrowEntity {
    public PredatorArrow(World worldIn, LivingEntity shooter) {
        super(worldIn, shooter);
    }

    @Override
    protected void arrowHit(LivingEntity living) {
        super.arrowHit(living);

        // Add poison effect on hit
        living.addPotionEffect(new EffectInstance(Effects.POISON, 500, 1));
    }
}
