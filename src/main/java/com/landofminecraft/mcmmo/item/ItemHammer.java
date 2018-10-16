package com.landofminecraft.mcmmo.item;

import com.google.common.collect.ImmutableSet;
import com.landofminecraft.mcmmo.material.ModMaterial;
import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemHammer extends ItemTool implements IItemModMaterial {

	// copy of ItemPickaxe effective on, keep it up to date
	public static final ImmutableSet<Block> EFFECTIVE_ON = ImmutableSet.of(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE);

	final ModMaterial material;

	public ItemHammer(final ModMaterial material) {
		super(material.getToolMaterial(), EFFECTIVE_ON);
		ModUtil.setRegistryNames(this, material, "hammer");
		this.material = material;
	}

	@Override
	public ModMaterial getModMaterial() {
		return this.material;
	}

	// copy of pickaxe
	/**
	 * Check whether this Item can harvest the given Block
	 */
	@Override
	public boolean canHarvestBlock(final IBlockState blockIn) {
		final Block block = blockIn.getBlock();

		if (block == Blocks.OBSIDIAN) {
			return this.getModMaterial().getToolMaterial().getHarvestLevel() >= 3;
		} else if ((block != Blocks.DIAMOND_BLOCK) && (block != Blocks.DIAMOND_ORE)) {
			if ((block != Blocks.EMERALD_ORE) && (block != Blocks.EMERALD_BLOCK)) {
				if ((block != Blocks.GOLD_BLOCK) && (block != Blocks.GOLD_ORE)) {
					if ((block != Blocks.IRON_BLOCK) && (block != Blocks.IRON_ORE)) {
						if ((block != Blocks.LAPIS_BLOCK) && (block != Blocks.LAPIS_ORE)) {
							if ((block != Blocks.REDSTONE_ORE) && (block != Blocks.LIT_REDSTONE_ORE)) {
								final Material material = blockIn.getMaterial();

								if (material == Material.ROCK) {
									return true;
								} else if (material == Material.IRON) {
									return true;
								} else {
									return material == Material.ANVIL;
								}
							} else {
								return this.toolMaterial.getHarvestLevel() >= 2;
							}
						} else {
							return this.toolMaterial.getHarvestLevel() >= 1;
						}
					} else {
						return this.toolMaterial.getHarvestLevel() >= 1;
					}
				} else {
					return this.toolMaterial.getHarvestLevel() >= 2;
				}
			} else {
				return this.toolMaterial.getHarvestLevel() >= 2;
			}
		} else {
			return this.toolMaterial.getHarvestLevel() >= 2;
		}
	}

	@Override
	public int getHarvestLevel(final ItemStack stack, final String toolClass, final EntityPlayer player, final IBlockState blockState) {
		return this.getModMaterial().getToolMaterial().getHarvestLevel();
	}

}
