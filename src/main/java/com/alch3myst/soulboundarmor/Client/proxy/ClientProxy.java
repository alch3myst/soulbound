package com.alch3myst.soulboundarmor.Client.proxy;

import com.alch3myst.soulboundarmor.Proxy.IProxy;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import com.alch3myst.soulboundarmor.Client.render.model.*;

public class ClientProxy implements IProxy {
    @Override
    public void setup(IEventBus modEventBuss, IEventBus forgeEventBus) {
        modEventBuss.addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) { }

    // Soulbound Custom Armor model sizes
    private final SoulBoundSetModel soulArmor = new SoulBoundSetModel(0.3F);
    private final SoulBoundSetModel soulLegs = new SoulBoundSetModel(0.1F);

    // Return re-sized armor
    @SuppressWarnings("unchecked")
    public <A extends BipedModel<?>> A getSoulBoundSet(EquipmentSlotType armorSlot) {
        return (A) (armorSlot == EquipmentSlotType.LEGS ? soulLegs : soulArmor);
    }

    // Predator Custom Armor model sizes
    private final PredatorSetModel predArmor = new PredatorSetModel(0.3F);
    private final PredatorSetModel predLegs = new PredatorSetModel(0.1F);

    // Return re-sized armor
    @SuppressWarnings("unchecked")
    public <A extends BipedModel<?>> A getPredatorSetM(EquipmentSlotType armorSlot) {
        return (A) (armorSlot == EquipmentSlotType.LEGS ? predLegs : predArmor);
    }
}
