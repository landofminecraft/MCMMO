package com.landofminecraft.mcmmo;

import com.landofminecraft.mcmmo.block.BlockCobblestoneStructureHorizontal;
import com.landofminecraft.mcmmo.block.BlockCobblestoneStructureWall;
import com.landofminecraft.mcmmo.block.BlockConcreteStructureHorizontal;
import com.landofminecraft.mcmmo.block.BlockConcreteStructureWall;
import com.landofminecraft.mcmmo.block.BlockConcreteWall;
import com.landofminecraft.mcmmo.block.BlockGlazedTerracottaStructureHorizontal;
import com.landofminecraft.mcmmo.block.BlockGlazedTerracottaStructureWall;
import com.landofminecraft.mcmmo.block.BlockGlazedTerracottaWall;
import com.landofminecraft.mcmmo.block.BlockGrindstone;
import com.landofminecraft.mcmmo.block.BlockGrindstoneHandle;
import com.landofminecraft.mcmmo.block.BlockLogStructureHorizontal;
import com.landofminecraft.mcmmo.block.BlockLogStructureWall;
import com.landofminecraft.mcmmo.block.BlockLogWall;
import com.landofminecraft.mcmmo.block.BlockNetherBrickStructureHorizontal;
import com.landofminecraft.mcmmo.block.BlockNetherBrickStructureWall;
import com.landofminecraft.mcmmo.block.BlockPlanksStructureHorizontal;
import com.landofminecraft.mcmmo.block.BlockPlanksStructureWall;
import com.landofminecraft.mcmmo.block.BlockRedSandstoneStructureHorizontal;
import com.landofminecraft.mcmmo.block.BlockRedSandstoneStructureWall;
import com.landofminecraft.mcmmo.block.BlockSandStoneStructureHorizontal;
import com.landofminecraft.mcmmo.block.BlockSandStoneStructureWall;
import com.landofminecraft.mcmmo.block.BlockStainedHardenedClayStructureHorizontal;
import com.landofminecraft.mcmmo.block.BlockStainedHardenedClayStructureWall;
import com.landofminecraft.mcmmo.block.BlockStainedHardenedClayWall;
import com.landofminecraft.mcmmo.block.BlockStoneBrickStructureHorizontal;
import com.landofminecraft.mcmmo.block.BlockStoneBrickStructureWall;
import com.landofminecraft.mcmmo.block.BlockStoneBrickWall;
import com.landofminecraft.mcmmo.block.BlockStoneStructureHorizontal;
import com.landofminecraft.mcmmo.block.BlockStoneStructureWall;
import com.landofminecraft.mcmmo.block.BlockStoneWall;
import com.landofminecraft.mcmmo.init.ModBlocks;
import com.landofminecraft.mcmmo.item.ModItemBlock;
import com.landofminecraft.mcmmo.tileentity.TileEntityGrindstone;
import com.landofminecraft.mcmmo.util.ModReference;
import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockRedSandstone;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockWall;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * EventSubscriber for events that fire on both physical sides
 *
 * @author Cadiboo
 */
@Mod.EventBusSubscriber(modid = ModReference.MOD_ID)
public final class EventSubscriber {

	public static int entityId = 0;

