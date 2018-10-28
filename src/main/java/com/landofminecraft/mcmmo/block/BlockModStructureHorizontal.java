package com.landofminecraft.mcmmo.block;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockModStructureHorizontal extends Block {

	public static final PropertyBool	NORTH_EAST	= PropertyBool.create("north_east");
	public static final PropertyBool	NORTH_WEST	= PropertyBool.create("north_west");
	public static final PropertyBool	SOUTH_EAST	= PropertyBool.create("south_east");
	public static final PropertyBool	SOUTH_WEST	= PropertyBool.create("south_west");

	// NORTH_EAST + -
	// NORTH_WEST - -
	// SOUTH_EAST + +
	// SOUTH_WEST - +

	public static final AxisAlignedBB	PILLAR_AABB		= new AxisAlignedBB(0.25D, 0.00D, 0.25D, 0.75D, 1.00D, 0.75D);
	public static final AxisAlignedBB	NORTH_EAST_AABB	= new AxisAlignedBB(0.50D, 0.00D, 0.50D, 1.00D, 1.00D, 0.00D);
	public static final AxisAlignedBB	NORTH_WEST_AABB	= new AxisAlignedBB(0.50D, 0.00D, 0.50D, 0.00D, 1.00D, 0.00D);
	public static final AxisAlignedBB	SOUTH_EAST_AABB	= new AxisAlignedBB(0.50D, 0.00D, 0.50D, 1.00D, 1.00D, 1.00D);
	public static final AxisAlignedBB	SOUTH_WEST_AABB	= new AxisAlignedBB(0.50D, 0.00D, 0.50D, 0.00D, 1.00D, 1.00D);

	public BlockModStructureHorizontal(final Material material) {
		super(material);

		this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH_EAST, false).withProperty(NORTH_WEST, false).withProperty(SOUTH_EAST, false).withProperty(SOUTH_WEST, false));

		this.setSoundType(SoundType.STONE);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST });
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	@Deprecated
	public IBlockState getStateFromMeta(final int meta) {
		IBlockState state = this.getDefaultState();

		final boolean north_east = ((meta >> EnumFacing.NORTH.getHorizontalIndex()) & 1) == 1;
		final boolean north_west = ((meta >> EnumFacing.EAST.getHorizontalIndex()) & 1) == 1;
		final boolean south_east = ((meta >> EnumFacing.SOUTH.getHorizontalIndex()) & 1) == 1;
		final boolean south_west = ((meta >> EnumFacing.WEST.getHorizontalIndex()) & 1) == 1;

		state = state.withProperty(NORTH_EAST, north_east);
		state = state.withProperty(NORTH_WEST, north_west);
		state = state.withProperty(SOUTH_EAST, south_east);
		state = state.withProperty(SOUTH_WEST, south_west);

		return state;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	@Deprecated
	public int getMetaFromState(final IBlockState state) {
		int meta = 0b0000;

		final int north_east = (state.getValue(NORTH_EAST) == true ? 1 : 0) << EnumFacing.NORTH.getHorizontalIndex();
		final int north_west = (state.getValue(NORTH_WEST) == true ? 1 : 0) << EnumFacing.EAST.getHorizontalIndex();
		final int south_east = (state.getValue(SOUTH_EAST) == true ? 1 : 0) << EnumFacing.SOUTH.getHorizontalIndex();
		final int south_west = (state.getValue(SOUTH_WEST) == true ? 1 : 0) << EnumFacing.WEST.getHorizontalIndex();

		meta |= north_east;
		meta |= north_west;
		meta |= south_east;
		meta |= south_west;

		return meta;
	}

	/**
	 * @deprecated call via {@link IBlockState#getBoundingBox(IBlockAccess,BlockPos)} whenever possible. Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, final IBlockAccess source, final BlockPos pos) {
		state = this.getActualState(state, source, pos);
		return getAABB(state);
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, final World worldIn, final BlockPos pos, final AxisAlignedBB entityBox, final List<AxisAlignedBB> collidingBoxes, @Nullable final Entity entityIn, final boolean isActualState) {
		if (!isActualState) {
			state = this.getActualState(state, worldIn, pos);
		}

		addCollisionBoxToList(pos, entityBox, collidingBoxes, this.getAABB(state));
	}

	/**
	 * @deprecated call via {@link IBlockState#getCollisionBoundingBox(IBlockAccess,BlockPos)} whenever possible. Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, final IBlockAccess worldIn, final BlockPos pos) {
		blockState = this.getActualState(blockState, worldIn, pos);
		return getAABB(blockState);
	}

	public static AxisAlignedBB getAABB(final IBlockState state) {
		final boolean north_east = state.getValue(NORTH_EAST) == true;
		final boolean north_west = state.getValue(NORTH_WEST) == true;
		final boolean south_east = state.getValue(SOUTH_EAST) == true;
		final boolean south_west = state.getValue(SOUTH_WEST) == true;

		AxisAlignedBB AABB = PILLAR_AABB;
		if (north_east) {
			AABB = AABB.union(NORTH_EAST_AABB);
		}
		if (north_west) {
			AABB = AABB.union(NORTH_WEST_AABB);
		}
		if (south_east) {
			AABB = AABB.union(SOUTH_EAST_AABB);
		}
		if (south_west) {
			AABB = AABB.union(SOUTH_WEST_AABB);
		}

		return AABB;
	}

	/**
	 * @deprecated call via {@link IBlockState#isFullCube()} whenever possible. Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	public boolean isFullCube(final IBlockState state) {
		return false;
	}

	/**
	 * Determines if an entity can path through this block
	 */
	@Override
	public boolean isPassable(final IBlockAccess worldIn, final BlockPos pos) {
		return false;
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 *
	 * @deprecated call via {@link IBlockState#isOpaqueCube()} whenever possible. Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	public boolean isOpaqueCube(final IBlockState state) {
		return false;
	}

	/**
	 * @deprecated call via {@link IBlockState#shouldSideBeRendered(IBlockAccess,BlockPos,EnumFacing)} whenever possible. Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(final IBlockState blockState, final IBlockAccess blockAccess, final BlockPos pos, final EnumFacing side) {
		return side == EnumFacing.DOWN ? super.shouldSideBeRendered(blockState, blockAccess, pos, side) : true;
	}

	/**
	 * Get the actual Block state of this Block at the given position. This applies properties not visible in the metadata, such as fence connections.
	 */
	@Override
	public IBlockState getActualState(final IBlockState state, final IBlockAccess worldIn, final BlockPos pos) {
		final boolean north_east = canWallConnectTo(worldIn, pos, EnumFacing.NORTH) && canWallConnectTo(worldIn, pos, EnumFacing.EAST);
		final boolean north_west = canWallConnectTo(worldIn, pos, EnumFacing.NORTH) && canWallConnectTo(worldIn, pos, EnumFacing.WEST);
		final boolean south_east = canWallConnectTo(worldIn, pos, EnumFacing.SOUTH) && canWallConnectTo(worldIn, pos, EnumFacing.EAST);
		final boolean south_west = canWallConnectTo(worldIn, pos, EnumFacing.SOUTH) && canWallConnectTo(worldIn, pos, EnumFacing.WEST);
		return state.withProperty(NORTH_EAST, north_east).withProperty(NORTH_WEST, north_west).withProperty(SOUTH_EAST, south_east).withProperty(SOUTH_WEST, south_west);
	}

	/**
	 * Get the geometry of the queried face at the given position and state. This is used to decide whether things like buttons are allowed to be placed on the face, or how glass panes connect to the face, among other things.
	 * <p>
	 * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED}, which represents something that does not fit the other descriptions and will generally cause other things not to connect to the face.
	 *
	 * @return an approximation of the form of the given face
	 * @deprecated call via {@link IBlockState#getBlockFaceShape(IBlockAccess,BlockPos,EnumFacing)} whenever possible. Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	public BlockFaceShape getBlockFaceShape(final IBlockAccess worldIn, final IBlockState state, final BlockPos pos, final EnumFacing face) {
		return BlockFaceShape.SOLID;

		// return (face != EnumFacing.UP) && (face != EnumFacing.DOWN) ? BlockFaceShape.MIDDLE_POLE_THICK : BlockFaceShape.CENTER_BIG;
	}

	/* ======================================== FORGE START ======================================== */

	@Override
	public boolean canBeConnectedTo(final IBlockAccess world, final BlockPos pos, final EnumFacing facing) {
		return true;
	}

	public static boolean canWallConnectTo(final IBlockAccess world, final BlockPos pos, final EnumFacing facing) {
		return BlockModStructureWall.canWallConnectTo(world, pos, facing);
	}

	/* ======================================== FORGE END ======================================== */

	@Override
	public boolean isSideSolid(final IBlockState base_state, final IBlockAccess world, final BlockPos pos, final EnumFacing side) {
		if (true) {
			return true;
		}
		return false;
	}

}
