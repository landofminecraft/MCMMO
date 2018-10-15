package com.landofminecraft.mcmmo.client;

import com.landofminecraft.mcmmo.util.ModReference;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ModReference.MOD_ID)
public final class ClientEventSubscriber {

	@SubscribeEvent
	public static void onRegisterModelsEvent(final ModelRegistryEvent event) {

	}

	private static void registerTileEntitySpecialRenderers() {
		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWire.class, new TileEntityWireRenderer());
	}

	private static void registerEntityRenderers() {
		// RenderingRegistry.registerEntityRenderingHandler(EntityPortableGenerator.class, renderManager -> new EntityPortableGeneratorRenderer(renderManager));
	}

}