package com.alch3myst.soulboundarmor.Item.Tools;

import com.alch3myst.soulboundarmor.Registry.ItemRegistry;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ItemTiers implements IItemTier {

    SOUL(3, 0,  10.0F, 10.0F, 27, () -> {
        return Ingredient.fromItems(ItemRegistry.SOUL_BOUND_SWORD.get());
    });

    private final Supplier<Ingredient> repairMaterial;
    private final int harvestlevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;

    ItemTiers(int harvestlevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial){
        this.harvestlevel = harvestlevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }


    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestlevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
