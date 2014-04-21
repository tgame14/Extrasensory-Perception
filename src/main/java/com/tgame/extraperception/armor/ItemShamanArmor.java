package com.tgame.extraperception.armor;

import com.tgame.extraperception.utils.ESPItemHelper;
import net.minecraft.item.ItemArmor;

/**
 * @since 21/04/14
 * @author tgame14
 */
public class ItemShamanArmor extends ItemArmor
{
    public ItemShamanArmor (int renderIndex, int armorType)
    {
        super(ESPItemHelper.armorMaterialUnprotective, renderIndex, armorType);
    }

}
