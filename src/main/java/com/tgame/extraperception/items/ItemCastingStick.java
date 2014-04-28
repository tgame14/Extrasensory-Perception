package com.tgame.extraperception.items;

import com.tgame.extraperception.Settings;
import com.tgame.extraperception.items.render.ItemCastingStickRenderer;
import com.tgame.extraperception.utils.ESPCreativeTab;
import com.tgame.mods.libs.prefabs.items.ItemBase;
import com.tgame.mods.libs.registry.Registry;

/**
 * @since 26/04/14
 * @author tgame14
 */
@Registry.ItemData(itemRenderer = ItemCastingStickRenderer.class)
public class ItemCastingStick extends ItemBase
{
    public ItemCastingStick ()
    {
        super(ESPCreativeTab.INSTANCE, Settings.RESOURCE_LOCATION);
    }


}
