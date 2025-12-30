package com.reed.sticksplus;

import com.reed.sticksplus.item.IceStickItem;
import com.reed.sticksplus.item.KnockbackStickItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item KB_STICK;
    public static Item ICE_STICK;

    public static void register() {
        // kb_stick
        RegistryKey<Item> kbKey = RegistryKey.of(
                RegistryKeys.ITEM,
                Identifier.of(SticksPlus.MOD_ID, "kb_stick")
        );

        Item.Settings kbSettings = new Item.Settings()
                .registryKey(kbKey)       // ✅ THIS prevents "Item id not set"
                .maxDamage(10);

        KB_STICK = Registry.register(
                Registries.ITEM,
                kbKey.getValue(),          // same id as the key
                new KnockbackStickItem(kbSettings, 10)
        );

        // ice_stick
        RegistryKey<Item> iceKey = RegistryKey.of(
                RegistryKeys.ITEM,
                Identifier.of(SticksPlus.MOD_ID, "ice_stick")
        );

        Item.Settings iceSettings = new Item.Settings()
                .registryKey(iceKey)      // ✅
                .maxCount(1);

        ICE_STICK = Registry.register(
                Registries.ITEM,
                iceKey.getValue(),
                new IceStickItem(iceSettings, 1)
        );
    }
}
