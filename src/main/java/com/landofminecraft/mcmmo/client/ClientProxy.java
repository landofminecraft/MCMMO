package com.landofminecraft.mcmmo.client;

import com.landofminecraft.mcmmo.util.IProxy;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Some basic functions that differ depending on the physical (client) side
 *
 * @author Cadiboo
 */
public class ClientProxy implements IProxy {

	@Override
	public String localizeAndFormat(final String unlocalized, final Object... args) {
		return I18n.format(unlocalized, args);
	}

	@Override
	public String localize(final String unlocalized) {
		return this.localizeAndFormat(unlocalized, new Object[0]);
	}

	@Override
	public Side getPhysicalSide() {
		return Side.CLIENT;
	}

}
