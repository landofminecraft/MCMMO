package com.landofminecraft.mcmmo.util;

/**
 * Holds all enums and enum-related stuff for this mod
 * 
 * @author Cadiboo
 */
public final class ModEnums {

	/**
	 * provides some default methods for formatting enum names
	 * 
	 * @author Cadiboo
	 */
	public interface IEnumNameFormattable {

		/**
		 * Converts the name to lowercase as per {@link java.lang.String#toLowerCase() String.toLowerCase}.
		 */
		default String getNameLowercase() {
			return this.name().toLowerCase();
		}

		/**
		 * Converts the name to uppercase as per {@link java.lang.String#toUpperCase() String.toUpperCase}.
		 */
		default String getNameUppercase() {
			return this.getNameLowercase().toUpperCase();
		}

		/**
		 * Capitalizes the name of the material as per {@link org.apache.commons.lang3.StringUtils#capitalize(String) StringUtils.capitalize}.
		 */
		default String getNameFormatted() {
			return org.apache.commons.lang3.StringUtils.capitalize(this.getNameLowercase());
		}

		/**
		 * very slightly hacky - this method is provided by Enum
		 * 
		 * @return the unformatted name of the enum
		 */
		String name();

	}

}
