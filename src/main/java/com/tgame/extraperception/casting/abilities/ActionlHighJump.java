package com.tgame.extraperception.casting.abilities;

import com.tgame.extraperception.api.IAction;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @since 22/04/14
 * @author tgame14
 */
public class ActionlHighJump implements IAction
{
    @Override
    public void onActionCalled (EntityPlayer player)
    {
        if (player.onGround)
        {
            player.motionY = 1;
        }
    }
}
