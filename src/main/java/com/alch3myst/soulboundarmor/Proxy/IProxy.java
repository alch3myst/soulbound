package com.alch3myst.soulboundarmor.Proxy;

import net.minecraftforge.eventbus.api.IEventBus;

public interface IProxy {
    void setup(IEventBus modEventBuss, IEventBus forgeEventBus);
}
