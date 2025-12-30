package com.reed.sticksplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;

import net.minecraft.recipe.Recipe;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SticksPlusAdvancementProvider extends FabricAdvancementProvider {

    public SticksPlusAdvancementProvider(
            FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup
    ) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> exporter) {
        // Recipe keys (1.21+ rewards API expects RegistryKey<Recipe<?>>)
        RegistryKey<Recipe<?>> KB_STICK = RegistryKey.of(
                RegistryKeys.RECIPE,
                Identifier.of("sticksplus", "kb_stick")
        );
        RegistryKey<Recipe<?>> ICE_STICK = RegistryKey.of(
                RegistryKeys.RECIPE,
                Identifier.of("sticksplus", "ice_stick")
        );

        Advancement.Builder.create()
                // Optional: makes it show in the advancements UI
                .display(
                        Items.STICK,
                        Text.literal("Stick Moment"),
                        Text.literal("Obtain a stick to unlock stick recipes."),
                        null,
                        AdvancementFrame.TASK,
                        true,  // toast
                        false, // announce in chat
                        false  // hidden
                )
                .criterion("got_stick", InventoryChangedCriterion.Conditions.items(Items.STICK))
                .rewards(
                        new AdvancementRewards.Builder()
                                .addRecipe(KB_STICK)
                                .addRecipe(ICE_STICK)
                )
                // This writes: data/sticksplus/advancement/recipes/stick_unlock.json
                .build(exporter, "sticksplus:recipes/stick_unlock");
    }
}
