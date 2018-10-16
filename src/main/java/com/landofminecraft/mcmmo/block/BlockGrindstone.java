package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.MinecraftMMO;
import com.landofminecraft.mcmmo.tileentity.TileEntityGrindstone;
import com.landofminecraft.mcmmo.util.ModGuiHandler;
import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGrindstone extends BlockHorizontal {

	public BlockGrindstone(final String name) {
		super(Material.ROCK);
		ModUtil.setRegistryNames(this, name);
	}

	@Override
	public boolean hasTileEntity(final IBlockState state) {
		return true;
	}

	@Override
	public TileEntityGrindstone createTileEntity(final World world, final IBlockState state) {
		return new TileEntityGrindstone();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return state.getValue(FACING).getHorizontalIndex();

	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta));
	}

	@Override
	public IBlockState getStateForPlacement(final World world, final BlockPos pos, final EnumFacing facing, final float hitX, final float hitY, final float hitZ, final int meta, final EntityLivingBase placer) {
		final EnumFacing enumfacing = placer.getHorizontalFacing().getOpposite();
		return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, enumfacing);
	}

	@Override
	public boolean onBlockActivated(final World worldIn, final BlockPos pos, final IBlockState state, final EntityPlayer playerIn, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ) {
		if (worldIn.isRemote) {
			return true;
		} else {
			final TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityGrindstone) {
				playerIn.openGui(MinecraftMMO.instance, ModGuiHandler.GRINDSTONE, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}

			return true;
		}
	}

}
