package com.landofminecraft.mcmmo;

import com.landofminecraft.mcmmo.block.BlockGrindstone;
import com.landofminecraft.mcmmo.block.BlockGrindstoneHandle;
import com.landofminecraft.mcmmo.block.BlockStainedHardenedClayWall;
import com.landofminecraft.mcmmo.init.ModBlocks;
import com.landofminecraft.mcmmo.item.ModItemBlock;
import com.landofminecraft.mcmmo.tileentity.TileEntityGrindstone;
import com.landofminecraft.mcmmo.util.ModReference;
import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.Block;
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
		}

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

		registry.register(new ModItemBlock(ModBlocks.WHITE_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.ORANGE_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.MAGENTA_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIGHT_BLUE_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.YELLOW_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.LIME_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.PINK_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.GRAY_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.SILVER_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.CYAN_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.PURPLE_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.BROWN_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.GREEN_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.RED_CLAY_WALL));
		registry.register(new ModItemBlock(ModBlocks.BLACK_CLAY_WALL));

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