package com.alch3myst.soulboundarmor.Item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BaseItemDescription extends Item {

    private final String Tooltip;

    public BaseItemDescription(Properties properties, String tooltip) {
        super(properties);

        this.Tooltip = tooltip;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(ITextComponent.getTextComponentOrEmpty(this.Tooltip));
    }
}
