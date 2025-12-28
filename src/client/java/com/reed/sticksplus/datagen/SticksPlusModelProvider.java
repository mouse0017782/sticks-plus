package com.reed.sticksplus.datagen;

import com.reed.sticksplus.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class SticksPlusModelProvider extends FabricModelProvider {
    public SticksPlusModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // No blocks yet 👍
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Stick-like items usually use HANDHELD
        itemModelGenerator.register(ModItems.KB_STICK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ICE_STICK, Models.HANDHELD);
    }
}
