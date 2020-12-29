package com.alch3myst.soulboundarmor.Item.Tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PastleItem extends Item {
    public PastleItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack item  = new ItemStack(this);
        item.attemptDamageItem(1, Item.random, null);
        return item;
    }

}
