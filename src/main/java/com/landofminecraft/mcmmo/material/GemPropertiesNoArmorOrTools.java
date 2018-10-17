package com.landofminecraft.mcmmo.material;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;

public class GemPropertiesNoArmorOrTools extends ModMaterialProperties {

	public static final String	RESOURCE_SUFFIX			= "";
	public static final String	RESOURCE_PIECE_SUFFIX	= "shard";

	public static final BlockRenderLayer[] BLOCK_RENDER_LAYERS = new BlockRenderLayer[] { BlockRenderLayer.TRANSLUCENT };

	public GemPropertiesNoArmorOrTools(final boolean hasOre, final float MOHS_Hardness, @Nullable final Supplier<Item> getOreDrop, @Nonnull @MethodsReturnNonnullByDefault final BiFunction<Integer, Random, Integer> getQuantityDroppedWithBonusFromOre) {
		this(hasOre, MOHS_Hardness, getOreDrop, BLOCK_RENDER_LAYERS, getQuantityDroppedWithBonusFromOre);
	}

	public GemPropertiesNoArmorOrTools(final boolean hasOre, final float MOHS_Hardness, @Nullable final Supplier<Item> getOreDrop, @Nullable final BlockRenderLayer[] blockRenderLayers, @Nonnull @MethodsReturnNonnullByDefault final BiFunction<Integer, Random, Integer> getQuantityDroppedWithBonusFromOre) {
		super(hasOre, true, true, RESOURCE_SUFFIX, true, RESOURCE_PIECE_SUFFIX, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, MOHS_Hardness, getOreDrop, blockRenderLayers, getQuantityDroppedWithBonusFromOre);
	}

}
