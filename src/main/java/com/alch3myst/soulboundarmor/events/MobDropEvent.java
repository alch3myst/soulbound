package com.alch3myst.soulboundarmor.events;

import com.alch3myst.soulboundarmor.Registry.ItemRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;
import java.util.Random;

public class MobDropEvent {

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
