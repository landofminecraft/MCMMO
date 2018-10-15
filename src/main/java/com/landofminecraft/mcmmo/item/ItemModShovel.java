package com.landofminecraft.mcmmo.item;

import com.landofminecraft.mcmmo.material.ModMaterial;
import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ItemModShovel extends ItemSpade implements IItemModMaterial {

	protected final ModMaterial material;

	public ItemModShovel(final ModMaterial material) {
		super(material.getToolMaterial());
		ModUtil.setRegistryNames(this, material, "shovel");
		this.material = material;
	}

	@Override
	public ModMaterial getModMaterial() {
		return this.material;
	}

	@Override
	public CreativeTabs[] getCreativeTabs() {
		return ModUtil.getCreativeTabs(this);
	}

}
