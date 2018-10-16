package com.landofminecraft.mcmmo.client;

import com.landofminecraft.mcmmo.init.ModBlocks;
import com.landofminecraft.mcmmo.util.ModReference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
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

		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.GRINDSTONE), 0, new ModelResourceLocation(Item.getItemFromBlock(ModBlocks.GRINDSTONE).getRegistryName(), "normal"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.GRINDSTONE_HANDLE), 0, new ModelResourceLocation(Item.getItemFromBlock(ModBlocks.GRINDSTONE_HANDLE).getRegistryName(), "normal"));

	}

	private static void registerTileEntitySpecialRenderers() {
		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWire.class, new TileEntityWireRenderer());
	}

	private static void registerEntityRenderers() {
		// RenderingRegistry.registerEntityRenderingHandler(EntityPortableGenerator.class, renderManager -> new EntityPortableGeneratorRenderer(renderManager));
	}

}