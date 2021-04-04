package com.alch3myst.soulboundarmor.Item.Weapons;

import com.alch3myst.soulboundarmor.Entity.Projectiles.PredatorArrow;
import com.alch3myst.soulboundarmor.Registry.ItemRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PredatorBow extends BowItem {

    public PredatorBow(Properties builder) {
        super(builder);
        initConfigOptions();
    }

    // Why?
    @OnlyIn(Dist.CLIENT)
    public void initConfigOptions() {
        ItemModelsProperties.registerProperty(this,new ResourceLocation("pull"),(p_210310_0_, p_210310_1_, p_210310_2_) -> {
            if (p_210310_2_ == null) {
                return 0.0F;
            } else {
                return !(p_210310_2_.getActiveItemStack().getItem() instanceof BowItem) ? 0.0F : (float)(p_210310_0_.getUseDuration() - p_210310_2_.getItemInUseCount()) / 20F;
            }
        });

        ItemModelsProperties.registerProperty(this, new ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) -> {
            return p_239428_2_ != null && p_239428_2_.isHandActive() && p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
        });
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;

            // Check if player are on creative mod or have a infinity mod
            boolean hasInfinity = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;

            // Ammunition type item
            ItemStack itemstack = playerentity.findAmmo(stack);

            int drawnTime = this.getUseDuration(stack) - timeLeft;
            drawnTime = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, drawnTime, !itemstack.isEmpty() || hasInfinity);
            if (drawnTime < 0) return;

            if (!itemstack.isEmpty() || hasInfinity) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float arrowVelocity = getArrowVelocity(drawnTime);
                if (!((double)arrowVelocity < 0.1D)) {
                    boolean creativeOrInfinity = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
                    if (!worldIn.isRemote) {
                        AbstractArrowEntity abstractarrowentity = new PredatorArrow(worldIn, playerentity);
                        abstractarrowentity = customArrow(abstractarrowentity);

                        float velocityMulti = 1.0F;
                        // If player are using a pred chest plate arrow travel 2x more fast
                        if (playerentity.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemRegistry.PREDATOR_CHESTPLATE.get()) {
                            velocityMulti = 2.0F;
                        }

                        abstractarrowentity.func_234612_a_(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, (arrowVelocity * velocityMulti) * 3.0F, 0.3F);
                        if (arrowVelocity == 1.0F) {
                            abstractarrowentity.setIsCritical(true);
                        }

                        int powerEnchantmentLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

                        if (powerEnchantmentLevel > 0) {
                            abstractarrowentity.setDamage( ( abstractarrowentity.getDamage() + (double)powerEnchantmentLevel * 0.5D + 0.5D) );
                        }

                        if (playerentity.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemRegistry.PREDATOR_CHESTPLATE.get()) {
                            abstractarrowentity.setDamage( abstractarrowentity.getDamage() * 2 + (double)powerEnchantmentLevel * 0.5D + 0.5D);

                            if (powerEnchantmentLevel > 0) {
                                abstractarrowentity.setDamage( abstractarrowentity.getDamage() * 2 + (double)powerEnchantmentLevel * 0.5D + 0.5D );
                            }
                        }

                        int knockBackEnchant = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
                        if (knockBackEnchant > 0) {
                            abstractarrowentity.setKnockbackStrength(knockBackEnchant);
                        }

                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                            abstractarrowentity.setFire(100);
                        }

                        stack.damageItem(1, playerentity, (p_220009_1_) -> {
                            p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
                        });
                        if (creativeOrInfinity || playerentity.abilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
                            abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        }

                        worldIn.addEntity(abstractarrowentity);
                    }

                    worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + arrowVelocity * 0.5F);
                    if (!creativeOrInfinity && !playerentity.abilities.isCreativeMode) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            playerentity.inventory.deleteStack(itemstack);
                        }
                    }

                    playerentity.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    public Item getItem() {
        return this;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 1001;
    }
}
