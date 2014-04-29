package com.tgame.extraperception.casting.abilities;

import com.tgame.extraperception.api.IAction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * @since 29/04/14
 * @author tgame14
 */
public class ActionLetItGo implements IAction
{
    @Override
    public void onActionCalled (EntityPlayer player)
    {
        World world = player.getEntityWorld();
        Entity entity = new EntitySnowman(world);
        entity.posX = player.posX + 1;
        entity.posY = player.posY;
        entity.posZ = player.posZ + 1;
        world.spawnEntityInWorld(entity);
        System.out.println("entity = " + entity);
    }
}
