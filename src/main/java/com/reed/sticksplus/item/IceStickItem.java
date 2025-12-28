package com.reed.sticksplus.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class IceStickItem extends Item {
    public int fireEveryTicks;

    public IceStickItem(Settings settings, int fireEveryTicks) {
        super(settings);
        this.fireEveryTicks = fireEveryTicks;
    }
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return ActionResult.SUCCESS;
    }
    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (world.isClient()) return;
        if (!(user instanceof PlayerEntity player)) return;
        if (player.age % fireEveryTicks == 0) return;
        SnowballEntity snowball = new SnowballEntity(EntityType.SNOWBALL, world);
        snowball.setOwner(player);
        snowball.setPosition(player.getX(), player.getEyeY() - 0.1, player.getZ());
        snowball.setVelocity(player, player.getPitch(), player.getYaw(), 0.0f, 1.6f, 1.0f);
        player.playSound(SoundEvents.ENTITY_SNOWBALL_THROW, 0.5F, 1.2F);

    }

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }
}

