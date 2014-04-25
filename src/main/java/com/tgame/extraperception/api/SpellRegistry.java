package com.tgame.extraperception.api;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderState;

/**
 * A Singleton that handles all Registries of spells
 *
 * to Add a spell, you need to do it BEFORE postinit, so in init / preinit
 * once postinit is reached,
 * @since 22/04/14
 * @author tgame14
 */
public class SpellRegistry
{
    public final static SpellRegistry INSTANCE = new SpellRegistry();

    public ImmutableMap<String, ISpell> spellMap;
    public ImmutableList<String> spellList;

    private final ImmutableMap.Builder<String, ISpell> spellMapBuilder = ImmutableMap.builder();
    private final ImmutableList.Builder<String> spellListBuilder = ImmutableList.builder();

    private SpellRegistry () {}

    public void addSpell (String unlocalizedName, ISpell spellBase)
    {
        if (Loader.instance().hasReachedState(LoaderState.POSTINITIALIZATION))
        {
            throw new UnsupportedOperationException("Attempted to register a spell during or after Postinit");
        }
        spellMapBuilder.put(unlocalizedName, spellBase);
        spellListBuilder.add(unlocalizedName);
    }

    public void postLoaded()
    {
        this.spellMap = spellMapBuilder.build();
        this.spellList = spellListBuilder.build();
    }


}
