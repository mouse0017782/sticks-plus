package com.reed.sticksplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class SticksPlusAdvancementProvider extends FabricAdvancementProvider {

    public SticksPlusAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registries, Consumer<AdvancementEntry> consumer) {
        Advancement.Builder.create()
                .criteriaMerger(Advancement.CriterionMerger.OR)
                .criterion("got_stick", InventoryChangedCriterion.Conditions.items(Items.STICK))
                .rewards(
                        AdvancementRewards.Builder
                                .recipe(registries, Identifier.of("sticksplus", "kb_stick"))
                                .addRecipe(registries, Identifier.of("sticksplus", "ice_stick"))
                )
                .build(consumer, "sticksplus:unlock_sticksplus_recipes");
    }
}
