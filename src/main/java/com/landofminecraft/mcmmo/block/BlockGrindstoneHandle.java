package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockGrindstoneHandle extends Block {

	public BlockGrindstoneHandle(final String name) {
		super(Material.WOOD);
		ModUtil.setRegistryNames(this, name);
	}

	@Override
	public boolean isFullBlock(final IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(final IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(final IBlockState state) {
		return false;
	}

}
