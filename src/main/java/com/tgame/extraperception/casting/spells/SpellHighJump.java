package com.tgame.extraperception.casting.spells;

import net.minecraft.entity.player.EntityPlayer;

/**
 * @since 22/04/14
 * @author tgame14
 */
public class SpellHighJump extends SpellBase
{
    @Override
    public void onSpellUse (EntityPlayer player)
    {
        if (player.onGround)
        {
            player.motionY = 1;
        }
    }
}
