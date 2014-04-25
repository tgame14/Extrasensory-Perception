package com.tgame.extraperception.casting.spells;

import com.tgame.extraperception.api.ISpell;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @since 22/04/14
 * @author tgame14
 */
public class SpellHighJump implements ISpell
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
