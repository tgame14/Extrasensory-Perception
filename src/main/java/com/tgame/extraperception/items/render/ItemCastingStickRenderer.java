package com.tgame.extraperception.items.render;

import com.tgame.extraperception.Settings;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.apache.logging.log4j.Marker;
import org.lwjgl.opengl.GL11;

/**
 * @since 26/04/14
 * @author tgame14
 */
public class ItemCastingStickRenderer implements IItemRenderer
{
    private Minecraft mc = Minecraft.getMinecraft();
    private RenderBlocks renderBlocksInstance = new RenderBlocks();

    public ItemCastingStickRenderer()
    {
        Settings.LOGGER.info("RENDERER ENABLED \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }


    @Override
    public boolean handleRenderType (ItemStack stack, ItemRenderType type)
    {
        return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
    }

    @Override
    public boolean shouldUseRenderHelper (ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRendererHelper)
    {
        return true;
    }

    @Override
    public void renderItem (ItemRenderType itemRenderType, ItemStack itemStack, Object... objects)
    {
        GL11.glPushMatrix();



        GL11.glPopMatrix();
    }
}
