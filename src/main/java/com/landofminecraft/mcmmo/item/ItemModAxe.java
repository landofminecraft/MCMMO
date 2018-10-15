package com.landofminecraft.mcmmo.item;

import com.landofminecraft.mcmmo.material.ModMaterial;
import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemModAxe extends ItemAxe implements IItemModMaterial {

	protected final ModMaterial material;

	public ItemModAxe(final ModMaterial material) {
		super(material.getToolMaterial(), material.getToolMaterial().getAttackDamage(), material.getToolMaterial().getEfficiency());
		ModUtil.setRegistryNames(this, material, "axe");
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
