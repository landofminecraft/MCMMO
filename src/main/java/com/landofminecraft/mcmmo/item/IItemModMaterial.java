package com.landofminecraft.mcmmo.item;

import javax.annotation.Nonnull;

import com.landofminecraft.mcmmo.material.ModMaterial;

public interface IItemModMaterial extends IModItem {

	@Nonnull
	ModMaterial getModMaterial();

}