	@SubscribeEvent
	public static void onRegisterBlocksEvent(final RegistryEvent.Register<Block> event) {
		final IForgeRegistry<Block> registry = event.getRegistry();

		registry.register(new BlockGrindstone("grindstone"));
		registry.register(new BlockGrindstoneHandle("grindstone_handle"));

		for (final EnumDyeColor color : EnumDyeColor.values()) {
			registry.register(new BlockStainedHardenedClayWall(color));

			registry.register(new BlockConcreteWall(color));

			registry.register(new BlockGlazedTerracottaWall(color));

			//

			registry.register(new BlockStainedHardenedClayStructureWall(color));

			registry.register(new BlockConcreteStructureWall(color));

			registry.register(new BlockGlazedTerracottaStructureWall(color));

			//

			registry.register(new BlockStainedHardenedClayStructureHorizontal(color));

			registry.register(new BlockConcreteStructureHorizontal(color));

			registry.register(new BlockGlazedTerracottaStructureHorizontal(color));
		}

		for (final BlockWall.EnumType cobblestoneType : BlockWall.EnumType.values()) {

			registry.register(new BlockCobblestoneStructureWall(cobblestoneType));

			registry.register(new BlockCobblestoneStructureHorizontal(cobblestoneType));
		}

		for (final BlockStoneBrick.EnumType stoneBrickType : BlockStoneBrick.EnumType.values()) {
			registry.register(new BlockStoneBrickWall(stoneBrickType));

			registry.register(new BlockStoneBrickStructureWall(stoneBrickType));

			registry.register(new BlockStoneBrickStructureHorizontal(stoneBrickType));
		}

		for (final BlockSandStone.EnumType cobblestoneType : BlockSandStone.EnumType.values()) {

			registry.register(new BlockSandStoneStructureWall(cobblestoneType));

			registry.register(new BlockSandStoneStructureHorizontal(cobblestoneType));
		}

		for (final BlockRedSandstone.EnumType cobblestoneType : BlockRedSandstone.EnumType.values()) {

			registry.register(new BlockRedSandstoneStructureWall(cobblestoneType));

			registry.register(new BlockRedSandstoneStructureHorizontal(cobblestoneType));
		}

		for (final BlockPlanks.EnumType planksType : BlockPlanks.EnumType.values()) {

			registry.register(new BlockPlanksStructureWall(planksType));

			registry.register(new BlockPlanksStructureHorizontal(planksType));
		}

		for (final BlockPlanks.EnumType logType : BlockPlanks.EnumType.values()) {

			registry.register(new BlockLogWall(logType));

			registry.register(new BlockLogStructureWall(logType));

			registry.register(new BlockLogStructureHorizontal(logType));
		}

		for (final BlockStone.EnumType stoneType : BlockStone.EnumType.values()) {

			registry.register(new BlockStoneWall(stoneType));

			registry.register(new BlockStoneStructureWall(stoneType));

			registry.register(new BlockStoneStructureHorizontal(stoneType));
		}

		registry.register(new BlockNetherBrickStructureWall());

		registry.register(new BlockNetherBrickStructureHorizontal());

		MinecraftMMO.debug("Registered blocks");

		registerTileEntities();

		MinecraftMMO.debug("Registered tile entities");

	}

	private static void registerTileEntities() {
		registerTileEntity(TileEntityGrindstone.class);
	}

	private static void registerTileEntity(final Class<? extends TileEntity> clazz) {
		try {
			GameRegistry.registerTileEntity(clazz, new ResourceLocation(ModReference.MOD_ID, ModUtil.getRegistryNameForClass(clazz, "TileEntity")));
		} catch (final Exception e) {
			MinecraftMMO.error("Error registering Tile Entity " + clazz.getSimpleName());
			e.printStackTrace();
		}
	}

