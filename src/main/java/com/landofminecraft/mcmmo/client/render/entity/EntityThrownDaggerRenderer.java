package com.landofminecraft.mcmmo.client.render.entity;

import com.landofminecraft.mcmmo.entity.EntityThrownDagger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityThrownDaggerRenderer extends Render<EntityThrownDagger> {

	public EntityThrownDaggerRenderer(final RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	public void doRender(final EntityThrownDagger entity, final double x, final double y, final double z, final float entityYaw, final float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);

		try {
			GlStateManager.pushMatrix();
			GlStateManager.translate(x, y + 0.5, z);

			GlStateManager.translate(0, -entity.height / 2, 0);

			GlStateManager.rotate(entityYaw, 0, 1, 0);

			GlStateManager.rotate(90 - entity.rotationPitch, 1, 0, 0);

			final ItemStack stack = new ItemStack(entity.getModMaterial().getDagger());

			IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(stack, entity.getEntityWorld(), null);
			model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.NONE, false);

			this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
			Minecraft.getMinecraft().getRenderItem().renderItem(stack, model);

		} finally {
			GlStateManager.popMatrix();
		}

	}

	@Override
	protected ResourceLocation getEntityTexture(final EntityThrownDagger entity) {
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}

}
