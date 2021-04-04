package com.alch3myst.soulboundarmor.Registry;

import com.alch3myst.soulboundarmor.Item.Armor.*;
import com.alch3myst.soulboundarmor.Item.BaseItemDescription;
import com.alch3myst.soulboundarmor.Item.Weapons.PredatorBow;
import com.alch3myst.soulboundarmor.Item.Weapons.PredatorKatana;
import com.alch3myst.soulboundarmor.Item.Weapons.WeaponTier;
import com.alch3myst.soulboundarmor.SoulBound;
import com.alch3myst.soulboundarmor.Item.Tools.IronBowl;
import com.alch3myst.soulboundarmor.Item.Tools.PastleItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {

    // Item registry
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SoulBound.MOD_ID);

    // Registry event
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Diamond Dust
    public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Obsidian
    public static final RegistryObject<Item> OBSIDIAN_DUST = ITEMS.register("obsidian_dust", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Soul Dust
    public static final RegistryObject<Item> SOUL_DUST = ITEMS.register("soul_dust", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Predator Dust
    public static final RegistryObject<Item> PREDATOR_DUST = ITEMS.register("predator_dust", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Soul Ingot
    public static final RegistryObject<Item> SOUL_INGOT = ITEMS.register("soul_ingot", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Soul Ingot
    public static final RegistryObject<Item> REINFORCED_STRING = ITEMS.register("reinforced_string", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Predator Ingot
    public static final RegistryObject<Item> PREDATOR_INGOT = ITEMS.register("predator_ingot", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    public static final RegistryObject<Item> BABY_SKELETON_LEG = ITEMS.register("skeleton_leg", () -> new BaseItemDescription(
            new Item.Properties().group(SoulBound.TAB),
            "Rare drop form Skeletons"));

    // Pigman Finger
    public static final RegistryObject<Item> ZOMBIE_PIGMAN_FINGER = ITEMS.register("zombie_pigman_finger", () -> new BaseItemDescription(
            new Item.Properties().group(SoulBound.TAB),
            "Rare drop from Zombified Piglin") );

    public static final RegistryObject<Item> FOX_LEG = ITEMS.register("fox_leg", () -> new BaseItemDescription(
            new Item.Properties().group(SoulBound.TAB),
            "U only need to kill one fox ;l") );


    public static final RegistryObject<Item> HUNT_TRACE = ITEMS.register("hunt_trace", () -> new BaseItemDescription(
            new Item.Properties().group(SoulBound.TAB),
            "Rare drop from Zombies") );

    // Iron Bow
    public static final RegistryObject<Item> IRON_BOWL = ITEMS.register("iron_bowl", () -> new IronBowl(new Item.Properties().group(SoulBound.TAB).defaultMaxDamage(1000)) );

    // Pastle
    public static final RegistryObject<Item> PASTLE = ITEMS.register("pastle", () -> new PastleItem(new Item.Properties().group(SoulBound.TAB).defaultMaxDamage(1000)) );

    /******** Souls **********/
    // Healing Soul
    public static final RegistryObject<Item> HEALING_SOUL = ITEMS.register("healing_soul", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Haste Soul
    public static final RegistryObject<Item> HASTE_SOUL = ITEMS.register("haste_soul", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Fly soul
    public static final RegistryObject<Item> FLY_SOUL = ITEMS.register("fly_soul", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Speed soul
    public static final RegistryObject<Item> SPEED_SOUL = ITEMS.register("speed_soul", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Jumping Soul
    public static final RegistryObject<Item> JUMP_SOUL = ITEMS.register("jumping_soul", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Sea Soul
    public static final RegistryObject<Item> SEA_SOUL = ITEMS.register("sea_soul", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Night eye soul
    public static final RegistryObject<Item> NIGHT_EYE_SOUL = ITEMS.register("night_eye_soul", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Predator soul
    public static final RegistryObject<Item> PREDATOR_SOUL = ITEMS.register("predator_soul", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    // Poison soul
    public static final RegistryObject<Item> POISON_SOUL = ITEMS.register("poison_soul", () -> new Item(new Item.Properties().group(SoulBound.TAB)) );

    /* Soul Bound Armor Set */
    public static final RegistryObject<ArmorItem> SOUL_BOUND_CHESTPLATE = ITEMS.register("soulbound_chestplate", () ->
            new SoulBoundArmor(ArmorMaterial.SOUL, EquipmentSlotType.CHEST, new Item.Properties().group(SoulBound.TAB)) );

    public static final RegistryObject<ArmorItem> SOUL_BOUND_HELMET = ITEMS.register("soulbound_helmet", () ->
            new SoulBoundHelmet(ArmorMaterial.SOUL, EquipmentSlotType.HEAD, new Item.Properties().group(SoulBound.TAB)));

    public static final RegistryObject<ArmorItem> SOUL_BOUND_LEGS = ITEMS.register("soulbound_legs", () ->
            new SoulBoundLeggs(ArmorMaterial.SOUL, EquipmentSlotType.LEGS, new Item.Properties().group(SoulBound.TAB)));

    public static final RegistryObject<ArmorItem> SOUL_BOUND_BOOTS = ITEMS.register("soulbound_boots", () ->
            new SoulBoundBoots(ArmorMaterial.SOUL, EquipmentSlotType.FEET, new Item.Properties().group(SoulBound.TAB)));


    /* Predators Armor Set */
    public static final RegistryObject<ArmorItem> PREDATOR_CHESTPLATE = ITEMS.register("predator_chestplate", () ->
            new PredatorArmor(ArmorMaterial.PREDATOR, EquipmentSlotType.CHEST, new Item.Properties().group(SoulBound.TAB)) );

    public static final RegistryObject<ArmorItem> PREDATOR_HELMET = ITEMS.register("predator_helmet", () ->
            new PredatorHelmet(ArmorMaterial.PREDATOR, EquipmentSlotType.HEAD, new Item.Properties().group(SoulBound.TAB)));

    public static final RegistryObject<ArmorItem> PREDATOR_LEGS = ITEMS.register("predator_legs", () ->
            new PredatorLeggs(ArmorMaterial.PREDATOR, EquipmentSlotType.LEGS, new Item.Properties().group(SoulBound.TAB)));

    public static final RegistryObject<ArmorItem> PREDATOR_BOOTS = ITEMS.register("predator_boots", () ->
            new PredatorBoots(ArmorMaterial.PREDATOR, EquipmentSlotType.FEET, new Item.Properties().group(SoulBound.TAB)));

    // Predator weapons
    /*Pred katana*/
    public static final RegistryObject<SwordItem> PREDATOR_KATANA = ITEMS.register("predator_katana", () ->
            new PredatorKatana(WeaponTier.PREDATOR, 5, -2.6F, new Item.Properties().group(SoulBound.TAB) ));

    /* Pred bow */
    public static final RegistryObject<BowItem> PREDATOR_BOW = ITEMS.register("predator_bow", () ->
            new PredatorBow(new Item.Properties().group(SoulBound.TAB) ));

    /* Demon Armor Set */
    public static final RegistryObject<ArmorItem> DEMON_CHESTPLATE = ITEMS.register("demon_chestplate", () ->
            new DemonArmor(ArmorMaterial.DEMON, EquipmentSlotType.CHEST, new Item.Properties().group(SoulBound.TAB)) );

    public static final RegistryObject<ArmorItem> DEMON_HELMET = ITEMS.register("demon_helmet", () ->
            new DemonHelmet(ArmorMaterial.DEMON, EquipmentSlotType.HEAD, new Item.Properties().group(SoulBound.TAB)));

    public static final RegistryObject<ArmorItem> DEMON_LEGS = ITEMS.register("demon_legs", () ->
            new DemonLeggs(ArmorMaterial.DEMON, EquipmentSlotType.LEGS, new Item.Properties().group(SoulBound.TAB)));

    public static final RegistryObject<ArmorItem> DEMON_BOOTS = ITEMS.register("demon_boots", () ->
            new DemonBoots(ArmorMaterial.DEMON, EquipmentSlotType.FEET, new Item.Properties().group(SoulBound.TAB)));

}
