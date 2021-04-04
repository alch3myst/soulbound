package com.alch3myst.soulboundarmor.Item.Weapons;

import com.alch3myst.soulboundarmor.Registry.ItemRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class PredatorKatana extends SwordItem {

    public PredatorKatana(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    private final float dashRange = 1.2F;
    private long start = System.currentTimeMillis();

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        // If player are with pred chest plate activate skill
        if (playerIn.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ItemRegistry.PREDATOR_CHESTPLATE.get()) {

            // Only in client side
            if (worldIn.isRemote) {

                // skill cd 1s
                final long cd = 1000;

                // Check if skill are not on cd
                if (playerIn.isAlive() && System.currentTimeMillis() >= start + cd) {

                    // Get the player camera direction
                    final Vector3d lookingAt = playerIn.getLookVec();

                    // Set the final dash "distance"
                    playerIn.addVelocity(lookingAt.x * dashRange, lookingAt.y * dashRange, lookingAt.z * dashRange);

                    // Put skill on cd
                    start = System.currentTimeMillis();
                }
            }
        }

        // return to minecraft be happy
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
