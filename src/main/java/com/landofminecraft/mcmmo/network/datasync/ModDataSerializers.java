package com.landofminecraft.mcmmo.network.datasync;

import java.io.IOException;

import com.landofminecraft.mcmmo.material.ModMaterial;

import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;

public class ModDataSerializers {

	public static final DataSerializer<ModMaterial> MATERIAL = new DataSerializer<ModMaterial>() {
		@Override
		public void write(final PacketBuffer buf, final ModMaterial value) {
			buf.writeEnumValue(value);
		}

		@Override
		public ModMaterial read(final PacketBuffer buf) throws IOException {
			return buf.readEnumValue(ModMaterial.class);
		}

		@Override
		public DataParameter<ModMaterial> createKey(final int id) {
			return new DataParameter<>(id, this);
		}

		@Override
		public ModMaterial copyValue(final ModMaterial value) {
			return value;
		}
	};

	public static void registerSerializer(final DataSerializer<?> serializer) {
		DataSerializers.registerSerializer(serializer);
	}

	static {
		registerSerializer(MATERIAL);
	}

}
