package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;

public class BlockStainedHardenedClayStructureWall extends BlockModStructureWall {

	private final EnumDyeColor color;

	public BlockStainedHardenedClayStructureWall(final EnumDyeColor color) {
		super(Blocks.STAINED_HARDENED_CLAY.getDefaultState().getMaterial());
		ModUtil.setRegistryNames(this, color.getName() + "_terracotta_" + SUFFIX);
		this.color = color;

//		registerBlock(159, "stained_hardened_clay", (new BlockStainedHardenedClay()).setHardness(1.25F).setResistance(7.0F).setSoundType(SoundType.STONE).setTranslationKey("clayHardenedStained"));
		this.setHardness(1.25F);
		this.setResistance(7.0F / 3.0F);

	}

	public EnumDyeColor getColor() {
		return this.color;
	}

}
