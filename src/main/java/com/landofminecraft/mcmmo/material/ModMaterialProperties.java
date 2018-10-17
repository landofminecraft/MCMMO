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

	public static final String	NULL_RESOURCE_SUFFIX		= "";
	public static final String	NULL_RESOURCE_PIECE_SUFFIX	= "";

	private final boolean	hasOre;
	private final boolean	hasBlock;

	private final boolean	hasResource;
	@Nonnull
	final String			resourceSuffix;
	private final boolean	hasResourcePiece;
	@Nonnull
	final String			resourcePieceSuffix;

	private final boolean	hasHelmet;
	private final boolean	hasChestplate;
	private final boolean	hasLeggings;
	private final boolean	hasBoots;
	private final boolean	hasHorseArmor;

	private final boolean	hasPickaxe;
	private final boolean	hasAxe;
	private final boolean	hasSword;
	private final boolean	hasShovel;
	private final boolean	hasHoe;
	private final boolean	hasMace;
	private final boolean	hasHammer;
	private final boolean	hasWarAxe;
	private final boolean	hasCurvedSword;
	private final boolean	hasDagger;

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
		@Nullable
		final String resourceSuffix,
		final boolean hasResourcePiece,
		@Nullable
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
		final boolean hasMace,
		final boolean hasHammer,
		final boolean hasWarAxe,
		final boolean hasCurvedSword,
		final boolean hasDagger,
		final float MOHS_Hardness,
		@Nullable
		final Supplier<Item> getOreDrop,
		@Nullable
		final BlockRenderLayer[] blockRenderLayers,
		@Nonnull
		@MethodsReturnNonnullByDefault
		final BiFunction<Integer, Random, Integer> getQuantityDroppedWithBonusFromOre
	/*@formatter:on*/
	) {

		this.hasOre = hasOre;
		this.hasBlock = hasBlock;
		this.hasResource = hasResource;
		if (resourceSuffix == null) {
			this.resourceSuffix = NULL_RESOURCE_SUFFIX;
		} else {
			this.resourceSuffix = resourceSuffix;
		}
		this.hasResourcePiece = hasResourcePiece;
		if (resourceSuffix == null) {
			this.resourcePieceSuffix = NULL_RESOURCE_PIECE_SUFFIX;
		} else {
			this.resourcePieceSuffix = resourcePieceSuffix;
		}
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
		this.hasMace = hasMace;
		this.hasHammer = hasHammer;
		this.hasWarAxe = hasWarAxe;
		this.hasCurvedSword = hasCurvedSword;
		this.hasDagger = hasDagger;
		this.hardness = MOHS_Hardness;
		this.getOreDrop = getOreDrop;
		if (blockRenderLayers == null) {
			this.blockRenderLayers = new BlockRenderLayer[0];
		} else {
			this.blockRenderLayers = blockRenderLayers;
		}
		this.getQuantityDroppedWithBonus = getQuantityDroppedWithBonusFromOre;

	}

	public ModMaterialProperties(
	/*@formatter:off*/
		final boolean hasOre,
		final boolean hasBlock,
		final boolean hasResource,
		@Nullable
		final String resourceSuffix,
		final boolean hasResourcePiece,
		@Nullable
		final String resourcePieceSuffix,
		final boolean hasArmor,
		final boolean hasTools,
		final float MOHS_Hardness,
		@Nullable
		final Supplier<Item> getOreDrop,
		@Nullable
		final BlockRenderLayer[] blockRenderLayers,
		@Nonnull
		@MethodsReturnNonnullByDefault
		final BiFunction<Integer, Random, Integer> getQuantityDroppedWithBonusFromOre
	/*@formatter:on*/
	) {

		this(hasOre, hasBlock, hasResource, resourceSuffix, hasResourcePiece, resourcePieceSuffix, hasArmor, hasArmor, hasArmor, hasArmor, hasArmor, hasTools, hasTools, hasTools, hasTools, hasTools, hasTools, hasTools, hasTools, hasTools, hasTools, MOHS_Hardness, getOreDrop, blockRenderLayers, getQuantityDroppedWithBonusFromOre);

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

	public boolean hasMace() {
		return this.hasMace;
	}

	public boolean hasHammer() {
		return this.hasHammer;
	}

	public boolean hasWarAxe() {
		return this.hasWarAxe;
	}

	public boolean hasCurvedSword() {
		return this.hasCurvedSword;
	}

	public boolean hasDagger() {
		return this.hasDagger;
	}

	public float getHardness() {
		return this.hardness;
	}

	@Nullable
	public Item getOreDrop() {
		if (this.getOreDrop == null) {
			return null;
		}
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
		string += ", hasMace: " + this.hasMace();
		string += ", hasHammer: " + this.hasHammer();
		string += ", hasWarAxe: " + this.hasWarAxe();
		string += ", hasCurvedSword: " + this.hasCurvedSword();
		string += ", hasDagger: " + this.hasDagger();
		string += ", hardness: " + this.getHardness();
		return string;
	}

	public int getQuantityDroppedWithBonus(final int fortune, final Random random) {
		return this.getQuantityDroppedWithBonus.apply(fortune, random);
	}

}
