package com.tgame.extraperception.api;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState;

/**
 * A Singleton that handles all Registries of abilities
 *
 * to Add a spell, you need to do it BEFORE postinit, so in init / preinit
 * once postinit is reached,
 * @since 22/04/14
 * @author tgame14
 */
public class ActionRegistry
{
    public final static ActionRegistry INSTANCE = new ActionRegistry();

    public ImmutableMap<String, IAction> actionMap;
    public ImmutableList<String> actionList;

    private final ImmutableMap.Builder<String, IAction> actionMapBuilder = ImmutableMap.builder();
    private final ImmutableList.Builder<String> actionListBuilder = ImmutableList.builder();

    private ActionRegistry () {}

    public void addSpell (String unlocalizedName, IAction spellBase)
    {
        if (Loader.instance().hasReachedState(LoaderState.POSTINITIALIZATION))
        {
            throw new UnsupportedOperationException("Attempted to register an action during or after Postinit");
        }

        actionMapBuilder.put(unlocalizedName, spellBase);
        actionListBuilder.add(unlocalizedName);
    }

    public void postLoaded()
    {
        this.actionMap = actionMapBuilder.build();
        this.actionList = actionListBuilder.build();
    }


}
