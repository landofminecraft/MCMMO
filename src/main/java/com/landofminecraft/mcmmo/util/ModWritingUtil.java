package com.landofminecraft.mcmmo.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.landofminecraft.mcmmo.MinecraftMMO;
import com.landofminecraft.mcmmo.init.ModBlocks;
import com.landofminecraft.mcmmo.init.ModItems;
import com.landofminecraft.mcmmo.material.ModMaterial;
import com.landofminecraft.mcmmo.material.ModMaterialProperties;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(Side.CLIENT)
@SideOnly(Side.CLIENT)
public class ModWritingUtil {

	@SubscribeEvent
	public static void onRegisterModelsEvent(final ModelRegistryEvent event) {
		writeMod();
	}

	private static final String	ASSET_DIR	= "/Users/" + System.getProperty("user.name") + "/Developer/Modding/MCMMO/src/main/resources/assets/mcmmo/";
	private static final String	DATA_DIR	= "/Users/" + System.getProperty("user.name") + "/Developer/Modding/MCMMO/src/main/resources/data/mcmmo/";

	private static final ResourceLocation	ITEM_GENERATED				= new ResourceLocation("", "item/generated");
	private static final ResourceLocation	item_handheld				= new ResourceLocation("", "item/handheld");
	private static final String				ITEM_DEFAULT_TEXTURE_NAME	= "layer0";

	@SideOnly(Side.CLIENT)
	public static void writeMod() {

		final boolean lang = true;
		final boolean json = true;

		MinecraftMMO.info("ModWritingUtil.writeMod() with options write lang: " + lang + ", write json: " + json);

		if (Boolean.valueOf(false).equals(lang) && Boolean.valueOf(false).equals(json)) {
			MinecraftMMO.info("All arguments are false for writeMod() - Aborting!");
			return;
		}

		if (lang) {
			new Thread(() -> {
				try {
					generateAndWriteLang();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}, "Lang Writer Thread").start();
		}

		if (json) {
			new Thread(() -> {
				for (final ModMaterial material : ModMaterial.values()) {
					try {
						generateAndWriteModels(material);
					} catch (final Exception e) {
						e.printStackTrace();
					}
				}
			}, "JSON Writer Thread").start();
		}

	}

	private static void generateAndWriteModels(final ModMaterial material) {

		final ModMaterialProperties properties = material.getProperties();

		final HashMap<String, String> blockstates = new HashMap<>();
		final HashMap<String, String> blockModels = new HashMap<>();
		final HashMap<String, String> itemModels = new HashMap<>();

		if (properties.hasOre()) {
			final ResourceLocation ore = (material.getOre().getRegistryName());

			if (ore.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = ore.getPath();
				final ResourceLocation model = new ResourceLocation(ModReference.MOD_ID, path);

				blockstates.put(path, generateBlockstateJSON(model));

				final ResourceLocation parent = new ResourceLocation("", "block/cube_all");
				final String textureName = "all";
				final ResourceLocation textureLocation = getTextureLocation(ore, "block");

				blockModels.put(path, generateModelJSON(parent, textureName, textureLocation));
			}
		}

		if (properties.hasBlock()) {
			final ResourceLocation block = (material.getBlock().getRegistryName());

			if (block.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = block.getPath();
				final ResourceLocation model = new ResourceLocation(ModReference.MOD_ID, path);

				blockstates.put(path, generateBlockstateJSON(model));

				final ResourceLocation parent = new ResourceLocation("", "block/cube_all");
				final String textureName = "all";
				final ResourceLocation textureLocation = getTextureLocation(block, "block");

				blockModels.put(path, generateModelJSON(parent, textureName, textureLocation));
			}
		}

		if (properties.hasResource()) {
			final ResourceLocation pickaxe = (material.getResource().getRegistryName());

			if (pickaxe.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = pickaxe.getPath();
				final ResourceLocation textureLocation = getTextureLocation(pickaxe, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));
			}
		}

		if (properties.hasResource() && material.getProperties().hasResourcePiece()) {
			final ResourceLocation pickaxe = (material.getResourcePiece().getRegistryName());

			if (pickaxe.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = pickaxe.getPath();
				final ResourceLocation textureLocation = getTextureLocation(pickaxe, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));
			}
		}

