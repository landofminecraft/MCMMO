package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.init.Blocks;

public class BlockPlanksStructureHorizontal extends BlockModStructureHorizontal {

	private final BlockPlanks.EnumType type;

	public BlockPlanksStructureHorizontal(final EnumType type) {
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
