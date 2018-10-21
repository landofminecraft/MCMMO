package com.landofminecraft.mcmmo.item;

import com.landofminecraft.mcmmo.material.ModMaterial;
import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemModHorseArmor extends Item implements IItemModMaterial {

	public static final String SUFFIX = "horse_armor";

	protected final ModMaterial material;

	public ItemModHorseArmor(final ModMaterial material) {
		super();
		this.setMaxStackSize(1);
		this.setCreativeTab(Items.IRON_HORSE_ARMOR.getCreativeTab());
		ModUtil.setRegistryNames(this, material, SUFFIX);
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

	@Override
	public HorseArmorType getHorseArmorType(final ItemStack stack) {
		return this.getModMaterial().getHorseArmorType();
	}

}
