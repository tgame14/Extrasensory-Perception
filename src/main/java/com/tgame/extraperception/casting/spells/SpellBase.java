package com.tgame.extraperception.casting.spells;

import net.minecraft.entity.player.EntityPlayer;

/**
 * This class is a Basis for all Spells, it is used when a player right clicks
 *
 * @since 22/04/14
 * @author tgame14
 */
public abstract class SpellBase
{
    public abstract void onSpellUse(EntityPlayer player);

}
