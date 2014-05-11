package com.tgame.extraperception.items;

import com.tgame.extraperception.Settings;
import com.tgame.extraperception.api.ActionRegistry;
import com.tgame.extraperception.api.IAction;
import com.tgame.extraperception.casting.CastEventListener;
import com.tgame.extraperception.items.render.ItemCastingStickRenderer;
import com.tgame.mods.libs.registry.ItemData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

/**
 * @since 26/04/14
 * @author tgame14
 */
@ItemData(itemRendererClass = ItemCastingStickRenderer.class)
public class ItemCastingStick extends ESPAbstractItem
{
    @SideOnly(Side.CLIENT)
    private IIcon onIcon;

    public ItemCastingStick ()
    {
        super(false);
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
    }

    @Override
    public void registerIcons (IIconRegister register)
    {
        this.itemIcon = register.registerIcon(Settings.RESOURCE_LOCATION + this.getClass().getSimpleName());
        this.onIcon = register.registerIcon(Settings.RESOURCE_LOCATION + this.getClass().getSimpleName() + "On");

    }

    @Override
    public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player)
    {
        if (!world.isRemote)
        {
            if (player.isSneaking())
            {
                boolean data = player.getEntityData().getBoolean(CastEventListener.PLAYER_USE_SPELLS);
                player.getEntityData().setBoolean(CastEventListener.PLAYER_USE_SPELLS, !data);

                player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("info.stick.status").replaceAll("%b", String.valueOf(!data))));
            }
        }
        return super.onItemRightClick(stack, world, player);
    }

    @Override
    public void onUsingTick (ItemStack stack, EntityPlayer player, int count)
    {
        super.onUsingTick(stack, player, count);
    }

    @Override
    public boolean onEntitySwing (EntityLivingBase entity, ItemStack stack)
    {
        EntityPlayer player = null;
        if (entity instanceof EntityPlayer)
        {
            player = (EntityPlayer) entity;
        }
        else
        {
            return super.onEntitySwing(entity, stack);
        }

        String key = player.getEntityData().getString(CastEventListener.CURRENT_SPELL);
        System.out.println("key = " + key);
        if (key == null || key.isEmpty())
        {
            key = ActionRegistry.INSTANCE.actionList.get(0);
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_G))
        {
            int index = ActionRegistry.INSTANCE.actionList.indexOf(key);
            if (index < 0)
            {
                index = 0;
            }
            String nextAction = ActionRegistry.INSTANCE.actionList.get(index++);
            if (nextAction == null)
            {
                nextAction = ActionRegistry.INSTANCE.actionList.get(0);
            }
            player.getEntityData().setString(CastEventListener.CURRENT_SPELL, nextAction);
            player.addChatComponentMessage(new ChatComponentText(StatCollector.translateToLocal("info.stick.currspell").replaceAll("%sp", nextAction) + " ewewewew"));
        }
        else
        {
            String candidate = player.getEntityData().getString(CastEventListener.CURRENT_SPELL);
            System.out.println("Candidate = " + candidate);
            IAction action = ActionRegistry.INSTANCE.actionMap.get(player.getEntityData().getString(CastEventListener.CURRENT_SPELL));
            System.out.println("action = " + action);
            System.out.println("Map " + ActionRegistry.INSTANCE.actionMap);
            System.out.println("List " + ActionRegistry.INSTANCE.actionList);
            action.onActionCalled(player);
        }
        return super.onEntitySwing(entity, stack);
    }
}



