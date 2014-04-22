package com.tgame.extraperception.casting;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

/**
 * @since 22/04/14
 * @author tgame14
 */
public class CastTickEventListener
{
    public static final String PLAYER_USE_SPELLS = "useSpells";
    public static final String CURRENT_SPELL_USE = "currentSpellUsed";


    @SubscribeEvent
    public void playerRightClick(PlayerInteractEvent event)
    {

        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR)
        {
            if (event.entityPlayer.isSneaking())
            {
                if (event.entityPlayer.getHeldItem() == null)
                {
                    boolean data = event.entityPlayer.getEntityData().hasKey(PLAYER_USE_SPELLS) ? !event.entityPlayer.getEntityData().getBoolean(PLAYER_USE_SPELLS) : true;
                    event.entityPlayer.getEntityData().setBoolean(PLAYER_USE_SPELLS, data);
                }

            }
            else
            {

            }
        }

    }
}
