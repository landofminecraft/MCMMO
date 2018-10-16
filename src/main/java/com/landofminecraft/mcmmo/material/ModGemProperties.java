package com.landofminecraft.mcmmo.material;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;

public class ModGemProperties extends ModMaterialProperties {

	public ModGemProperties(final boolean hasOre, final float MOHS_Hardness, @Nullable final Supplier<Item> getOreDrop, @Nonnull @MethodsReturnNonnullByDefault final BiFunction<Integer, Random, Integer> getQuantityDroppedWithBonus) {
		this(hasOre, MOHS_Hardness, getOreDrop, GemProperties.BLOCK_RENDER_LAYERS, getQuantityDroppedWithBonus);
	}

	public ModGemProperties(final boolean hasOre, final float MOHS_Hardness, @Nullable final Supplier<Item> getOreDrop, @Nullable final BlockRenderLayer[] blockRenderLayers, @Nonnull @MethodsReturnNonnullByDefault final BiFunction<Integer, Random, Integer> getQuantityDroppedWithBonus) {
		super(hasOre, true, true, GemProperties.RESOURCE_SUFFIX, true, GemProperties.RESOURCE_PIECE_SUFFIX, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, MOHS_Hardness, getOreDrop, blockRenderLayers, getQuantityDroppedWithBonus);
	}

}
