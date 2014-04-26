package com.tgame.extraperception.items.render;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

/**
 * @since 26/04/14
 * @author tgame14
 */
public class ItemCastingStickRenderer implements IItemRenderer
{
    @Override
    public boolean handleRenderType (ItemStack itemStack, ItemRenderType itemRenderType)
    {
        return false;
    }

    @Override
    public boolean shouldUseRenderHelper (ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRendererHelper)
    {
        return false;
    }

    @Override
    public void renderItem (ItemRenderType itemRenderType, ItemStack itemStack, Object... objects)
    {

    }
}
