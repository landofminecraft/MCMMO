package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.material.ModMaterial;
import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * The same as a block of Iron or a block of Gold but for all materials
 *
 * @author Cadiboo
 */
public class BlockResource extends Block implements IBlockModMaterial {

	public static final String SUFFIX = "block";

	protected final ModMaterial material;

	public BlockResource(final ModMaterial material) {
		super(Material.IRON);
		ModUtil.setRegistryNames(this, material, SUFFIX);
		this.material = material;
	}

	@Override
	public final ModMaterial getModMaterial() {
		return this.material;
	}

	@Override
	public boolean isBeaconBase(final IBlockAccess worldObj, final BlockPos pos, final BlockPos beacon) {
		return true;
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return this.material.getProperties().getBlockRenderLayers().get(0);
	}

	@Override
	public boolean canRenderInLayer(final IBlockState state, final BlockRenderLayer layer) {
		return this.material.getProperties().getBlockRenderLayers().contains(layer);
	}

	@Override
	public boolean isFullCube(final IBlockState state) {
		return true;
	}

	@Override
	public boolean isOpaqueCube(final IBlockState state) {
		/* have to do this because isOpaqueCube is called in Block.<init> (before our material is set) */
		if (this.getModMaterial() == null) {
			return true;
		}
		return (this.getModMaterial().getProperties().getBlockRenderLayers().size() == 1) && this.getModMaterial().getProperties().getBlockRenderLayers().contains(BlockRenderLayer.SOLID);
	}

}
