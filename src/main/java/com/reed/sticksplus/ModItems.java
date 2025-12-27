package com.reed.sticksplus;

import com.reed.sticksplus.item.KnockbackStick;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item KB_STICK;

    public static void register() {
        Identifier id = Identifier.of(SticksPlus.MOD_ID, "kb_stick");

        KB_STICK = Registry.register(
                Registries.ITEM,
                id,
                new KnockbackStick(
                        new Item.Settings()
                                .registryKey(RegistryKey.of(Registries.ITEM.getKey(), id))
                )
        );
    }
}
