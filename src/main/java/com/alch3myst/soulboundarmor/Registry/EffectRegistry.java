package com.alch3myst.soulboundarmor.Registry;

import com.alch3myst.soulboundarmor.Effects.PredatorsMark;
import com.alch3myst.soulboundarmor.SoulBound;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectRegistry {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, SoulBound.MOD_ID);

    public static void init() { EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus()); }

    // Pred Mark
    public static final RegistryObject<Effect> PRED_MARK = EFFECTS.register("predators_mark", PredatorsMark::new);
}
