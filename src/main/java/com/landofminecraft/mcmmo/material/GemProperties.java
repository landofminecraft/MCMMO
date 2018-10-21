package com.landofminecraft.mcmmo.material;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;

public class GemProperties extends ModMaterialProperties {

	public static final String	RESOURCE_SUFFIX			= "";
	public static final String	RESOURCE_PIECE_SUFFIX	= "shard";

	public static final BlockRenderLayer[] BLOCK_RENDER_LAYERS = new BlockRenderLayer[] { BlockRenderLayer.TRANSLUCENT };

	public GemProperties(final boolean hasOre, final boolean hasArmor, final boolean hasTools, final float MOHS_Hardness, final float density_gramsPerCentimeterCubed, @Nullable final Supplier<Item> getOreDrop, @Nonnull @MethodsReturnNonnullByDefault final BiFunction<Integer, Random, Integer> getQuantityDroppedWithBonusFromOre) {
		this(hasOre, hasArmor, hasTools, MOHS_Hardness, density_gramsPerCentimeterCubed, getOreDrop, BLOCK_RENDER_LAYERS, getQuantityDroppedWithBonusFromOre);
	}

	public GemProperties(final boolean hasOre, final boolean hasArmor, final boolean hasTools, final float MOHS_Hardness, final float density_gramsPerCentimeterCubed, @Nullable final Supplier<Item> getOreDrop, @Nullable final BlockRenderLayer[] blockRenderLayers, @Nonnull @MethodsReturnNonnullByDefault final BiFunction<Integer, Random, Integer> getQuantityDroppedWithBonusFromOre) {
		super(hasOre, true, true, RESOURCE_SUFFIX, true, RESOURCE_PIECE_SUFFIX, hasArmor, hasTools, MOHS_Hardness, density_gramsPerCentimeterCubed, getOreDrop, blockRenderLayers, getQuantityDroppedWithBonusFromOre);
	}

}
