package com.reed.sticksplus.datagen;

import com.reed.sticksplus.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class SticksPlusModelProvider extends FabricModelProvider {

    public SticksPlusModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        // no blocks yet
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(ModItems.KB_STICK, Models.HANDHELD);
    }
}