	@SubscribeEvent
	public static void onRegisterItemsEvent(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		registry.register(new ModItemBlock(ModBlocks.GRINDSTONE));
		registry.register(new ModItemBlock(ModBlocks.GRINDSTONE_HANDLE));

		registry.register(new ModItemBlock(ModBlocks.WHITE_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.ORANGE_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.MAGENTA_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.YELLOW_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIME_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.PINK_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.GRAY_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.SILVER_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.CYAN_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.PURPLE_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLUE_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.BROWN_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.GREEN_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.RED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLACK_TERRACOTTA_WALL));

		registry.register(new ModItemBlock(ModBlocks.WHITE_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.ORANGE_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.MAGENTA_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIGHT_BLUE_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.YELLOW_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIME_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.PINK_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GRAY_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.SILVER_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.CYAN_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.PURPLE_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLUE_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BROWN_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GREEN_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.RED_CONCRETE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLACK_CONCRETE_WALL));

		registry.register(new ModItemBlock(ModBlocks.WHITE_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.ORANGE_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.MAGENTA_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.YELLOW_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIME_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.PINK_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.GRAY_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.SILVER_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.CYAN_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.PURPLE_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLUE_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.BROWN_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.GREEN_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.RED_GLAZED_TERRACOTTA_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLACK_GLAZED_TERRACOTTA_WALL));

		registry.register(new ModItemBlock(ModBlocks.WHITE_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.ORANGE_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.MAGENTA_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.YELLOW_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIME_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.PINK_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GRAY_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.SILVER_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.CYAN_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.PURPLE_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLUE_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BROWN_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GREEN_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.RED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLACK_TERRACOTTA_STRUCTURE_WALL));

		registry.register(new ModItemBlock(ModBlocks.WHITE_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.ORANGE_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.MAGENTA_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIGHT_BLUE_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.YELLOW_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIME_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.PINK_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GRAY_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.SILVER_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.CYAN_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.PURPLE_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLUE_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BROWN_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GREEN_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.RED_CONCRETE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLACK_CONCRETE_STRUCTURE_WALL));

		registry.register(new ModItemBlock(ModBlocks.WHITE_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.ORANGE_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.MAGENTA_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.YELLOW_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIME_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.PINK_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GRAY_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.SILVER_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.CYAN_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.PURPLE_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLUE_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BROWN_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GREEN_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.RED_GLAZED_TERRACOTTA_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLACK_GLAZED_TERRACOTTA_STRUCTURE_WALL));

		registry.register(new ModItemBlock(ModBlocks.COBBLESTONE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.MOSSY_COBBLESTONE_STRUCTURE_WALL));

		registry.register(new ModItemBlock(ModBlocks.STONEBRICK_WALL));
		registry.register(new ModItemBlock(ModBlocks.MOSSY_STONEBRICK_WALL));
		registry.register(new ModItemBlock(ModBlocks.CRACKED_STONEBRICK_WALL));
		registry.register(new ModItemBlock(ModBlocks.CHISELED_STONEBRICK_WALL));

		registry.register(new ModItemBlock(ModBlocks.STONEBRICK_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.MOSSY_STONEBRICK_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.CRACKED_STONEBRICK_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.CHISELED_STONEBRICK_STRUCTURE_WALL));

		registry.register(new ModItemBlock(ModBlocks.WHITE_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.ORANGE_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.MAGENTA_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.YELLOW_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.LIME_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.PINK_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.GRAY_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.SILVER_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.CYAN_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.PURPLE_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.BLUE_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.BROWN_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.GREEN_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.RED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.BLACK_TERRACOTTA_STRUCTURE_HORIZONTAL));

		registry.register(new ModItemBlock(ModBlocks.WHITE_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.ORANGE_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.MAGENTA_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.LIGHT_BLUE_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.YELLOW_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.LIME_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.PINK_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.GRAY_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.SILVER_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.CYAN_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.PURPLE_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.BLUE_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.BROWN_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.GREEN_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.RED_CONCRETE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.BLACK_CONCRETE_STRUCTURE_HORIZONTAL));

		registry.register(new ModItemBlock(ModBlocks.WHITE_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.ORANGE_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.MAGENTA_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.LIGHT_BLUE_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.YELLOW_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.LIME_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.PINK_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.GRAY_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.SILVER_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.CYAN_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.PURPLE_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.BLUE_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.BROWN_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.GREEN_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.RED_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.BLACK_GLAZED_TERRACOTTA_STRUCTURE_HORIZONTAL));

		registry.register(new ModItemBlock(ModBlocks.COBBLESTONE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.MOSSY_COBBLESTONE_STRUCTURE_HORIZONTAL));

		registry.register(new ModItemBlock(ModBlocks.STONEBRICK_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.MOSSY_STONEBRICK_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.CRACKED_STONEBRICK_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.CHISELED_STONEBRICK_STRUCTURE_HORIZONTAL));

		registry.register(new ModItemBlock(ModBlocks.SANDSTONE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.CHISELED_SANDSTONE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.SMOOTH_SANDSTONE_STRUCTURE_WALL));

		registry.register(new ModItemBlock(ModBlocks.SANDSTONE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.CHISELED_SANDSTONE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.SMOOTH_SANDSTONE_STRUCTURE_HORIZONTAL));

		registry.register(new ModItemBlock(ModBlocks.RED_SANDSTONE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.CHISELED_RED_SANDSTONE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.SMOOTH_RED_SANDSTONE_STRUCTURE_WALL));

		registry.register(new ModItemBlock(ModBlocks.RED_SANDSTONE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.CHISELED_RED_SANDSTONE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.SMOOTH_RED_SANDSTONE_STRUCTURE_HORIZONTAL));

		registry.register(new ModItemBlock(ModBlocks.OAK_LOG_WALL));
		registry.register(new ModItemBlock(ModBlocks.SPRUCE_LOG_WALL));
		registry.register(new ModItemBlock(ModBlocks.BIRCH_LOG_WALL));
		registry.register(new ModItemBlock(ModBlocks.JUNGLE_LOG_WALL));
		registry.register(new ModItemBlock(ModBlocks.ACACIA_LOG_WALL));
		registry.register(new ModItemBlock(ModBlocks.DARK_OAK_LOG_WALL));

		registry.register(new ModItemBlock(ModBlocks.STONE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GRANITE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GRANITE_SMOOTH_WALL));
		registry.register(new ModItemBlock(ModBlocks.DIORITE_WALL));
		registry.register(new ModItemBlock(ModBlocks.DIORITE_SMOOTH_WALL));
		registry.register(new ModItemBlock(ModBlocks.ANDESITE_WALL));
		registry.register(new ModItemBlock(ModBlocks.ANDESITE_SMOOTH_WALL));

		registry.register(new ModItemBlock(ModBlocks.OAK_PLANKS_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.SPRUCE_PLANKS_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BIRCH_PLANKS_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.JUNGLE_PLANKS_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.ACACIA_PLANKS_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.DARK_OAK_PLANKS_STRUCTURE_WALL));

		registry.register(new ModItemBlock(ModBlocks.OAK_LOG_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.SPRUCE_LOG_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.BIRCH_LOG_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.JUNGLE_LOG_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.ACACIA_LOG_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.DARK_OAK_LOG_STRUCTURE_WALL));

		registry.register(new ModItemBlock(ModBlocks.STONE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GRANITE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.GRANITE_SMOOTH_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.DIORITE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.DIORITE_SMOOTH_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.ANDESITE_STRUCTURE_WALL));
		registry.register(new ModItemBlock(ModBlocks.ANDESITE_SMOOTH_STRUCTURE_WALL));

		registry.register(new ModItemBlock(ModBlocks.OAK_PLANKS_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.SPRUCE_PLANKS_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.BIRCH_PLANKS_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.JUNGLE_PLANKS_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.ACACIA_PLANKS_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.DARK_OAK_PLANKS_STRUCTURE_HORIZONTAL));

		registry.register(new ModItemBlock(ModBlocks.OAK_LOG_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.SPRUCE_LOG_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.BIRCH_LOG_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.JUNGLE_LOG_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.ACACIA_LOG_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.DARK_OAK_LOG_STRUCTURE_HORIZONTAL));

		registry.register(new ModItemBlock(ModBlocks.STONE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.GRANITE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.GRANITE_SMOOTH_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.DIORITE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.DIORITE_SMOOTH_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.ANDESITE_STRUCTURE_HORIZONTAL));
		registry.register(new ModItemBlock(ModBlocks.ANDESITE_SMOOTH_STRUCTURE_HORIZONTAL));

		registry.register(new ModItemBlock(ModBlocks.NETHER_BRICK_STRUCTURE_WALL));

		registry.register(new ModItemBlock(ModBlocks.NETHER_BRICK_STRUCTURE_HORIZONTAL));

		MinecraftMMO.debug("Registered items");

	}

