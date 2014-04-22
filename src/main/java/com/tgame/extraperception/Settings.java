package com.tgame.extraperception;

import cpw.mods.fml.common.FMLCommonHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.Locale;

/**
 * @since 21/04/14
 * @author tgame14
 */
public class Settings
{
    public static final String MODID = "extrasensoryperception";
    public static final String VERSION = "@VERSION@";
    public static final String NAME = "Extrasensory Perception";

    public static final String DOMAIN = MODID + ":";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    static
    {
        //ThreadContext.put("side", FMLCommonHandler.instance().getSide().name().toLowerCase(Locale.ENGLISH));
    }

}
