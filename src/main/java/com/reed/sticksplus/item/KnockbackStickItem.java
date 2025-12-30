package com.reed.sticksplus.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class KnockbackStickItem extends Item {

    private final double knockbackStrength;

    public KnockbackStickItem(Settings settings, double knockbackStrength) {
        super(settings);
        this.knockbackStrength = knockbackStrength;
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Server-side only
        if (!attacker.getEntityWorld().isClient()) {
            // Direction from attacker to target
            double dx = target.getX() - attacker.getX();
            double dz = target.getZ() - attacker.getZ();

            double mag = Math.sqrt(dx * dx + dz * dz);
            if (mag > 0.0001) {
                dx /= mag;
                dz /= mag;

                // Push target away from attacker
                target.takeKnockback(knockbackStrength, -dx, -dz);
            }


            // Damage item by 1
            EquipmentSlot slot = attacker.getMainHandStack() == stack
                    ? EquipmentSlot.MAINHAND
                    : EquipmentSlot.OFFHAND;

            // 1.21.x-safe overload
            stack.damage(1, attacker, slot);
        }

    }
}
