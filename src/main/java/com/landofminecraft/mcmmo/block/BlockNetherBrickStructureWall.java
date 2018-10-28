package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.init.Blocks;

public class BlockNetherBrickStructureWall extends BlockModStructureWall {

	public BlockNetherBrickStructureWall() {
		super(Blocks.NETHER_BRICK.getDefaultState().getMaterial());
		ModUtil.setRegistryNames(this, Blocks.NETHER_BRICK.getRegistryName().getPath() + "_" + SUFFIX);

//      (new BlockNetherBrick()).setHardness(2.0F).setResistance(10.0F).setSoundType(SoundType.STONE).setTranslationKey("netherBrick").setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		this.setHardness(2.0F);
		this.setResistance(10.0F / 3.0F);

	}

}
