package com.reed.sticksplus.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class IceStickItem extends Item {
    private final int cooldownTicks; // set to 0 for no cooldown

    public IceStickItem(Settings settings, int cooldownTicks) {
        super(settings);
        this.cooldownTicks = cooldownTicks;
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (world.isClient()) return ActionResult.SUCCESS;

        // optional cooldown so you don't become a snowball minigun
        if (cooldownTicks > 0 && player.getItemCooldownManager().isCoolingDown(stack)) {
            return ActionResult.SUCCESS;
        }

        SnowballEntity snowball = new SnowballEntity(EntityType.SNOWBALL, world);
        snowball.setOwner(player);
        snowball.setPosition(player.getX(), player.getEyeY() - 0.1, player.getZ());
        snowball.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, 1.6f, 1.0f);

        world.spawnEntity(snowball);
        player.playSound(SoundEvents.ENTITY_SNOWBALL_THROW, 0.5F, 1.2F);

        if (cooldownTicks > 0) {
            player.getItemCooldownManager().set(stack, cooldownTicks);
        }

        return ActionResult.SUCCESS;
    }
}
