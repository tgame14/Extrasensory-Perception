package com.tgame.extraperception.casting.spells;

import com.google.common.collect.HashBiMap;
import com.tgame.extraperception.Settings;

import java.util.Map;

/**
 * @since 22/04/14
 * @author tgame14
 */
public class SpellRegistry
{
    private static final HashBiMap<String, SpellBase> spellRegistry = HashBiMap.create();


    public static void addSpell(String unlocalizedName, SpellBase spellBase) throws UnmodifiableValueMapException
    {
        synchronized (spellRegistry)
        {
            if (!spellRegistry.containsKey(unlocalizedName))
            {
                spellRegistry.put(unlocalizedName, spellBase);
            }
            else throw new UnmodifiableValueMapException(Settings.NAME + " has thrown an exception due to a Bad spell, report to @AUTHOR@");
        }
    }

    public static Map<String, SpellBase> getSpellRegistry()
    {
        return spellRegistry;
    }



    public static class UnmodifiableValueMapException extends RuntimeException
    {

        public UnmodifiableValueMapException (String s)
        {
            super(s);
        }
    }



}
