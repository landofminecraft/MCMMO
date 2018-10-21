package com.landofminecraft.mcmmo.client;

import com.landofminecraft.mcmmo.init.ModBlocks;
import com.landofminecraft.mcmmo.util.ModReference;

import net.minecraft.block.Block;
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

		registerModel(ModBlocks.GRINDSTONE);
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.GRINDSTONE_HANDLE), 0, new ModelResourceLocation(Item.getItemFromBlock(ModBlocks.GRINDSTONE_HANDLE).getRegistryName(), "normal"));

		registerModel(ModBlocks.WHITE_CLAY_WALL);
		registerModel(ModBlocks.ORANGE_CLAY_WALL);
		registerModel(ModBlocks.MAGENTA_CLAY_WALL);
		registerModel(ModBlocks.LIGHT_BLUE_CLAY_WALL);
		registerModel(ModBlocks.YELLOW_CLAY_WALL);
		registerModel(ModBlocks.LIME_CLAY_WALL);
		registerModel(ModBlocks.PINK_CLAY_WALL);
		registerModel(ModBlocks.GRAY_CLAY_WALL);
		registerModel(ModBlocks.SILVER_CLAY_WALL);
		registerModel(ModBlocks.CYAN_CLAY_WALL);
		registerModel(ModBlocks.PURPLE_CLAY_WALL);
		registerModel(ModBlocks.BROWN_CLAY_WALL);
		registerModel(ModBlocks.GREEN_CLAY_WALL);
		registerModel(ModBlocks.RED_CLAY_WALL);
		registerModel(ModBlocks.BLACK_CLAY_WALL);

		registerTileEntitySpecialRenderers();
		registerEntityRenderers();
	}

	private static void registerModel(final Block block) {
		registerModel(block, "normal");
	}

	private static void registerModel(final Block block, final String variant) {
		registerModel(Item.getItemFromBlock(block), variant);
	}

	private static void registerModel(final Item item) {
		registerModel(item, "normal");
	}

	private static void registerModel(final Item item, final String variant) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "normal"));
	}

	private static void registerTileEntitySpecialRenderers() {
		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWire.class, new TileEntityWireRenderer());
	}

	private static void registerEntityRenderers() {
		// RenderingRegistry.registerEntityRenderingHandler(EntityPortableGenerator.class, renderManager -> new EntityPortableGeneratorRenderer(renderManager));
	}

}