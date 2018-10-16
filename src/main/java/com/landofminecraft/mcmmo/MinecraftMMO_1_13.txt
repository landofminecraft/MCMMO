package com.landofminecraft.mcmmo;

import com.landofminecraft.mcmmo.util.ModReference;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModReference.MOD_ID)
public class MinecraftMMO_1_13
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public MinecraftMMO_1_13() {
        // Register the preInit method for modloading
        FMLModLoadingContext.get().getModEventBus().addListener(this::preInit);
        // Register the init method for modloading
        FMLModLoadingContext.get().getModEventBus().addListener(this::init);
     // Register the postInit method for modloading
        FMLModLoadingContext.get().getModEventBus().addListener(this::postInit);

        // Register ourselves for server, registry and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void preInit(final FMLPreInitializationEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void init(final FMLInitializationEvent event)
    {
        // some example code
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    
    private void postInit(final FMLPostInitializationEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM POSTINIT");
    }

    @SubscribeEvent
    public void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        // register a new block here
        LOGGER.info("HELLO from Register Block");
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
