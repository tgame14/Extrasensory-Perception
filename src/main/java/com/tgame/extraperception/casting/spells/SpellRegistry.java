package com.tgame.extraperception.casting.spells;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
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
        spellMapBuilder.put(unlocalizedName, spellBase);
        spellListBuilder.add(unlocalizedName);
    }

    public void postLoaded()
    {
        this.spellMap = spellMapBuilder.build();
        this.spellList = spellListBuilder.build();
    }


}
