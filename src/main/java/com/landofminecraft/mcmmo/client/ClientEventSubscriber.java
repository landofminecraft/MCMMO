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

		registerModel(ModBlocks.WHITE_TERRACOTTA_WALL);
		registerModel(ModBlocks.ORANGE_TERRACOTTA_WALL);
		registerModel(ModBlocks.MAGENTA_TERRACOTTA_WALL);
		registerModel(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL);
		registerModel(ModBlocks.YELLOW_TERRACOTTA_WALL);
		registerModel(ModBlocks.LIME_TERRACOTTA_WALL);
		registerModel(ModBlocks.PINK_TERRACOTTA_WALL);
		registerModel(ModBlocks.GRAY_TERRACOTTA_WALL);
		registerModel(ModBlocks.SILVER_TERRACOTTA_WALL);
		registerModel(ModBlocks.CYAN_TERRACOTTA_WALL);
		registerModel(ModBlocks.PURPLE_TERRACOTTA_WALL);
		registerModel(ModBlocks.BLUE_TERRACOTTA_WALL);
		registerModel(ModBlocks.BROWN_TERRACOTTA_WALL);
		registerModel(ModBlocks.GREEN_TERRACOTTA_WALL);
		registerModel(ModBlocks.RED_TERRACOTTA_WALL);
		registerModel(ModBlocks.BLACK_TERRACOTTA_WALL);

		registerModel(ModBlocks.WHITE_CONCRETE_WALL);
		registerModel(ModBlocks.ORANGE_CONCRETE_WALL);
		registerModel(ModBlocks.MAGENTA_CONCRETE_WALL);
		registerModel(ModBlocks.LIGHT_BLUE_CONCRETE_WALL);
		registerModel(ModBlocks.YELLOW_CONCRETE_WALL);
		registerModel(ModBlocks.LIME_CONCRETE_WALL);
		registerModel(ModBlocks.PINK_CONCRETE_WALL);
		registerModel(ModBlocks.GRAY_CONCRETE_WALL);
		registerModel(ModBlocks.SILVER_CONCRETE_WALL);
		registerModel(ModBlocks.CYAN_CONCRETE_WALL);
		registerModel(ModBlocks.PURPLE_CONCRETE_WALL);
		registerModel(ModBlocks.BLUE_CONCRETE_WALL);
		registerModel(ModBlocks.BROWN_CONCRETE_WALL);
		registerModel(ModBlocks.GREEN_CONCRETE_WALL);
		registerModel(ModBlocks.RED_CONCRETE_WALL);
		registerModel(ModBlocks.BLACK_CONCRETE_WALL);

		registerModel(ModBlocks.WHITE_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.ORANGE_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.MAGENTA_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.YELLOW_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.LIME_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.PINK_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.GRAY_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.SILVER_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.CYAN_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.PURPLE_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.BLUE_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.BROWN_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.GREEN_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.RED_GLAZED_TERRACOTTA_WALL);
		registerModel(ModBlocks.BLACK_GLAZED_TERRACOTTA_WALL);

		registerModel(ModBlocks.WHITE_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.ORANGE_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.MAGENTA_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.LIGHT_BLUE_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.YELLOW_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.LIME_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.PINK_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.GRAY_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.SILVER_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.CYAN_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.PURPLE_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.BLUE_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.BROWN_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.GREEN_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.RED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.BLACK_TERRACOTTA_STRUCTURE_WALL);

		registerModel(ModBlocks.WHITE_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.ORANGE_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.MAGENTA_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.LIGHT_BLUE_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.YELLOW_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.LIME_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.PINK_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.GRAY_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.SILVER_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.CYAN_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.PURPLE_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.BLUE_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.BROWN_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.GREEN_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.RED_CONCRETE_STRUCTURE_WALL);
		registerModel(ModBlocks.BLACK_CONCRETE_STRUCTURE_WALL);

		registerModel(ModBlocks.WHITE_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.ORANGE_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.MAGENTA_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.YELLOW_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.LIME_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.PINK_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.GRAY_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.SILVER_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.CYAN_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.PURPLE_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.BLUE_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.BROWN_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.GREEN_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.RED_GLAZED_TERRACOTTA_STRUCTURE_WALL);
		registerModel(ModBlocks.BLACK_GLAZED_TERRACOTTA_STRUCTURE_WALL);

		registerModel(ModBlocks.COBBLESTONE_STRUCTURE_WALL);
		registerModel(ModBlocks.MOSSY_COBBLESTONE_STRUCTURE_WALL);

		registerModel(ModBlocks.STONEBRICK_WALL);
		registerModel(ModBlocks.MOSSY_STONEBRICK_WALL);
		registerModel(ModBlocks.CRACKED_STONEBRICK_WALL);
		registerModel(ModBlocks.CHISELED_STONEBRICK_WALL);

		registerModel(ModBlocks.STONEBRICK_STRUCTURE_WALL);
		registerModel(ModBlocks.MOSSY_STONEBRICK_STRUCTURE_WALL);
		registerModel(ModBlocks.CRACKED_STONEBRICK_STRUCTURE_WALL);
		registerModel(ModBlocks.CHISELED_STONEBRICK_STRUCTURE_WALL);

		registerModel(ModBlocks.WHITE_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.ORANGE_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.MAGENTA_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.LIGHT_BLUE_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.YELLOW_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.LIME_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.PINK_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.GRAY_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.SILVER_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.CYAN_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.PURPLE_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.BLUE_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.BROWN_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.GREEN_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.RED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.BLACK_TERRACOTTA_STRUCTURE_HORIZONTAL);

		registerModel(ModBlocks.WHITE_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.ORANGE_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.MAGENTA_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.LIGHT_BLUE_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.YELLOW_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.LIME_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.PINK_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.GRAY_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.SILVER_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.CYAN_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.PURPLE_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.BLUE_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.BROWN_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.GREEN_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.RED_CONCRETE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.BLACK_CONCRETE_STRUCTURE_HORIZONTAL);

		registerModel(ModBlocks.WHITE_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.ORANGE_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.MAGENTA_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.YELLOW_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.LIME_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.PINK_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.GRAY_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.SILVER_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.CYAN_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.PURPLE_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.BLUE_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.BROWN_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.GREEN_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.RED_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.BLACK_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL);

		registerModel(ModBlocks.COBBLESTONE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.MOSSY_COBBLESTONE_STRUCTURE_HORIZONTAL);

		registerModel(ModBlocks.STONEBRICK_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.MOSSY_STONEBRICK_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.CRACKED_STONEBRICK_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.CHISELED_STONEBRICK_STRUCTURE_HORIZONTAL);

		registerModel(ModBlocks.SANDSTONE_STRUCTURE_WALL);
		registerModel(ModBlocks.CHISELED_SANDSTONE_STRUCTURE_WALL);
		registerModel(ModBlocks.SMOOTH_SANDSTONE_STRUCTURE_WALL);

		registerModel(ModBlocks.SANDSTONE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.CHISELED_SANDSTONE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.SMOOTH_SANDSTONE_STRUCTURE_HORIZONTAL);

		registerModel(ModBlocks.RED_SANDSTONE_STRUCTURE_WALL);
		registerModel(ModBlocks.CHISELED_RED_SANDSTONE_STRUCTURE_WALL);
		registerModel(ModBlocks.SMOOTH_RED_SANDSTONE_STRUCTURE_WALL);

		registerModel(ModBlocks.RED_SANDSTONE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.CHISELED_RED_SANDSTONE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.SMOOTH_RED_SANDSTONE_STRUCTURE_HORIZONTAL);

		registerModel(ModBlocks.OAK_LOG_WALL);
		registerModel(ModBlocks.SPRUCE_LOG_WALL);
		registerModel(ModBlocks.BIRCH_LOG_WALL);
		registerModel(ModBlocks.JUNGLE_LOG_WALL);
		registerModel(ModBlocks.ACACIA_LOG_WALL);
		registerModel(ModBlocks.DARK_OAK_LOG_WALL);

		registerModel(ModBlocks.STONE_WALL);
		registerModel(ModBlocks.GRANITE_WALL);
		registerModel(ModBlocks.GRANITE_SMOOTH_WALL);
		registerModel(ModBlocks.DIORITE_WALL);
		registerModel(ModBlocks.DIORITE_SMOOTH_WALL);
		registerModel(ModBlocks.ANDESITE_WALL);
		registerModel(ModBlocks.ANDESITE_SMOOTH_WALL);

		registerModel(ModBlocks.OAK_PLANKS_STRUCTURE_WALL);
		registerModel(ModBlocks.SPRUCE_PLANKS_STRUCTURE_WALL);
		registerModel(ModBlocks.BIRCH_PLANKS_STRUCTURE_WALL);
		registerModel(ModBlocks.JUNGLE_PLANKS_STRUCTURE_WALL);
		registerModel(ModBlocks.ACACIA_PLANKS_STRUCTURE_WALL);
		registerModel(ModBlocks.DARK_OAK_PLANKS_STRUCTURE_WALL);

		registerModel(ModBlocks.OAK_LOG_STRUCTURE_WALL);
		registerModel(ModBlocks.SPRUCE_LOG_STRUCTURE_WALL);
		registerModel(ModBlocks.BIRCH_LOG_STRUCTURE_WALL);
		registerModel(ModBlocks.JUNGLE_LOG_STRUCTURE_WALL);
		registerModel(ModBlocks.ACACIA_LOG_STRUCTURE_WALL);
		registerModel(ModBlocks.DARK_OAK_LOG_STRUCTURE_WALL);

		registerModel(ModBlocks.STONE_STRUCTURE_WALL);
		registerModel(ModBlocks.GRANITE_STRUCTURE_WALL);
		registerModel(ModBlocks.GRANITE_SMOOTH_STRUCTURE_WALL);
		registerModel(ModBlocks.DIORITE_STRUCTURE_WALL);
		registerModel(ModBlocks.DIORITE_SMOOTH_STRUCTURE_WALL);
		registerModel(ModBlocks.ANDESITE_STRUCTURE_WALL);
		registerModel(ModBlocks.ANDESITE_SMOOTH_STRUCTURE_WALL);

		registerModel(ModBlocks.OAK_PLANKS_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.SPRUCE_PLANKS_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.BIRCH_PLANKS_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.JUNGLE_PLANKS_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.ACACIA_PLANKS_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.DARK_OAK_PLANKS_STRUCTURE_HORIZONTAL);

		registerModel(ModBlocks.OAK_LOG_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.SPRUCE_LOG_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.BIRCH_LOG_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.JUNGLE_LOG_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.ACACIA_LOG_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.DARK_OAK_LOG_STRUCTURE_HORIZONTAL);

		registerModel(ModBlocks.STONE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.GRANITE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.GRANITE_SMOOTH_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.DIORITE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.DIORITE_SMOOTH_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.ANDESITE_STRUCTURE_HORIZONTAL);
		registerModel(ModBlocks.ANDESITE_SMOOTH_STRUCTURE_HORIZONTAL);

		registerModel(ModBlocks.NETHER_BRICK_STRUCTURE_WALL);

		registerModel(ModBlocks.NETHER_BRICK_STRUCTURE_HORIZONTAL);

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