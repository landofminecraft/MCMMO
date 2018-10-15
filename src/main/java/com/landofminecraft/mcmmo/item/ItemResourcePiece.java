package com.landofminecraft.mcmmo.item;

import com.landofminecraft.mcmmo.material.ModMaterial;
import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemResourcePiece extends Item implements IItemModMaterial {

	private final ModMaterial material;

	public ItemResourcePiece(final ModMaterial material) {
		ModUtil.setRegistryNames(this, material, material.getProperties().getResourcePieceSuffix());
		this.material = material;
	}

	@Override
	public final ModMaterial getModMaterial() {
		return this.material;
	}

	@Override
	public CreativeTabs[] getCreativeTabs() {
		return ModUtil.getCreativeTabs(this);
	}

}
