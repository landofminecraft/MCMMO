package com.landofminecraft.mcmmo.item;

import com.landofminecraft.mcmmo.material.ModMaterial;
import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemModArmor extends ItemArmor implements IItemModMaterial {

	protected final ModMaterial material;

	public ItemModArmor(final ModMaterial material, final EntityEquipmentSlot slot) {
		super(material.getArmorMaterial(), material.getId() + 5, slot);
		ModUtil.setRegistryNames(this, material, ModUtil.getSlotGameNameLowercase(slot));
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
