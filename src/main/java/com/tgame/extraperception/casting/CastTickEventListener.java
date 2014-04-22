package com.tgame.extraperception.casting;

import com.tgame.extraperception.Settings;
import com.tgame.extraperception.casting.spells.SpellBase;
import com.tgame.extraperception.casting.spells.SpellRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.lwjgl.input.Keyboard;

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
        if (event.action != PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)
        {
            if (event.entityPlayer.isSneaking())
            {
                if (event.entityPlayer.getHeldItem() == null)
                {
                    boolean data = event.entityPlayer.getEntityData().hasKey(PLAYER_USE_SPELLS) ? !event.entityPlayer.getEntityData().getBoolean(PLAYER_USE_SPELLS) : true;
                    event.entityPlayer.getEntityData().setBoolean(PLAYER_USE_SPELLS, data);
                    event.entityPlayer.addChatComponentMessage(new ChatComponentText("Spell Caster Mode: " + data)); //TODO: Localize

                }

            }
            else
            {
                if (event.entityPlayer.getEntityData().hasKey(PLAYER_USE_SPELLS) && event.entityPlayer.getEntityData().getBoolean(PLAYER_USE_SPELLS) && Keyboard.isKeyDown(Keyboard.KEY_GRAVE))
                {
                    if (!event.entityPlayer.getEntityData().hasKey(CURRENT_SPELL_USE))
                    {
                        event.entityPlayer.getEntityData().setString(CURRENT_SPELL_USE, SpellRegistry.getSpellRegistry().keySet().iterator().next());
                    }

                    SpellBase spell = SpellRegistry.getSpellRegistry().get(event.entityPlayer.getEntityData().getString(CURRENT_SPELL_USE));
                    spell.onSpellUse(event.entityPlayer);

                }
            }
        }

    }
}
