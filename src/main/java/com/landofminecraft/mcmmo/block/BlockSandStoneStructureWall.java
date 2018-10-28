package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.BlockSandStone.EnumType;
import net.minecraft.init.Blocks;

public class BlockSandStoneStructureWall extends BlockModStructureWall {

	private final EnumType type;

	public BlockSandStoneStructureWall(final EnumType type) {
		super(Blocks.SANDSTONE.getDefaultState().getMaterial());
		ModUtil.setRegistryNames(this, type.getName() + "_" + SUFFIX);

		this.type = type;

//      (new Block(Material.ROCK)).setHardness(2.0F).setResistance(10.0F).setSoundType(SoundType.STONE).setTranslationKey("stonebrick").setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		this.setHardness(2.0F);
		this.setResistance(10.0F / 3.0F);

	}

	public EnumType getType() {
		return this.type;
	}

}
