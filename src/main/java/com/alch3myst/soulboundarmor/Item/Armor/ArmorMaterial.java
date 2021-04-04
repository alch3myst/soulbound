package com.alch3myst.soulboundarmor.Item.Armor;

import com.alch3myst.soulboundarmor.Registry.ItemRegistry;
import com.alch3myst.soulboundarmor.SoulBound;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ArmorMaterial implements IArmorMaterial {

    SOUL(SoulBound.MOD_ID + ":soul",
            700,
            new int[] {3,7,8,3},
            50,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            2.0F,
            0.1F,
            () -> {return Ingredient.fromItems(ItemRegistry.SOUL_INGOT.get());
    }),

    TEST(SoulBound.MOD_ID + ":test",
            700,
            new int[] {3,7,8,3},
            50,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            2.0F,
            0.1F,
            () -> {return Ingredient.fromItems(ItemRegistry.SOUL_INGOT.get());
            }),

    DEMON(SoulBound.MOD_ID + ":demon",
            1000,
            new int[] {4,8,9,4},
            50,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            3.0F,
            0.5F,
            () -> {return Ingredient.fromItems(ItemRegistry.SOUL_INGOT.get());
            }),

    PREDATOR(SoulBound.MOD_ID + ":predator",
            500,
            new int[] {3,6,8,3},
            50,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            2.0F,
            0.3F,
            () -> {return Ingredient.fromItems(ItemRegistry.PREDATOR_INGOT.get());
            });

    private static final int[] MAX_DAMAGE = new int[] {10, 11, 17, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReduction;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairMaterial;

    ArmorMaterial(String name, int maxDamageFactor, int[] damageReduction, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReduction = damageReduction;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE[slotIn.getIndex()] * maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReduction[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}
