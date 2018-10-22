package com.landofminecraft.mcmmo.block;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;

public class BlockConcreteWall extends BlockModWall {

	public static final String SUFFIX = "concrete_wall";

	private final EnumDyeColor color;

	public BlockConcreteWall(final EnumDyeColor color) {
		super(Blocks.CONCRETE.getDefaultState().getMaterial());
		ModUtil.setRegistryNames(this, color.getName() + "_" + SUFFIX);
		this.color = color;

//      registerBlock(251, "concrete", (new BlockColored(Material.ROCK)).setHardness(1.8F).setSoundType(SoundType.STONE).setTranslationKey("concrete"));

		this.setHardness(1.8F);
		this.setResistance(7.0F / 3.0F);

	}

	public EnumDyeColor getColor() {
		return this.color;
	}

}
