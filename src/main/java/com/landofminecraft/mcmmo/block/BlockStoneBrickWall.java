package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.BlockStoneBrick.EnumType;
import net.minecraft.init.Blocks;

public class BlockStoneBrickWall extends BlockModWall {

	private final EnumType type;

	public BlockStoneBrickWall(final EnumType type) {
		super(Blocks.STONEBRICK.getDefaultState().getMaterial());
		ModUtil.setRegistryNames(this, type.getName() + "_" + SUFFIX);

		this.type = type;

//     (new BlockStoneBrick()).setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE).setTranslationKey("stonebricksmooth");

		this.setHardness(1.5F);
		this.setResistance(10.0F / 3.0F);

	}

	public EnumType getType() {
		return this.type;
	}

}
