package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.init.Blocks;

public class BlockPlanksStructureWall extends BlockModStructureWall {

	public static final String SUFFIX = "planks_" + BlockModStructureWall.SUFFIX;

	private final EnumType type;

	public BlockPlanksStructureWall(final EnumType type) {
		super(Blocks.PLANKS.getDefaultState().getMaterial());
		ModUtil.setRegistryNames(this, type.getName() + "_" + SUFFIX);

		this.type = type;

//      (new BlockPlanks()).setHardness(2.0F).setResistance(5.0F).setSoundType(SoundType.WOOD).setTranslationKey("wood");

		this.setHardness(2.0F);
		this.setResistance(5.0F / 3.0F);

	}

	public EnumType getType() {
		return this.type;
	}

}
