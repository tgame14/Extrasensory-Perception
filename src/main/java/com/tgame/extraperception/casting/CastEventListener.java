package com.tgame.extraperception.casting;

import com.tgame.extraperception.api.ActionRegistry;
import com.tgame.extraperception.api.IAction;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.lwjgl.input.Keyboard;

/**
 * @since 22/04/14
 * @author tgame14
 */
public class CastEventListener
{
    public static final String PLAYER_USE_SPELLS = "useSpells";
    public static final String CURRENT_SPELL = "currentSpellUsed";


    @SubscribeEvent
    public void playerRightClick (PlayerInteractEvent event)
    {
        if (event.action != PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)
        {
            if (event.entityPlayer.getHeldItem() == null)
            {
                if (event.entityPlayer.isSneaking())
                {
                    boolean data = event.entityPlayer.getEntityData().hasKey(PLAYER_USE_SPELLS) ? !event.entityPlayer.getEntityData().getBoolean(PLAYER_USE_SPELLS) : true;
                    event.entityPlayer.getEntityData().setBoolean(PLAYER_USE_SPELLS, data);
                    event.entityPlayer.addChatComponentMessage(new ChatComponentText("Spell Caster Mode: " + data)); //TODO: Localize

                }
                else
                {
                    if (Keyboard.isKeyDown(Keyboard.KEY_G))
                    {
                        if (!event.entityPlayer.getEntityData().hasKey(CURRENT_SPELL))
                        {
                            event.entityPlayer.getEntityData().setString(CURRENT_SPELL, ActionRegistry.INSTANCE.actionList.get(0));
                        }
                        else
                        {
                            String str1 = event.entityPlayer.getEntityData().getString(CURRENT_SPELL);
                            int index = ActionRegistry.INSTANCE.actionList.indexOf(str1) + 1;
                            event.entityPlayer.getEntityData().setString(CURRENT_SPELL, ActionRegistry.INSTANCE.actionList.get(index));
                        }
                        event.entityPlayer.addChatComponentMessage(new ChatComponentText("Current Spell: " + event.entityPlayer.getEntityData().getString(CURRENT_SPELL)));
                    }

                    else if (event.entityPlayer.getEntityData().hasKey(PLAYER_USE_SPELLS) && event.entityPlayer.getEntityData().getBoolean(PLAYER_USE_SPELLS) && event.entityPlayer.getEntityData().hasKey(CURRENT_SPELL))
                    {
                        IAction spell = ActionRegistry.INSTANCE.actionMap.get(event.entityPlayer.getEntityData().getString(CURRENT_SPELL));
                        spell.onActionCalled(event.entityPlayer);


                    }
                }
            }

        }
    }
}
