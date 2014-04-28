package com.tgame.extraperception.armor;

import com.tgame.extraperception.Settings;
import com.tgame.extraperception.utils.ESPCreativeTab;
import com.tgame.extraperception.utils.ESPItemHelper;
import com.tgame.mods.libs.prefabs.items.ItemArmorBase;

/**
 * @since 21/04/14
 * @author tgame14
 */
public class ItemShamanArmor extends ItemArmorBase
{
    public ItemShamanArmor (int renderIndex, int armorType)
    {
        super(ESPItemHelper.armorMaterialUnprotective, renderIndex, armorType, Settings.RESOURCE_LOCATION, ESPCreativeTab.INSTANCE);
    }

}
