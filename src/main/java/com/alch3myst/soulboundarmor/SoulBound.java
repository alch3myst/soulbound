package com.alch3myst.soulboundarmor;

import com.alch3myst.soulboundarmor.Client.proxy.ClientProxy;
import com.alch3myst.soulboundarmor.Item.Weapons.PredatorBow;
import com.alch3myst.soulboundarmor.Proxy.IProxy;
import com.alch3myst.soulboundarmor.Registry.EffectRegistry;
import com.alch3myst.soulboundarmor.Registry.ItemRegistry;
import com.alch3myst.soulboundarmor.Server.proxy.ServerProxy;
import com.alch3myst.soulboundarmor.events.MobDropEvent;
import com.alch3myst.soulboundarmor.events.PlayerEvent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("soulbound")
public class SoulBound
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "soulbound";

    public static final IProxy PROXY = DistExecutor.safeRunForDist( () -> ClientProxy::new, () -> ServerProxy::new);

    public SoulBound() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus(),
                forgeEventBus = MinecraftForge.EVENT_BUS;

        PROXY.setup(modEventBus, forgeEventBus);

        modEventBus.addListener(this::commonSetup);
        forgeEventBus.addListener(this::doClientStuff);

        // Register Items
        ItemRegistry.init();

        // Register Effects
        EffectRegistry.init();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new PlayerEvent());
        MinecraftForge.EVENT_BUS.register(new MobDropEvent());
    }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    // Creative tab registry
    public static final ItemGroup TAB = new ItemGroup("soulBoundTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistry.DIAMOND_DUST.get());
        }
    };
}
