package com.tgame.extraperception.casting.spells;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.util.JsonException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * @since 22/04/14
 * @author tgame14
 */
public class SpellShaderBlobs implements ISpell
{
    private static ResourceLocation[] shaderResourceLocations;
    static
    {
        shaderResourceLocations = ReflectionHelper.getPrivateValue(EntityRenderer.class, Minecraft.getMinecraft().entityRenderer, "shaderResourceLocations");
    }

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
                mc.entityRenderer.theShaderGroup = new ShaderGroup(manager, mc.getFramebuffer(), shaderResourceLocations[2]);
                mc.entityRenderer.theShaderGroup.createBindFramebuffers(mc.displayWidth, mc.displayHeight);
            }
            catch (JsonException e)
            {
                e.printStackTrace();
            }
        }
    }
}
