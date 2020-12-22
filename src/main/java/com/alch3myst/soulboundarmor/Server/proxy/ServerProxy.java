package com.alch3myst.soulboundarmor.Server.proxy;

import com.alch3myst.soulboundarmor.Proxy.IProxy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ServerProxy implements IProxy {
    @Override
    public void setup(IEventBus modEventBuss, IEventBus forgeEventBus) {
        forgeEventBus.addListener(this::serverSetup);
    }

    private void serverSetup(final FMLClientSetupEvent event) {}
}
