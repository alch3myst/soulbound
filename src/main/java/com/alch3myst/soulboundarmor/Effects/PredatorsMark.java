package com.alch3myst.soulboundarmor.Effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

public class PredatorsMark extends Effect {
    public PredatorsMark() {
        super(EffectType.HARMFUL, 13041700);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        if (entityLivingBaseIn.isAlive()) {
            entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, 1 + amplifier);
        }
    }

    // Re turn every 10 ticks (1 sec)
    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 25 == 0;
    }
}
