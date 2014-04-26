package com.tgame.extraperception.casting.spells;

import com.tgame.extraperception.Settings;
import com.tgame.extraperception.api.ISpell;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.util.JsonException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Level;

/**
 * @since 22/04/14
 * @author tgame14
 */
public class SpellShaders implements ISpell
{
    private static ResourceLocation[] shaderResourceLocations = ReflectionHelper.getPrivateValue(EntityRenderer.class, Minecraft.getMinecraft().entityRenderer, "shaderResourceLocations");

    private int index = 0;

    @Override
    public void onSpellUse (EntityPlayer player)
    {
        if (player.getEntityWorld().isRemote)
        {
            Minecraft mc = Minecraft.getMinecraft();
            IResourceManager manager = ReflectionHelper.getPrivateValue(EntityRenderer.class, mc.entityRenderer,"resourceManager");
            try
            {
                if (mc.entityRenderer.isShaderActive())
                {
                    mc.entityRenderer.deactivateShader();
                    return;
                }

                if (mc.entityRenderer.theShaderGroup != null)
                {
                    mc.entityRenderer.theShaderGroup.deleteShaderGroup();
                }
                mc.entityRenderer.theShaderGroup = new ShaderGroup(manager, mc.getFramebuffer(), shaderResourceLocations[index]);
                mc.entityRenderer.theShaderGroup.createBindFramebuffers(mc.displayWidth, mc.displayHeight);
            }
            catch (JsonException e)
            {
                Settings.LOGGER.catching(Level.FATAL, e);
                e.printStackTrace();
            }
        }
        index++;
        if (index >= shaderResourceLocations.length)
        {
            index = 0;
        }
    }
}
