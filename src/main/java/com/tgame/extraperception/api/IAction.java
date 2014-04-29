package com.tgame.extraperception.api;

import net.minecraft.entity.player.EntityPlayer;

/**
 * This interface is a simple one to allow implementation of abilities easily.
 *
 * @since 22/04/14
 * @author tgame14
 */
public interface IAction
{
    public void onActionCalled (EntityPlayer player);

}
