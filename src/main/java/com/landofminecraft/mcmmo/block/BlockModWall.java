package com.landofminecraft.mcmmo.block;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockModWall extends Block {

	public static final PropertyBool	UP		= PropertyBool.create("up");
	public static final PropertyBool	NORTH	= PropertyBool.create("north");
	public static final PropertyBool	SOUTH	= PropertyBool.create("south");
	public static final PropertyBool	WEST	= PropertyBool.create("west");
	public static final PropertyBool	EAST	= PropertyBool.create("east");

	// copied from BlockWall
	public static final AxisAlignedBB[] AABB_BY_INDEX = new AxisAlignedBB[] {

			new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D),

			new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 1.0D),

			new AxisAlignedBB(0.0D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D),

			new AxisAlignedBB(0.0D, 0.0D, 0.25D, 0.75D, 1.0D, 1.0D),

			new AxisAlignedBB(0.25D, 0.0D, 0.0D, 0.75D, 1.0D, 0.75D),

			new AxisAlignedBB(0.3125D, 0.0D, 0.0D, 0.6875D, 0.875D, 1.0D),

			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 0.75D),

			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 1.0D),

			new AxisAlignedBB(0.25D, 0.0D, 0.25D, 1.0D, 1.0D, 0.75D),

			new AxisAlignedBB(0.25D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D),

			new AxisAlignedBB(0.0D, 0.0D, 0.3125D, 1.0D, 0.875D, 0.6875D),

			new AxisAlignedBB(0.0D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D),

			new AxisAlignedBB(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D),

			new AxisAlignedBB(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D),

			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D),

			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)

	};

	public static final AxisAlignedBB[] CLIP_AABB_BY_INDEX = new AxisAlignedBB[] { AABB_BY_INDEX[0].setMaxY(1.5D),

			AABB_BY_INDEX[1].setMaxY(1.5D),

			AABB_BY_INDEX[2].setMaxY(1.5D),

			AABB_BY_INDEX[3].setMaxY(1.5D),

			AABB_BY_INDEX[4].setMaxY(1.5D),

			AABB_BY_INDEX[5].setMaxY(1.5D),

			AABB_BY_INDEX[6].setMaxY(1.5D),

			AABB_BY_INDEX[7].setMaxY(1.5D),

			AABB_BY_INDEX[8].setMaxY(1.5D),

			AABB_BY_INDEX[9].setMaxY(1.5D),

			AABB_BY_INDEX[10].setMaxY(1.5D),

			AABB_BY_INDEX[11].setMaxY(1.5D),

			AABB_BY_INDEX[12].setMaxY(1.5D),

			AABB_BY_INDEX[13].setMaxY(1.5D),

			AABB_BY_INDEX[14].setMaxY(1.5D),

			AABB_BY_INDEX[15].setMaxY(1.5D)

	};

	public BlockModWall(final Material material) {
		super(material);

		this.setDefaultState(this.blockState.getBaseState().withProperty(UP, false).withProperty(NORTH, false).withProperty(SOUTH, false).withProperty(WEST, false).withProperty(EAST, false));

		this.setSoundType(SoundType.STONE);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { UP, NORTH, EAST, WEST, SOUTH });
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	@Deprecated
	public IBlockState getStateFromMeta(final int meta) {
		IBlockState state = this.getDefaultState();

		state = state.withProperty(NORTH, ((meta >> EnumFacing.NORTH.getHorizontalIndex()) & 1) == 1);
		state = state.withProperty(SOUTH, ((meta >> EnumFacing.SOUTH.getHorizontalIndex()) & 1) == 1);
		state = state.withProperty(WEST, ((meta >> EnumFacing.WEST.getHorizontalIndex()) & 1) == 1);
		state = state.withProperty(EAST, ((meta >> EnumFacing.EAST.getHorizontalIndex()) & 1) == 1);

		return state;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	@Deprecated
	public int getMetaFromState(final IBlockState state) {
		int meta = 0b0000;

		meta |= (state.getValue(NORTH) == true ? 1 : 0) << EnumFacing.NORTH.getHorizontalIndex();
		meta |= (state.getValue(SOUTH) == true ? 1 : 0) << EnumFacing.SOUTH.getHorizontalIndex();
		meta |= (state.getValue(WEST) == true ? 1 : 0) << EnumFacing.WEST.getHorizontalIndex();
		meta |= (state.getValue(EAST) == true ? 1 : 0) << EnumFacing.EAST.getHorizontalIndex();

		return meta;
	}

	/**
	 * @deprecated call via {@link IBlockState#getBoundingBox(IBlockAccess,BlockPos)} whenever possible. Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, final IBlockAccess source, final BlockPos pos) {
		state = this.getActualState(state, source, pos);
		return AABB_BY_INDEX[this.getAABBIndex(state)];
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, final World worldIn, final BlockPos pos, final AxisAlignedBB entityBox, final List<AxisAlignedBB> collidingBoxes, @Nullable final Entity entityIn, final boolean isActualState) {
		if (!isActualState) {
			state = this.getActualState(state, worldIn, pos);
		}

		addCollisionBoxToList(pos, entityBox, collidingBoxes, CLIP_AABB_BY_INDEX[this.getAABBIndex(state)]);
	}

	/**
	 * @deprecated call via {@link IBlockState#getCollisionBoundingBox(IBlockAccess,BlockPos)} whenever possible. Implementing/overriding is fine.
	 */
	@Deprecated
	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, final IBlockAccess worldIn, final BlockPos pos) {
		blockState = this.getActualState(blockState, worldIn, pos);
		return CLIP_AABB_BY_INDEX[this.getAABBIndex(blockState)];
	}

	public int getAABBIndex(final IBlockState state) {
		return this.getMetaFromState(state);
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

	public boolean canConnectTo(final IBlockAccess worldIn, final BlockPos pos, final EnumFacing p_176253_3_) {
		final IBlockState iblockstate = worldIn.getBlockState(pos);
		final Block block = iblockstate.getBlock();
		final BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, pos, p_176253_3_);
		final boolean flag = (blockfaceshape == BlockFaceShape.MIDDLE_POLE_THICK) || ((blockfaceshape == BlockFaceShape.MIDDLE_POLE) && (block instanceof BlockFenceGate));
		return (!isExcepBlockForAttachWithPiston(block) && (blockfaceshape == BlockFaceShape.SOLID)) || flag;
	}

	public static boolean isExcepBlockForAttachWithPiston(final Block p_194143_0_) {
		return Block.isExceptBlockForAttachWithPiston(p_194143_0_) || (p_194143_0_ == Blocks.BARRIER) || (p_194143_0_ == Blocks.MELON_BLOCK) || (p_194143_0_ == Blocks.PUMPKIN) || (p_194143_0_ == Blocks.LIT_PUMPKIN);
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
		final boolean flag = this.canWallConnectTo(worldIn, pos, EnumFacing.NORTH);
		final boolean flag1 = this.canWallConnectTo(worldIn, pos, EnumFacing.EAST);
		final boolean flag2 = this.canWallConnectTo(worldIn, pos, EnumFacing.SOUTH);
		final boolean flag3 = this.canWallConnectTo(worldIn, pos, EnumFacing.WEST);
		final boolean flag4 = (flag && !flag1 && flag2 && !flag3) || (!flag && flag1 && !flag2 && flag3);
		return state.withProperty(UP, Boolean.valueOf(!flag4 || !worldIn.isAirBlock(pos.up()))).withProperty(NORTH, Boolean.valueOf(flag)).withProperty(EAST, Boolean.valueOf(flag1)).withProperty(SOUTH, Boolean.valueOf(flag2)).withProperty(WEST, Boolean.valueOf(flag3));
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
		return (face != EnumFacing.UP) && (face != EnumFacing.DOWN) ? BlockFaceShape.MIDDLE_POLE_THICK : BlockFaceShape.CENTER_BIG;
	}

	/* ======================================== FORGE START ======================================== */

	@Override
	public boolean canBeConnectedTo(final IBlockAccess world, final BlockPos pos, final EnumFacing facing) {
		return this.canConnectTo(world, pos.offset(facing), facing.getOpposite());
	}

	public boolean canWallConnectTo(final IBlockAccess world, final BlockPos pos, final EnumFacing facing) {
		final BlockPos other = pos.offset(facing);
		final Block block = world.getBlockState(other).getBlock();
		return block.canBeConnectedTo(world, other, facing.getOpposite()) || this.canConnectTo(world, other, facing.getOpposite());
	}

	/* ======================================== FORGE END ======================================== */

}
