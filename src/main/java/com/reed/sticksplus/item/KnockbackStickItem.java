package com.reed.sticksplus.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class KnockbackStickItem extends Item {

    private double knockbackStrength = 15;

    public KnockbackStickItem(Settings settings, double v) {
        super(settings);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        // Server-side only
        if (!attacker.getEntityWorld().isClient()) {

            // Direction away from attacker
            double dx = target.getX() - attacker.getX();
            double dz = target.getZ() - attacker.getZ();

            double mag = Math.sqrt(dx * dx + dz * dz);
            if (mag > 0.0001) {
                dx /= mag;
                dz /= mag;

                // BIG knockback
                target.takeKnockback(knockbackStrength, dx, dz);
            }

            // Damage the item (10 uses total)
            EquipmentSlot slot = attacker.getMainHandStack() == stack
                    ? EquipmentSlot.MAINHAND
                    : EquipmentSlot.OFFHAND;

            stack.damage(1, attacker, slot);
        }


    }
}