		if (properties.hasHelmet()) {

			final ResourceLocation armor = (material.getHelmet().getRegistryName());

			if (armor.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = armor.getPath();
				final ResourceLocation textureLocation = getTextureLocation(armor, "item");

				itemModels.put(path, generateModelJSON(ITEM_GENERATED, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}
		}

		if (properties.hasChestplate()) {

			final ResourceLocation armor = (material.getChestplate().getRegistryName());

			if (armor.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = armor.getPath();
				final ResourceLocation textureLocation = getTextureLocation(armor, "item");

				itemModels.put(path, generateModelJSON(ITEM_GENERATED, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}

		}

		if (properties.hasLeggings()) {

			final ResourceLocation armor = (material.getLeggings().getRegistryName());

			if (armor.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = armor.getPath();
				final ResourceLocation textureLocation = getTextureLocation(armor, "item");

				itemModels.put(path, generateModelJSON(ITEM_GENERATED, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}

		}

		if (properties.hasBoots()) {
			final ResourceLocation armor = (material.getBoots().getRegistryName());

			if (armor.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = armor.getPath();
				final ResourceLocation textureLocation = getTextureLocation(armor, "item");

				itemModels.put(path, generateModelJSON(ITEM_GENERATED, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}
		}

		if (properties.hasHorseArmor()) {
			final ResourceLocation armor = (material.getHorseArmor().getRegistryName());

			if (armor.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = armor.getPath();
				final ResourceLocation textureLocation = getTextureLocation(armor, "item");

				itemModels.put(path, generateModelJSON(ITEM_GENERATED, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}
		}

		if (properties.hasPickaxe()) {

			final ResourceLocation pickaxe = (material.getPickaxe().getRegistryName());

			if (pickaxe.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = pickaxe.getPath();
				final ResourceLocation textureLocation = getTextureLocation(pickaxe, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));
			}
		}

		if (properties.hasAxe()) {

			final ResourceLocation axe = (material.getAxe().getRegistryName());

			if (axe.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = axe.getPath();
				final ResourceLocation textureLocation = getTextureLocation(axe, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}

		}

		if (properties.hasSword()) {

			final ResourceLocation tool = (material.getSword().getRegistryName());

			if (tool.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = tool.getPath();
				final ResourceLocation textureLocation = getTextureLocation(tool, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}

		}

		if (properties.hasShovel()) {

			final ResourceLocation tool = (material.getShovel().getRegistryName());

			if (tool.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = tool.getPath();
				final ResourceLocation textureLocation = getTextureLocation(tool, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}

		}

		if (properties.hasHoe()) {

			final ResourceLocation tool = material.getHoe().getRegistryName();

			if (tool.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = tool.getPath();
				final ResourceLocation textureLocation = getTextureLocation(tool, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}

		}

		if (properties.hasMace()) {

			final ResourceLocation tool = material.getMace().getRegistryName();

			if (tool.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = tool.getPath();
				final ResourceLocation textureLocation = getTextureLocation(tool, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}

		}

		if (properties.hasHammer()) {

			final ResourceLocation tool = material.getHammer().getRegistryName();

			if (tool.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = tool.getPath();
				final ResourceLocation textureLocation = getTextureLocation(tool, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}

		}

		if (properties.hasWarAxe()) {

			final ResourceLocation tool = material.getWarAxe().getRegistryName();

			if (tool.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = tool.getPath();
				final ResourceLocation textureLocation = getTextureLocation(tool, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}

		}

		if (properties.hasCurvedSword()) {

			final ResourceLocation tool = material.getCurvedSword().getRegistryName();

			if (tool.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = tool.getPath();
				final ResourceLocation textureLocation = getTextureLocation(tool, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}

		}

		if (properties.hasDagger()) {

			final ResourceLocation tool = material.getDagger().getRegistryName();

			if (tool.getNamespace().equals(ModReference.MOD_ID)) {

				final String path = tool.getPath();
				final ResourceLocation textureLocation = getTextureLocation(tool, "item");

				itemModels.put(path, generateModelJSON(item_handheld, ITEM_DEFAULT_TEXTURE_NAME, textureLocation));

			}

		}

		//

		//

		//

		MinecraftMMO.debug("Writing blockstates for " + material);
		blockstates.forEach((name, state) -> {
			final ArrayList data = new ArrayList<>(Arrays.asList(state.split("\n")));
			final Iterator<String> it = data.iterator();
			while (it.hasNext()) {
				if (it.next().equals("")) {
					it.remove();
				}
			}

			final Path file = Paths.get(ASSET_DIR + "blockstates/" + name.toLowerCase() + ".json");
			try {
				MinecraftMMO.info("Writing Blockstate " + name.toLowerCase() + ".json");
				Files.write(file, data, Charset.forName("UTF-8"));
			} catch (final IOException e) {
				e.printStackTrace();
			}

		});

		MinecraftMMO.debug("Writing blockModels for " + material);
		blockModels.forEach((name, model) -> {
			final ArrayList data = new ArrayList<>(Arrays.asList(model.split("\n")));
			final Iterator<String> it = data.iterator();
			while (it.hasNext()) {
				if (it.next().equals("")) {
					it.remove();
				}
			}

			final Path file = Paths.get(ASSET_DIR + "models/block/" + name.toLowerCase() + ".json");
			try {
				MinecraftMMO.info("Writing Block Model " + name.toLowerCase() + ".json");
				Files.write(file, data, Charset.forName("UTF-8"));
			} catch (final IOException e) {
				e.printStackTrace();
			}

		});

		MinecraftMMO.debug("Writing itemModels for " + material);
		itemModels.forEach((name, model) -> {
			final ArrayList data = new ArrayList<>(Arrays.asList(model.split("\n")));
			final Iterator<String> it = data.iterator();
			while (it.hasNext()) {
				if (it.next().equals("")) {
					it.remove();
				}
			}

			final Path file = Paths.get(ASSET_DIR + "models/item/" + name.toLowerCase() + ".json");
			try {
				MinecraftMMO.info("Writing Item Model " + name.toLowerCase() + ".json");
				Files.write(file, data, Charset.forName("UTF-8"));
			} catch (final IOException e) {
				e.printStackTrace();
			}

		});

	}

	private static ResourceLocation getTextureLocation(final ResourceLocation location, final String prepend) {
		final String domain = location.getNamespace();
		final String path = location.getPath();

		final String optionalS = domain.equals("minecraft") && !Loader.MC_VERSION.contains("1.13") ? "s" : "";

		final String texturePath = prepend + optionalS + "/" + path;

		final ResourceLocation textureLocation = new ResourceLocation(domain, texturePath);
		return textureLocation;
	}

	private static void generateAndWriteLang() {
		MinecraftMMO.debug("Initialising lang");

		final HashMap<String, String> lang = new HashMap<>();

		for (final ModMaterial material : ModMaterial.values()) {

			if ((material.getOre() != null) && material.getOre().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getOre().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Ore");
			}

			if ((material.getBlock() != null) && material.getBlock().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getBlock().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Block");
			}

			if ((material.getResource() != null) && material.getResource().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getResource().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + (material.getProperties().getResourceSuffix().length() > 0 ? " " + getTranslatedTranslationKey(material.getProperties().getResourceSuffix()) : ""));
			}

			if ((material.getResourcePiece() != null) && material.getResourcePiece().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getResourcePiece().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + (material.getProperties().getResourcePieceSuffix().length() > 0 ? " " + getTranslatedTranslationKey(material.getProperties().getResourcePieceSuffix()) : ""));
			}

			// armor

			if ((material.getHelmet() != null) && material.getHelmet().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getHelmet().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Helmet");
			}

			if ((material.getChestplate() != null) && material.getChestplate().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getChestplate().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Chestplate");
			}

			if ((material.getLeggings() != null) && material.getLeggings().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getLeggings().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Leggings");
			}

			if ((material.getBoots() != null) && material.getBoots().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getBoots().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Boots");
			}

			if ((material.getHorseArmor() != null) && material.getHorseArmor().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getHorseArmor().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Horse Armor");
			}

			// tools

			if ((material.getAxe() != null) && material.getAxe().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getAxe().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Axe");
			}

			if ((material.getPickaxe() != null) && material.getPickaxe().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getPickaxe().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Pickaxe");
			}

			if ((material.getSword() != null) && material.getSword().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getSword().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Sword");
			}

			if ((material.getShovel() != null) && material.getShovel().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getShovel().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Shovel");
			}

			if ((material.getHoe() != null) && material.getHoe().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getHoe().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Hoe");
			}

			if ((material.getMace() != null) && material.getMace().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getMace().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Mace");
			}

			if ((material.getHammer() != null) && material.getHammer().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getHammer().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Hammer");
			}

			if ((material.getWarAxe() != null) && material.getWarAxe().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getWarAxe().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " War Axe");
			}

			if ((material.getCurvedSword() != null) && material.getCurvedSword().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getCurvedSword().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Curved Sword");
			}

			if ((material.getDagger() != null) && material.getDagger().getRegistryName().getNamespace().equals(ModReference.MOD_ID)) {
				lang.put(material.getDagger().getTranslationKey(), getTranslatedTranslationKey(material.getNameLowercase()) + " Dagger");
			}

			//
		}

		for (final Field field : ModItems.class.getFields()) {
			Object value;
			try {
				value = field.get(ModItems.class);

				if (!(value instanceof Item)) {
					continue;
				}

				final Item item = (Item) value;

				if (item != null) {
					lang.put(item.getTranslationKey(), getTranslatedTranslationKey(item.getRegistryName().getPath()));
				}

			} catch (IllegalArgumentException | IllegalAccessException e) {
				MinecraftMMO.error("fucking hell jeff...");
				e.printStackTrace();
			}
		}

		for (final Field field : ModBlocks.class.getFields()) {
			Object value;
			try {
				value = field.get(ModBlocks.class);

				if (!(value instanceof Block)) {
					continue;
				}

				final Block block = (Block) value;

				if ((block != null) && !block.getRegistryName().getPath().equalsIgnoreCase("napalm") && !block.getRegistryName().getPath().equalsIgnoreCase("peripheral")) {
					lang.put(block.getTranslationKey(), getTranslatedTranslationKey(block.getRegistryName().getPath()));
				}

			} catch (IllegalArgumentException | IllegalAccessException e) {
				MinecraftMMO.error("fucking hell derek...");
				e.printStackTrace();
			}
		}

		final List<String> data = new ArrayList<>();

		lang.forEach((unlocalisedName, localisedName) -> {

			if (Loader.MC_VERSION.contains("1.13")) {
				data.add("	\"" + unlocalisedName + ".name" + "\"" + ": " + "\"" + localisedName + "\"" + ",");
			} else {
				data.add(unlocalisedName + ".name" + "=" + localisedName);
			}

		});

		if (Loader.MC_VERSION.contains("1.13")) {
			String removeComma = data.get(data.size() - 1);
			removeComma = removeComma.substring(0, removeComma.length() - 2);
			data.set(data.size() - 1, removeComma);
		}

		final ArrayList<String> finalData = new ArrayList<>();
		if (Loader.MC_VERSION.contains("1.13")) {
			finalData.add("{");
		}

		if (Loader.MC_VERSION.contains("1.13")) {
			finalData.add("\"itemGroup." + ModReference.MOD_ID + "\"" + ": " + "\"" + ModReference.MOD_NAME + "\"" + ",");
		} else {
			finalData.add("itemGroup." + ModReference.MOD_ID + "=" + ModReference.MOD_NAME);
		}

		finalData.addAll(data);
		if (Loader.MC_VERSION.contains("1.13")) {
			finalData.add("}");
		}

		for (final String langEntry : finalData) {
			MinecraftMMO.info("Lang Entry " + langEntry);
		}

		final Path file = Paths.get(ASSET_DIR + "lang/" + getLangFileName() + "." + (Loader.MC_VERSION.contains("1.13") ? "json" : "lang"));
		MinecraftMMO.debug("Writing lang");
		try {
			Files.write(file, finalData, Charset.forName("UTF-8"));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	private static String getLangFileName() {
		return "en_us";
	}

	private static String getTranslatedTranslationKey(String unlocalised) {
		if (getLangFileName().toLowerCase().equals("en_us")) {
			unlocalised = unlocalised.replace("aluminium", "aluminum");
		}
		return registryNameToTranslationKey(unlocalised);
	}

	public static String registryNameToTranslationKey(final String registryNamePath) {
		final String[] strs = registryNamePath.split("_");
		for (int i = 0; i < strs.length; i++) {
			strs[i] = org.apache.commons.lang3.StringUtils.capitalize(strs[i]);
		}
		final String localisedName = String.join(" ", strs);
		return localisedName;
	}

	private static String generateModelJSON(final ResourceLocation parent, final String textureName, final ResourceLocation textureLocation) {
		String model = "";
		model += "{" + "\n";
		model += "	" + "\"parent\": \"" + parent.toString() + "\"," + "\n";
		model += "	" + "\"textures\": {" + "\n";
		model += "		" + "\"" + textureName + "\": \"" + textureLocation.toString() + "\"" + "\n";
		model += "	" + "}" + "\n";
		model += "}" + "\n";
		return model;
	}

	private static String generateBlockstateJSON(final ResourceLocation model, final EnumFacing... facings) {
		return generateBlockstateJSON(model, false, facings);
	}

	private static String generateBlockstateJSON(final ResourceLocation model, final boolean isNugget, final EnumFacing... facings) {
		String blockstate = "";
		blockstate += "{" + "\n";
		blockstate += "	" + "\"variants\": {" + "\n";
		if (facings.length > 0) {
			for (final EnumFacing facing : facings) {
				if (!Arrays.asList(EnumFacing.HORIZONTALS).contains(facing)) {
					continue;
				}
				blockstate += "		" + "\"facing=" + facing.toString().toLowerCase() + "\": {" + "\n";
				if (isNugget) {
					blockstate += "			" + "\"model\": \"" + model.toString() + "\", \"y\": " + (facing.rotateY().rotateY().rotateY().getHorizontalIndex() * 90) + "\n";
				} else {
					blockstate += "			" + "\"model\": \"" + model.toString() + "\", \"y\": " + (facing.getHorizontalIndex() * 90) + "\n";
				}
				blockstate += "		" + "}," + "\n";
			}
			// remove last comma
			blockstate = StringUtils.reverse(StringUtils.reverse(blockstate).replaceFirst(",", ""));
		} else {
			blockstate += "		" + "\"" + "normal" + "\": {" + "\n";
			blockstate += "			" + "\"model\": \"" + model.toString() + "\"" + "\n";
			blockstate += "		" + "}" + "\n";
		}
		blockstate += "	" + "}" + "\n";
		blockstate += "}" + "\n";

		return blockstate;
	}

	private static String generateBlockstateJSON(final ResourceLocation model) {
		return generateBlockstateJSON(model, new EnumFacing[0]);
	}

}
