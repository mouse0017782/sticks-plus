package com.reed.sticksplus;

import net.fabricmc.api.ModInitializer;

public class SticksPlus implements ModInitializer {

	public static final String MOD_ID = "sticksplus";

	@Override
	public void onInitialize() {
		ModItems.register(); // ← REQUIRED
		System.out.println("Sticks Plus loaded!");
	}
}