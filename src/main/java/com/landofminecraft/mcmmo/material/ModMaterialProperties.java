package com.landofminecraft.mcmmo.material;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;

public class ModMaterialProperties {

	private final boolean hasOre;
	private final boolean hasBlock;
	private final boolean hasResource;
	@Nonnull
	final String resourceSuffix;
	private final boolean hasResourcePiece;
	@Nonnull
	final String resourcePieceSuffix;
	private final boolean hasHelmet;
	private final boolean hasChestplate;
	private final boolean hasLeggings;
	private final boolean hasBoots;
	private final boolean hasHorseArmor;
	private final boolean hasPickaxe;
	private final boolean hasAxe;
	private final boolean hasSword;
	private final boolean hasShovel;
	private final boolean hasHoe;
	private final float hardness;
	/** if null reverts to getItemFromBlock(block) */
	@Nullable
	private final Supplier<Item> getOreDrop;
	@Nonnull
	private final BlockRenderLayer[] blockRenderLayers;
	@Nonnull
	private final BiFunction<Integer, Random, Integer> getQuantityDroppedWithBonus;

	public ModMaterialProperties(
	/*@formatter:off*/
		final boolean hasOre,
		final boolean hasBlock,
		final boolean hasResource,
		@Nonnull
		final String resourceSuffix,
		final boolean hasResourcePiece,
		@Nonnull
		final String resourcePieceSuffix,
		final boolean hasHelmet,
		final boolean hasChestplate,
		final boolean hasLeggings,
		final boolean hasBoots,
		final boolean hasHorseArmor,
		final boolean hasPickaxe,
		final boolean hasAxe,
		final boolean hasSword,
		final boolean hasShovel,
		final boolean hasHoe,
		final float MOHS_Hardness,
		@Nullable
		final Supplier<Item> getOreDrop,
		@Nullable
		final BlockRenderLayer[] blockRenderLayers,
		@Nonnull
		@MethodsReturnNonnullByDefault
		final BiFunction<Integer, Random, Integer> getQuantityDroppedWithBonus
	/*@formatter:on*/
	) {

		this.hasOre = hasOre;
		this.hasBlock = hasBlock;
		this.hasResource = hasResource;
		this.resourceSuffix = resourceSuffix;
		this.hasResourcePiece = hasResourcePiece;
		this.resourcePieceSuffix = resourcePieceSuffix;
		this.hasHelmet = hasHelmet;
		this.hasChestplate = hasChestplate;
		this.hasLeggings = hasLeggings;
		this.hasBoots = hasBoots;
		this.hasHorseArmor = hasHorseArmor;
		this.hasPickaxe = hasPickaxe;
		this.hasAxe = hasAxe;
		this.hasSword = hasSword;
		this.hasShovel = hasShovel;
		this.hasHoe = hasHoe;
		this.hardness = MOHS_Hardness;
		this.getOreDrop = getOreDrop;
		if (blockRenderLayers == null) {
			this.blockRenderLayers = new BlockRenderLayer[]{null};
		} else {
			this.blockRenderLayers = blockRenderLayers;
		}
		this.getQuantityDroppedWithBonus = getQuantityDroppedWithBonus;

	}

	public boolean hasOre() {
		return this.hasOre;
	}

	public boolean hasBlock() {
		return this.hasBlock;
	}

	public boolean hasResource() {
		return this.hasResource;
	}

	public String getResourceSuffix() {
		return this.resourceSuffix;
	}

	public boolean hasResourcePiece() {
		return this.hasResourcePiece;
	}

	public String getResourcePieceSuffix() {
		return this.resourcePieceSuffix;
	}

	public boolean hasHelmet() {
		return this.hasHelmet;
	}

	public boolean hasChestplate() {
		return this.hasChestplate;
	}

	public boolean hasLeggings() {
		return this.hasLeggings;
	}

	public boolean hasBoots() {
		return this.hasBoots;
	}

	public boolean hasHorseArmor() {
		return this.hasHorseArmor;
	}

	public boolean hasPickaxe() {
		return this.hasPickaxe;
	}

	public boolean hasAxe() {
		return this.hasAxe;
	}

	public boolean hasSword() {
		return this.hasSword;
	}

	public boolean hasShovel() {
		return this.hasShovel;
	}

	public boolean hasHoe() {
		return this.hasHoe;
	}

	public float getHardness() {
		return this.hardness;
	}

	@Nullable
	public Item getOreDrop() {
		return this.getOreDrop.get();
	}

	@Nonnull
	public List<BlockRenderLayer> getBlockRenderLayers() {
		return Arrays.asList(this.blockRenderLayers);
	}

	@Override
	public String toString() {
		String string = super.toString() + " - ";
		string += "hasOre: " + this.hasOre();
		string += ", hasBlock: " + this.hasBlock();
		string += ", hasResource: " + this.hasResource();
		string += ", hasResourcePiece: " + this.hasResourcePiece();
		string += ", hasHelmet: " + this.hasHelmet();
		string += ", hasChestplate: " + this.hasChestplate();
		string += ", hasLeggings: " + this.hasLeggings();
		string += ", hasBoots: " + this.hasBoots();
		string += ", hasPickaxe: " + this.hasPickaxe();
		string += ", hasAxe: " + this.hasAxe();
		string += ", hasSword: " + this.hasSword();
		string += ", hasShovel: " + this.hasShovel();
		string += ", hasHoe: " + this.hasHoe();
		string += ", hardness: " + this.getHardness();
		return string;
	}

	public int getQuantityDroppedWithBonus(final int fortune, final Random random) {
		// return 1;
		return this.getQuantityDroppedWithBonus.apply(fortune, random);
	}

}
