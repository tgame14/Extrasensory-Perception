package com.tgame.extraperception.proxies;

import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * @since 21/04/14
 * @author tgame14
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public int addArmor (String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
}
