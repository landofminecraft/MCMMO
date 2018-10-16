package com.landofminecraft.mcmmo.util;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Handles the opening (creation) of Guis for both the server and client
 * 
 * @author Cadiboo
 */
public final class ModGuiHandler implements IGuiHandler {

	/**
	 * gets the server's part of a Gui
	 * 
	 * @return a {@link net.minecraft.inventory.Container Container} for the server
	 */
	@Override
	public Container getServerGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
		switch (ID) {
		default:
			return null;
		}
	}

	/**
	 * gets the client's part of a Gui
	 * 
	 * @return a {@link net.minecraft.client.gui.GuiScreen GuiScreen} for the client
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public GuiScreen getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int x, final int y, final int z) {
		switch (ID) {
		default:
			return null;
		}
	}
}