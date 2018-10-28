package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;

public class BlockGlazedTerracottaStructureHorizontal extends BlockModStructureHorizontal {

	public static final String SUFFIX = "glazed_terracotta_structure_horizontal";

	private final EnumDyeColor color;

	public BlockGlazedTerracottaStructureHorizontal(final EnumDyeColor color) {
		super(Blocks.WHITE_GLAZED_TERRACOTTA.getDefaultState().getMaterial());
		ModUtil.setRegistryNames(this, color.getName() + "_" + SUFFIX);
		this.color = color;

//		registerBlock(250, "black_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.BLACK));
		this.setHardness(1.4F);
		this.setResistance(7.0F / 3.0F);

	}

	public EnumDyeColor getColor() {
		return this.color;
	}

}
