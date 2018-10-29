package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.BlockStone.EnumType;
import net.minecraft.init.Blocks;

public class BlockStoneStructureHorizontal extends BlockModStructureHorizontal {

	private final EnumType type;

	public BlockStoneStructureHorizontal(final EnumType type) {
		super(Blocks.LOG.getDefaultState().getMaterial());
		// smooth_andesite -> andesite_smooth
		ModUtil.setRegistryNames(this, type.name().toLowerCase() + "_" + SUFFIX);

		this.type = type;

//		(new BlockStone()).setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE).setTranslationKey("stone"));

		this.setHardness(1.5F);
		this.setResistance(10.0F / 3.0F);

	}

	public EnumType getType() {
		return this.type;
	}

}
