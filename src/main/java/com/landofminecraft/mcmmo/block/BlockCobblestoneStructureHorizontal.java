package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.BlockWall;
import net.minecraft.block.BlockWall.EnumType;
import net.minecraft.init.Blocks;

public class BlockCobblestoneStructureHorizontal extends BlockModStructureHorizontal {

	public static final String SUFFIX = "structure_horizontal";

	private final BlockWall.EnumType type;

	public BlockCobblestoneStructureHorizontal(final EnumType type) {
		super(Blocks.CONCRETE.getDefaultState().getMaterial());
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
