package com.alch3myst.soulboundarmor.events;

import com.alch3myst.soulboundarmor.Registry.EffectRegistry;
import com.alch3myst.soulboundarmor.Registry.ItemRegistry;
import com.alch3myst.soulboundarmor.SoulBound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

import java.util.List;

public class PlayerEvent {

    @SubscribeEvent
    public void onLivingUpdateEvent(LivingJumpEvent event)
    {
        // Full soul bound armor set
        if (event.getEntityLiving() != null) {
            if (event.getEntityLiving() instanceof PlayerEntity) {

                // Get current played world and player
                World w = ((PlayerEntity)event.getEntityLiving()).world;
                PlayerEntity player = ((PlayerEntity) event.getEntityLiving());

                if ( // If wearing Full soul bound set
                    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.SOUL_BOUND_BOOTS.get() &&
                    player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemRegistry.SOUL_BOUND_LEGS.get() &&
                    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemRegistry.SOUL_BOUND_CHESTPLATE.get() &&
                    player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemRegistry.SOUL_BOUND_HELMET.get()
                ) {

                    if ( !w.isRemote ) {
                        // Get all players in a 10 blocks radius
                        List<PlayerEntity> playersAround = w.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(
                                player.lastTickPosX - 10,
                                player.lastTickPosY - 10,
                                player.lastTickPosZ - 10,
                                player.lastTickPosX + 10,
                                player.lastTickPosY + 10,
                                player.lastTickPosZ + 10
                        ));

                        // For each player add a regeneration effect for 10 seconds
                        for (PlayerEntity aPlayer : playersAround) {
                            if ( !aPlayer.isPotionActive(Effects.REGENERATION) ) {
                                aPlayer.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 0));
                            }
                        }
                    }

                    // check if the player can't fly
                    if (w.isRemote && !player.abilities.allowFlying ) {
                        // Set fly mode to true
                        player.abilities.allowFlying = true;
                    }

                } else { // If not wearing the full set
                    if (w.isRemote()) {
                        // Set fly mode to creative state
                        player.abilities.allowFlying = player.isCreative();
                    }
                }

            }
        }
    }

    /***** Step Assist Update *****/
    private boolean stepAssist = true;
    @SubscribeEvent
    public void slotChang(TickEvent.PlayerTickEvent event) {

        // Client End Tick
        if (event.phase == TickEvent.Phase.END && event.side == LogicalSide.CLIENT) {

            // Check if player has any boot equipped
            if (
                event.player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.SOUL_BOUND_BOOTS.get() ||
                event.player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.PREDATOR_BOOTS.get()
            ) {
                if (stepAssist) {
                    // Set step to one block
                    event.player.stepHeight = 1.0F;

                    stepAssist = false;
                }

            } else { // If boots are not quipped check if step are not default

                // Set step to default
                event.player.stepHeight = 0.6F;

                stepAssist = true;
            }
        }
    }
    /******End Step Assist Update*********/

    @SubscribeEvent
    public void fallDamage(LivingFallEvent event) {
        // Get current played world
        World w = event.getEntityLiving().world;

        // Bug fix if
        if (event.getEntityLiving() != null && event.getEntityLiving() instanceof PlayerEntity) {
            if (!w.isRemote) {
                PlayerEntity player = (PlayerEntity) event.getEntityLiving();

                // Cancel fall damage event
                event.setCanceled(
                        player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.PREDATOR_BOOTS.get() ||
                        player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.SOUL_BOUND_BOOTS.get()
                );
            }
        }
    }

    @SubscribeEvent
    public void onDamageAnything(AttackEntityEvent event)
    {
        // Get current player world
        World w = ((PlayerEntity)event.getEntityLiving()).world;

        if (!w.isRemote) {

            PlayerEntity player = ((PlayerEntity) event.getEntityLiving());
            // Predator 4 armor piece bonus
            if ( // If wearing Full predator set
                    player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.PREDATOR_BOOTS.get() &&
                    player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ItemRegistry.PREDATOR_LEGS.get() &&
                    player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemRegistry.PREDATOR_CHESTPLATE.get() &&
                    player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ItemRegistry.PREDATOR_HELMET.get()
            ) {
                // If foe is alive
                if (event.getTarget().isAlive()) {

                    // Get current target
                    LivingEntity target = (LivingEntity) event.getTarget();

                    // Add the pred's mark effect
                    target.addPotionEffect(new EffectInstance(EffectRegistry.PRED_MARK.get(), 100, 1));

                    // Apply blindness
                    target.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 100, 0));
                }

                // If the predator has less then 2 hp apply a regen effect for 3 seconds (only one proc)
                if ( player.getHealth() <= 2.0F && !player.isPotionActive(Effects.REGENERATION) ) {
                    player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 30, 0));
                }
            }
        }
    }
}
