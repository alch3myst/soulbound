package com.alch3myst.soulboundarmor.events;

import com.alch3myst.soulboundarmor.Registry.EffectRegistry;
import com.alch3myst.soulboundarmor.Registry.ItemRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class PlayerTickEvent {

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

    @SubscribeEvent
    public void fallDamage(LivingFallEvent event) {
        // Get current played world
        World w = event.getEntityLiving().world;

        // Bug fix if
        if (event.getEntityLiving() != null && event.getEntityLiving() instanceof PlayerEntity) {
            if (!w.isRemote) {
                PlayerEntity player = (PlayerEntity) event.getEntityLiving();

                // Cancel fall damage event for foes
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

    @SubscribeEvent
    public void itemDrops(LivingDropsEvent event) {

        LivingEntity entityLiving = event.getEntityLiving();
        World world = entityLiving.getEntityWorld();
        Collection<ItemEntity> drops = event.getDrops();

        // Skeleton drop
        if (entityLiving instanceof SkeletonEntity) {

            // Random chance calculator - 3% chance to drop
            if (new Random().nextFloat() <= 0.03F) {
                // Add drop
                drops.add(new ItemEntity(
                        world, // World
                        entityLiving.getPosX(), // Mob position
                        entityLiving.getPosY(),
                        entityLiving.getPosZ(),
                        new ItemStack(
                                ItemRegistry.BABY_SKELETON_LEG.get(), // Item to drop
                                new Random().nextInt(4)) // Quantity to drop
                        )
                );
            }
        }

        // Zombie drop
        if (entityLiving instanceof ZombieEntity) {

            // Random chance calculator - 5% chance to drop
            if (new Random().nextFloat() <= 0.05F) {

                // Add drop
                drops.add(new ItemEntity(
                                world, // World
                                entityLiving.getPosX(), // Mob position
                                entityLiving.getPosY(),
                                entityLiving.getPosZ(),
                                new ItemStack(
                                        ItemRegistry.HUNT_TRACE.get(), // Item to drop
                                        new Random().nextInt(4)) // Quantity to drop
                        )
                );
            }
        }

        // Pigman drop
        if (entityLiving instanceof ZombifiedPiglinEntity) {

            // Random chance calculator - 10% chance of drop
            if (new Random().nextFloat() <= 0.1F) {
                // Add drop
                drops.add(new ItemEntity(
                                world, // World
                                entityLiving.getPosX(), // Mob position
                                entityLiving.getPosY(),
                                entityLiving.getPosZ(),
                                new ItemStack(
                                        ItemRegistry.ZOMBIE_PIGMAN_FINGER.get(), // Item to drop
                                        new Random().nextInt(5)) // Quantity to drop
                        )
                );
            }
        }

        // Fox drop
        if (entityLiving instanceof FoxEntity) {

            // Drop 4 legs #don't kill foxes
            // Add drop
            drops.add(new ItemEntity(
                            world, // World
                            entityLiving.getPosX(), // Mob position
                            entityLiving.getPosY(),
                            entityLiving.getPosZ(),
                            new ItemStack(
                                    ItemRegistry.FOX_LEG.get(), // Item to drop
                                    4 ) // Quantity to drop
                    )
            );
        }

    }
}
