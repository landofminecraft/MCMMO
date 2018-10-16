package com.landofminecraft.mcmmo.entity;

import com.landofminecraft.mcmmo.material.ModMaterial;
import com.landofminecraft.mcmmo.network.datasync.ModDataSerializers;
import com.landofminecraft.mcmmo.util.ModDamageSource;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityThrownDagger extends EntityThrowable implements IEntityModMaterial {

	public static final DataParameter<Boolean>		CRITICAL	= EntityDataManager.<Boolean>createKey(EntityArrow.class, DataSerializers.BOOLEAN);
	public static final DataParameter<ModMaterial>	MATERIAL	= EntityDataManager.<ModMaterial>createKey(EntityThrownDagger.class, ModDataSerializers.MATERIAL);

	public EntityArrow.PickupStatus pickupStatus;

	public EntityThrownDagger(final World worldIn) {
		super(worldIn);
		this.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
		this.setSize(0.5F, 0.5F);

	}

	public EntityThrownDagger(final World worldIn, final double x, final double y, final double z) {
		this(worldIn);
		this.setPosition(x, y, z);
	}

	public EntityThrownDagger(final World worldIn, final EntityLivingBase shooter) {
		this(worldIn, shooter.posX, (shooter.posY + shooter.getEyeHeight()) - 0.10000000149011612D, shooter.posZ);
		this.thrower = shooter;

		if (shooter instanceof EntityPlayer) {
			this.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
		}
	}

	@Override
	protected void entityInit() {
		this.dataManager.register(MATERIAL, ModMaterial.values()[0]);
		this.dataManager.register(CRITICAL, false);
	}

	/**
	 * Checks if the entity is in range to render.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isInRangeToRenderDist(final double distance) {
		double d0 = this.getEntityBoundingBox().getAverageEdgeLength() * 10.0D;

		if (Double.isNaN(d0)) {
			d0 = 1.0D;
		}

		d0 = d0 * 64.0D * getRenderDistanceWeight();
		return distance < (d0 * d0);
	}

	public void setModMaterial(final ModMaterial material) {
		this.dataManager.set(MATERIAL, material);
	}

	@Override
	public ModMaterial getModMaterial() {
		return this.dataManager.get(MATERIAL);
	}

	public void setIsCritical(final boolean critical) {
		this.dataManager.set(CRITICAL, critical);
	}

	public boolean isCritical() {
		return this.dataManager.get(CRITICAL);
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		super.onUpdate();
	}

	@Override
	protected void onImpact(final RayTraceResult result) {
		if (result.typeOfHit == Type.ENTITY) {
			if (result.entityHit != null) {
				result.entityHit.attackEntityFrom(ModDamageSource.THROWN_DAGGER, this.getModMaterial().getDagger().getAttackDamage());
			}
		} else if (result.typeOfHit == Type.BLOCK) {
			this.posX = result.hitVec.x;
			this.posY = result.hitVec.y;
			this.posZ = result.hitVec.z;

			this.prevPosX = result.hitVec.x;
			this.prevPosY = result.hitVec.y;
			this.prevPosZ = result.hitVec.z;
			//
			// this.motionX *= 0.5;
			// this.motionY *= 0.5;
			// this.motionZ *= 0.5;

			this.inGround = true;

			// why tf isn't all this public

			// set xyz tile to pos
			ReflectionHelper.setPrivateValue(EntityThrowable.class, this, result.getBlockPos().getX(), "field_145788_c", "xTile");
			ReflectionHelper.setPrivateValue(EntityThrowable.class, this, result.getBlockPos().getY(), "field_145786_d", "yTile");
			ReflectionHelper.setPrivateValue(EntityThrowable.class, this, result.getBlockPos().getZ(), "field_145787_e", "zTile");

			// set inTile to the tile we are in
			ReflectionHelper.setPrivateValue(EntityThrowable.class, this, this.world.getBlockState(result.getBlockPos()).getBlock(), "field_174853_f", "inTile");

			this.isAirBorne = true;

			// ((WorldServer) this.world).setEntityState(this, (byte) 200);
			this.world.setEntityState(this, (byte) 200);

		}
	}

	@Override
	public void onCollideWithPlayer(final EntityPlayer entityIn) {
		if (!this.world.isRemote && this.inGround && (this.throwableShake <= 0)) {
			boolean wasPickedUpFlag = (this.pickupStatus == EntityArrow.PickupStatus.ALLOWED) || ((this.pickupStatus == EntityArrow.PickupStatus.CREATIVE_ONLY) && entityIn.capabilities.isCreativeMode);

			if ((this.pickupStatus == EntityArrow.PickupStatus.ALLOWED) && !entityIn.inventory.addItemStackToInventory(new ItemStack(this.getModMaterial().getDagger()))) {
				wasPickedUpFlag = false;
			}

			if (wasPickedUpFlag) {
				entityIn.onItemPickup(this, 1);
				this.setDead();
			}
		}
	}

}
