package com.landofminecraft.mcmmo.client;

import com.landofminecraft.mcmmo.util.ModReference;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * EventSubscriber for client physical sided events
 *
 * @author Cadiboo
 */
@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = ModReference.MOD_ID, value = Side.CLIENT)
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