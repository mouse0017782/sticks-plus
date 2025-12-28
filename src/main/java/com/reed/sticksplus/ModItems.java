package com.reed.sticksplus;

import com.reed.sticksplus.item.IceStickItem;
import com.reed.sticksplus.item.KnockbackStickItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // The item instance (registered once in register())
    public static Item KB_STICK;
    public static Item ICE_STICK;
    public static void register() {
        KB_STICK = Registry.register(
                Registries.ITEM,
                Identifier.of(SticksPlus.MOD_ID, "kb_stick"),
                new KnockbackStickItem(
                        new Item.Settings().maxDamage(10), // 10 hits then breaks
                        10 // BIG knockback strength (try 2.0–3.5)
                )
        );
        ICE_STICK = Registry.register(
                Registries.ITEM,
                Identifier.of(SticksPlus.MOD_ID, "ice_stick"),
                new IceStickItem(new Item.Settings().maxCount(1), 1));
    }
}
