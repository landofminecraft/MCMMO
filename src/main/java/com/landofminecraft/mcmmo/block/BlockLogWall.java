package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.init.Blocks;

public class BlockLogWall extends BlockModWall {

	public static final String SUFFIX = "log_" + BlockModWall.SUFFIX;

	private final EnumType type;

	public BlockLogWall(final EnumType type) {
		super(Blocks.LOG.getDefaultState().getMaterial());
		ModUtil.setRegistryNames(this, type.getName() + "_" + SUFFIX);

		this.type = type;

//      super(Material.WOOD);
//      this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
//      this.setHardness(2.0F);
//      this.setSoundType(SoundType.WOOD);

		this.setHardness(2.0F);
		this.setResistance(5.0F / 3.0F);

	}

	public EnumType getType() {
		return this.type;
	}

}