	@SubscribeEvent
	public static void onRegisterEntitiesEvent(final RegistryEvent.Register<EntityEntry> event) {
		final IForgeRegistry<EntityEntry> registry = event.getRegistry();

		MinecraftMMO.debug("Registered entities");

	}

	private static EntityEntry buildEntityEntryFromClass(final Class<? extends Entity> clazz, final boolean hasEgg, final int range, final int updateFrequency, final boolean sendVelocityUpdates) {
		return buildEntityEntryFromClassWithName(clazz, new ResourceLocation(ModReference.MOD_ID, ModUtil.getRegistryNameForClass(clazz, "Entity")), hasEgg, range, updateFrequency, sendVelocityUpdates);
	}

	private static EntityEntry buildEntityEntryFromClassWithName(final Class<? extends Entity> clazz, final ResourceLocation registryName, final boolean hasEgg, final int range, final int updateFrequency, final boolean sendVelocityUpdates) {
		EntityEntryBuilder<Entity> builder = EntityEntryBuilder.create();
		builder = builder.entity(clazz);
		builder = builder.id(registryName, entityId++);
		builder = builder.name(registryName.getPath());
		builder = builder.tracker(range, updateFrequency, sendVelocityUpdates);

		if (hasEgg) {
			builder = builder.egg(0xFFFFFF, 0xAAAAAA);
		}

		return builder.build();
	}

}