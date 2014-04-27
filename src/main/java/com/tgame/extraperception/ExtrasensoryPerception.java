package com.tgame.extraperception;

import com.tgame.extraperception.api.definitions.Items;
import com.tgame.extraperception.armor.ItemShamanArmor;
import com.tgame.extraperception.casting.CastEventListener;
import com.tgame.extraperception.casting.spells.SpellHighJump;
import com.tgame.extraperception.api.SpellRegistry;
import com.tgame.extraperception.casting.spells.SpellShaders;
import com.tgame.extraperception.items.ItemCastingStick;
import com.tgame.extraperception.proxies.CommonProxy;
import com.tgame.mods.libs.registry.RegistryHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * @since 21/04/14
 * @author tgame14
 */
@Mod(modid = Settings.MODID, version = Settings.VERSION, name = Settings.NAME)
public class ExtrasensoryPerception
{
    @Mod.Instance(Settings.MODID)
    public static ExtrasensoryPerception instance;

    @SidedProxy(serverSide = "com.tgame.extraperception.proxies.CommonProxy", clientSide = "com.tgame.extraperception.proxies.ClientProxy")
    public static CommonProxy commonProxy;

    private RegistryHandler registryHandler;

    @Mod.Metadata
    private static ModMetadata metadata;

    public ExtrasensoryPerception()
    {
        registryHandler = new RegistryHandler();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Settings.LOGGER.info("Entering Preinit");


        Items.itemShamanHelmet = registryHandler.registerItem(new ItemShamanArmor(commonProxy.addArmor("shaman"), 0));
        Items.itemShamanChest = registryHandler.registerItem(new ItemShamanArmor(commonProxy.addArmor("shaman"), 1));
        Items.itemShamanLegs = registryHandler.registerItem(new ItemShamanArmor(commonProxy.addArmor("shaman"), 2));
        Items.itemShamanBoots = registryHandler.registerItem(new ItemShamanArmor(commonProxy.addArmor("shaman"), 3));

        Items.itemCastingStick = registryHandler.registerItem(new ItemCastingStick());

        MinecraftForge.EVENT_BUS.register(new CastEventListener());

        SpellRegistry.INSTANCE.addSpell(SpellHighJump.class.getSimpleName(), new SpellHighJump());
        SpellRegistry.INSTANCE.addSpell(SpellShaders.class.getSimpleName(), new SpellShaders());

        Settings.LOGGER.info("Exiting Preinit");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Settings.LOGGER.info(Settings.NAME + " Entering Init");

        metadata.authorList.add("@AUTHOR@");
        metadata.autogenerated = false;
        metadata.modId = Settings.MODID;
        metadata.name = Settings.NAME;
        metadata.description = "The human mind has abilities we were not able to use, Until now, find out what you can do, with only yourself, and your mind";
        metadata.version = Settings.VERSION;
        metadata.credits = "@AUTHOR@";

        Settings.LOGGER.info(Settings.NAME + " Exiting Init");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        Settings.LOGGER.info("Entering PostInit");

        SpellRegistry.INSTANCE.postLoaded();

        Settings.LOGGER.info("Exiting PostInit");
    }



}
