package com.landofminecraft.mcmmo.server;

import com.landofminecraft.mcmmo.util.ModReference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * EventSubscriber for server physical sided events
 *
 * @author Cadiboo
 */
@SideOnly(Side.SERVER)
@Mod.EventBusSubscriber(modid = ModReference.MOD_ID, value = Side.SERVER)
public final class ServerEventSubscriber {

}