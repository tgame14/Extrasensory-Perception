package com.tgame.extraperception.items;

import com.tgame.extraperception.Settings;
import com.tgame.extraperception.utils.ESPCreativeTab;
import com.tgame.mods.coremod.prefabs.items.ItemBase;
import com.tgame.mods.libs.registry.Registry;
import net.minecraft.creativetab.CreativeTabs;

/**
 * @since 26/04/14
 * @author tgame14
 */
//@Registry.ItemData TODO: Do.
public class ItemCastingStick extends ItemBase
{
    public ItemCastingStick (CreativeTabs tab, String resource)
    {
        super(ESPCreativeTab.INSTANCE, Settings.RESOURCE_LOCATION);
    }


}
