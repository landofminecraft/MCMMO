package com.landofminecraft.mcmmo.material;

import java.util.Random;
import java.util.function.BiFunction;

import net.minecraft.util.BlockRenderLayer;

public class MetalProperties extends ModMaterialProperties {

	public static final String	RESOURCE_SUFFIX			= "ingot";
	public static final String	RESOURCE_PIECE_SUFFIX	= "nugget";

	public static final BlockRenderLayer[] BLOCK_RENDER_LAYERS = new BlockRenderLayer[] { BlockRenderLayer.SOLID };

	public static final BiFunction<Integer, Random, Integer> GET_QUANTITY_DROPPED_WITH_BONUS_FROM_ORE = (fortune, random) -> {
		return 1;
	};

	public MetalProperties(final boolean hasOre, final float MOHS_Hardness) {
		super(hasOre, true, true, RESOURCE_SUFFIX, true, RESOURCE_PIECE_SUFFIX, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, MOHS_Hardness, null, BLOCK_RENDER_LAYERS, GET_QUANTITY_DROPPED_WITH_BONUS_FROM_ORE);
	}

}
