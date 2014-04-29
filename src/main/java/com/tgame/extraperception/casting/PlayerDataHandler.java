package com.tgame.extraperception.casting;

import com.tgame.extraperception.Settings;
import com.tgame.extraperception.api.ActionRegistry;
import com.tgame.mods.libs.utility.NBTUtility;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

/**
 * This class is meant to handle the player data that is saved on the server
 * Mostly saving information on the player.dat
 *
 * @since 28/04/14
 * @author tgame14
 */
public class PlayerDataHandler
{
    public static final String DEXTERITY_KEY = "dexterity";
    public static final String COMPETENCE_KEY = "competence";
    public static final String WALK_DISTANCE_KEY = "walkingDistance";

    public static final String PLAYER_USE_SPELLS = "useSpells";
    public static final String CURRENT_SPELL = "currentSpellUsed";

    @SubscribeEvent
    public void PlayerLoginEvent (PlayerEvent.PlayerLoggedInEvent event)
    {
        NBTTagCompound tag = new NBTTagCompound();
        event.player.writeToNBT(tag);
        Settings.LOGGER.info(event.player + "MC NBT: " + tag);
        Settings.LOGGER.info(event.player + "Forge NBT: " + event.player.getEntityData());

        NBTUtility.addNBTIntKey(event.player.getEntityData(), DEXTERITY_KEY, 0);
        NBTUtility.addNBTIntKey(event.player.getEntityData(), COMPETENCE_KEY, 0);
        NBTUtility.addNBTIntKey(event.player.getEntityData(), WALK_DISTANCE_KEY, 0);

        NBTUtility.addNBTBooleanKey(event.player.getEntityData(), PLAYER_USE_SPELLS, false);
        NBTUtility.addNBTStringKey(event.player.getEntityData(), CURRENT_SPELL, ActionRegistry.INSTANCE.actionList.get(0));


        Settings.LOGGER.info(event.player + "MC NBT: " + tag);
        Settings.LOGGER.info(event.player + "Forge NBT: " + event.player.getEntityData());
    }

    @SubscribeEvent
    public void PlayerRespawnEvent (PlayerEvent.PlayerRespawnEvent event)
    {
        event.player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_PURPLE.toString() + EnumChatFormatting.ITALIC.toString() + EnumChatFormatting.BOLD.toString() + "You wake up with a headache, feeling less competent")); //TODO: Localize
        event.player.getEntityData().setInteger(COMPETENCE_KEY, event.player.getEntityData().getInteger(COMPETENCE_KEY) - 5);
    }

}
