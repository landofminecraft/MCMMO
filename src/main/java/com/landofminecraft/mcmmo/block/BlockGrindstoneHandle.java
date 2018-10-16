package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGrindstoneHandle extends Block {

	public BlockGrindstoneHandle(final String name) {
		super(Material.WOOD);
		ModUtil.setRegistryNames(this, name);
	}
}
