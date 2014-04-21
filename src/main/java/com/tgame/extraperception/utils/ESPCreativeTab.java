package com.tgame.extraperception.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @since 21/04/14
 * @author tgame14
 */
public class ESPCreativeTab extends CreativeTabs
{
    public static ESPCreativeTab INSTANCE = new ESPCreativeTab(CreativeTabs.getNextID(), "tabESP");

    private ESPCreativeTab (int pos, String tabId)
    {
        super(pos, tabId);
    }

    @Override
    public ItemStack getIconItemStack ()
    {
        return new ItemStack(Blocks.bookshelf);
    }

    @Override
    public Item getTabIconItem ()
    {
        return null;
    }
}
