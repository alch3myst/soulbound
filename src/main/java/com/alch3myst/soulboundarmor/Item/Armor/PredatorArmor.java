package com.alch3myst.soulboundarmor.Item.Armor;

import com.alch3myst.soulboundarmor.Client.proxy.ClientProxy;
import com.alch3myst.soulboundarmor.SoulBound;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class PredatorArmor extends ArmorItem {

    public PredatorArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
        super(materialIn, slot, builderIn );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {

        if (!player.isPotionActive(Effects.STRENGTH)) {
            player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 1000, 2));
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(ITextComponent.getTextComponentOrEmpty("Death to your enemies"));
        tooltip.add(ITextComponent.getTextComponentOrEmpty("Strength"));
    }

    // Custom model render
    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return SoulBound.PROXY instanceof ClientProxy ? ((ClientProxy) SoulBound.PROXY).getPredatorSetM(armorSlot) : null;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return "soulbound:textures/models/armor/predator_layer_1.png";
    }
}
