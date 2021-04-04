package com.alch3myst.soulboundarmor.events;

import com.alch3myst.soulboundarmor.Registry.EffectRegistry;
import com.alch3myst.soulboundarmor.Registry.ItemRegistry;
import com.alch3myst.soulboundarmor.SoulBound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.Level;

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
                                aPlayer.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 1));
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
                event.player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.PREDATOR_BOOTS.get() ||
                event.player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.DEMON_BOOTS.get()
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


    // Cancel fall damage
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
                        player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.SOUL_BOUND_BOOTS.get() ||
                        player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ItemRegistry.DEMON_BOOTS.get()
                );
            }
        }
    }

    // Heal player while blocking when demon chest are equipped
    @SubscribeEvent
    public void LivingAttackEvent(LivingAttackEvent event) {

        // Check if the entity is a player (This fix the cast crash)
        if (event.getEntityLiving() != null && event.getEntity() instanceof PlayerEntity) {

            // Get player world
            World w = ((PlayerEntity) event.getEntityLiving()).world;

            if(!w.isRemote) {
                // Cast to player
                PlayerEntity player = ((PlayerEntity) event.getEntityLiving());

                if (player.isAlive()) {
                    // Heal the player on block a attack
                    if (
                            player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemRegistry.DEMON_CHESTPLATE.get() &&
                            player.isActiveItemStackBlocking()
                    ) {
                        player.heal(2.0F);
                    }
                }

            }
        }
    }

    // Apply predator mark on hit
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

                    // Add the pred mark effect
                    target.addPotionEffect(new EffectInstance(EffectRegistry.PRED_MARK.get(), 250, 1));

                    // Apply blindness
                    target.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 250, 0));
                }

                // If the predator has less then 2 hp apply a regen effect for 3 seconds (only one proc)
                if ( player.getHealth() <= 5.0F && !player.isPotionActive(Effects.REGENERATION) ) {
                    player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 0));
                }
            }
        }
    }

}
