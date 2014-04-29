package com.tgame.extraperception.items;

import com.tgame.extraperception.Settings;
import com.tgame.extraperception.utils.ESPCreativeTab;
import com.tgame.mods.libs.prefabs.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;

/**
 * @since 28/04/14
 * @author tgame14
 */
public class ESPAbstractItem extends ItemBase
{
    public ESPAbstractItem (boolean singleTexture)
    {
        super(ESPCreativeTab.INSTANCE, Settings.RESOURCE_LOCATION, singleTexture);
    }
}
