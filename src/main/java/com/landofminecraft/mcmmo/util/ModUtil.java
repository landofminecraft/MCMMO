package com.landofminecraft.mcmmo.util;

import com.landofminecraft.mcmmo.creativetab.ModCreativeTabs;
import com.landofminecraft.mcmmo.material.ModMaterial;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public final class ModUtil {

	/**
	 * Sets the {@link net.minecraftforge.registries.IForgeRegistryEntry.Impl#setRegistryName(net.minecraft.util.ResourceLocation) Registry Name} and the {@link net.minecraft.block.Block#setUnlocalizedName() Unlocalised Name} for the block taking vanilla overriding into account
	 * @param block      the block to set registry names for
	 * @param material   the {@link cadiboo.wiptech.util.ModEnums.ModMaterial Mod Material} to get the names based on
	 * @param nameSuffix the string to be appended to the names (for example "ore" or "block")
	 */
	public static Block setRegistryNames(final Block block, final ModMaterial material, final String nameSuffix) {
		final ResourceLocation registryName = new ResourceLocation(material.getResouceLocationDomainWithOverrides(nameSuffix, ForgeRegistries.BLOCKS), material.getVanillaNameLowercase(nameSuffix) + (nameSuffix.length() > 0 ? "_" + nameSuffix : ""));
		block.setHardness(material.getProperties().getHardness());
		return setRegistryNames(block, registryName);
	}

	/**
	 * Sets the {@link net.minecraftforge.registries.IForgeRegistryEntry.Impl#setRegistryName(net.minecraft.util.ResourceLocation) Registry Name} and the {@link net.minecraft.item.Item#setUnlocalizedName() Unlocalised Name} for the item taking vanilla overriding and vanilla name quirks into account
	 * @param item       the item to set registry names for
	 * @param material   the {@link cadiboo.wiptech.util.ModEnums.ModMaterial Mod Material} to get the names based on
	 * @param nameSuffix the string to be appended to the names (for example "shovel" or "helmet")
	 */
	public static Item setRegistryNames(final Item item, final ModMaterial material, final String nameSuffix) {
		final ResourceLocation registryName = new ResourceLocation(material.getResouceLocationDomainWithOverrides(nameSuffix, ForgeRegistries.ITEMS), material.getVanillaNameLowercase(nameSuffix) + (nameSuffix.length() > 0 ? "_" + nameSuffix : ""));
		setRegistryNames(item, registryName);

		final Item overriddenItem = ForgeRegistries.ITEMS.getValue(registryName);
		if (overriddenItem != null) {
			item.setTranslationKey(overriddenItem.getTranslationKey().replace("item.", ""));
		}
		return item;
	}

	/**
	 * Sets the {@link net.minecraftforge.registries.IForgeRegistryEntry.Impl#setRegistryName(net.minecraft.util.ResourceLocation) Registry Name} and the {@link net.minecraft.item.Item#setUnlocalizedName() Unlocalised Name} (if applicable) for the entry
	 * @param entry the {@link net.minecraftforge.registries.IForgeRegistryEntry.Impl IForgeRegistryEntry.Impl<?>} to set the names for
	 * @param name  the name for the entry that the registry name is derived from
	 */
	public static <T extends IForgeRegistryEntry.Impl<?>> T setRegistryNames(final T entry, final String name) {
		return setRegistryNames(entry, new ResourceLocation(ModReference.MOD_ID, name));
	}

	/**
	 * Sets the {@link net.minecraftforge.registries.IForgeRegistryEntry.Impl#setRegistryName(net.minecraft.util.ResourceLocation) Registry Name} and the {@link net.minecraft.item.Item#setUnlocalizedName() Unlocalised Name} (if applicable) for the entry
	 * @param entry        the {@link net.minecraftforge.registries.IForgeRegistryEntry.Impl IForgeRegistryEntry.Impl<?>} to set the names for
	 * @param registryName the registry name for the entry that the unlocalised name is also gotten from
	 */
	public static <T extends IForgeRegistryEntry.Impl<?>> T setRegistryNames(final T entry, final ResourceLocation registryName) {
		return setRegistryNames(entry, registryName, registryName.getPath());
	}

	/**
	 * Sets the {@link net.minecraftforge.registries.IForgeRegistryEntry.Impl#setRegistryName(net.minecraft.util.ResourceLocation) Registry Name} and the {@link net.minecraft.item.Item#setUnlocalizedName() Unlocalised Name} (if applicable) for the entry
	 * @param entry           the {@link net.minecraftforge.registries.IForgeRegistryEntry.Impl IForgeRegistryEntry.Impl<?>} to set the names for
	 * @param registryName    the registry name for the entry
	 * @param unlocalizedName the unlocalized name for the entry
	 */
	public static <T extends IForgeRegistryEntry.Impl<?>> T setRegistryNames(final T entry, final ResourceLocation registryName, final String unlocalizedName) {
		entry.setRegistryName(registryName);
		if (entry instanceof Block) {
			((Block) entry).setTranslationKey(unlocalizedName);
			setCreativeTab((Block) entry);
			((Block) entry).setHardness(1);
		}
		if (entry instanceof Item) {
			((Item) entry).setTranslationKey(unlocalizedName);
			setCreativeTab((Item) entry);
		}
		return entry;
	}

	/**
	 * Utility method to make sure that all our items appear on our creative tab, the search tab and any other tab they specify
	 * @param  item the {@link net.minecraft.item.Item Item}
	 * @return      an array of all tabs that this item is on.
	 */
	public static CreativeTabs[] getCreativeTabs(final Item item) {
		return new CreativeTabs[]{item.getCreativeTab(), ModCreativeTabs.CREATIVE_TAB, CreativeTabs.SEARCH};
	}

	/**
	 * Utility method to make sure that all our items appear on our creative tab
	 * @param item the {@link net.minecraft.item.Item Item}
	 */
	public static void setCreativeTab(final Item item) {
		if (item.getCreativeTab() == null) {
			item.setCreativeTab(ModCreativeTabs.CREATIVE_TAB);
		}
	}

	/**
	 * Utility method to make sure that all our blocks appear on our creative tab
	 * @param block the {@link net.minecraft.block.Block Block}
	 */
	public static void setCreativeTab(final Block block) {
		if (block.getCreativeTab() == null) {
			block.setCreativeTab(ModCreativeTabs.CREATIVE_TAB);
		}
	}

	/**
	 * https://stackoverflow.com/a/5732117
	 * @param  input_start
	 * @param  input_end
	 * @param  output_start
	 * @param  output_end
	 * @param  input
	 * @return
	 */
	public static double map(final double input_start, final double input_end, final double output_start, final double output_end, final double input) {
		final double input_range = input_end - input_start;
		final double output_range = output_end - output_start;

		return (((input - input_start) * output_range) / input_range) + output_start;
	}

	/**
	 * Examples:<br>
	 * (TileEntitySuperAdvancedFurnace, "TileEntity") -> super_advanced_furnace<br>
	 * (EntityPortableGenerator, "Entity") -> portable_generator<br>
	 * (TileEntityPortableGenerator, "Entity") -> tile_portable_generator<br>
	 * (EntityPortableEntityGeneratorEntity, "Entity") -> portable_generator<br>
	 * @param  clazz      the class
	 * @param  removeType the string to be removed from the class's name
	 * @return            the recommended registry name for the class
	 */
	public static String getRegistryNameForClass(final Class clazz, final String removeType) {
		return org.apache.commons.lang3.StringUtils.uncapitalize(clazz.getSimpleName().replace(removeType, "")).replaceAll("([A-Z])", "_$1").toLowerCase();
	}

	/**
	 * Examples:<br>
	 * super_advanced_furnace -> Super Advanced Furnace<br>
	 * portable_generator -> Portable Generator<br>
	 * tile_portable_generator -> Tile Portable Generator <br>
	 * @param  unlocalised the unlocalised name in
	 * @return             the recommended localised name for the class
	 */
	public static String getLocalisedName(final String unlocalised) {
		final String[] strs = unlocalised.split("_");
		for (int i = 0; i < strs.length; i++) {
			strs[i] = org.apache.commons.lang3.StringUtils.capitalize(strs[i]);
		}
		final String localisedName = String.join(" ", strs);
		return localisedName;
	}

	/**
	 * Gets the game name from a slot<br>
	 * For example {@link net.minecraft.inventory.EntityEquipmentSlot.CHEST EntityEquipmentSlot.CHEST} -> "chestplate"
	 * @param  slotIn the {@link net.minecraft.inventory.EntityEquipmentSlot EntityEquipmentSlot} to get the name for
	 * @return        the game name for the slot
	 */
	public static String getSlotGameNameLowercase(final EntityEquipmentSlot slotIn) {
		switch (slotIn) {
			case CHEST :
				return "chestplate";
			case FEET :
				return "boots";
			case HEAD :
				return "helmet";
			case LEGS :
				return "leggings";
			default :
				return slotIn.name().toLowerCase();
		}
	}

}
