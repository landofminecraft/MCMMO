package com.landofminecraft.mcmmo.block;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.landofminecraft.mcmmo.util.ModUtil;

import net.minecraft.block.BlockStone.EnumType;
import net.minecraft.init.Blocks;

public class BlockStoneStructureWall extends BlockModStructureWall {

	private final EnumType type;

	public BlockStoneStructureWall(final EnumType type) {
		super(Blocks.LOG.getDefaultState().getMaterial());
		// smooth_andesite -> andesite_smooth
		ModUtil.setRegistryNames(this, StringUtils.join(Arrays.asList(type.getName().split("_")).stream().collect(Collectors.toCollection(LinkedList::new)).descendingIterator(), "_") + "_" + SUFFIX);

		this.type = type;

//		(new BlockStone()).setHardness(1.5F).setResistance(10.0F).setSoundType(SoundType.STONE).setTranslationKey("stone"));

		this.setHardness(1.5F);
		this.setResistance(10.0F / 3.0F);

	}

	public EnumType getType() {
		return this.type;
	}

}
