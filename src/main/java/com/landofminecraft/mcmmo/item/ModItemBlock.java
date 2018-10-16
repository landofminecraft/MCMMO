package com.landofminecraft.mcmmo.item;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

/**
 * Same as {@link ItemBlock} but handles our registry name & creative tab automatically
 *
 * @author Cadiboo
 */
public class ModItemBlock extends ItemBlock {

	public ModItemBlock(final Block block) {
		this(block, block.getRegistryName());
	}

	public ModItemBlock(final Block block, final ResourceLocation registryName) {
		super(block);
		ModUtil.setRegistryNames(this, registryName);
	}

	@Override
	public CreativeTabs[] getCreativeTabs() {
		return ModUtil.getCreativeTabs(this);
	}

}
