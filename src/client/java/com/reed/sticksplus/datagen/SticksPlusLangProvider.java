package com.reed.sticksplus.datagen;

import com.reed.sticksplus.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SticksPlusLangProvider extends FabricLanguageProvider {

    public SticksPlusLangProvider(
            FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture
    ) {
        super(output, "en_us", registriesFuture);
    }

    @Override
    public void generateTranslations(
            RegistryWrapper.WrapperLookup registries,
            TranslationBuilder builder
    ) {
        builder.add(ModItems.KB_STICK, "Knockback Stick");
        builder.add(ModItems.ICE_STICK, "Ice Stick");
    }
}
