package com.lololoshka.thirteenflames.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

/** Gorn Seliaseht - daruet vlast' nad vetrami Misra: PKM otnositsya vseh vokrug. */
public class HornOfSeliasetItem extends AbilityItem {

    public HornOfSeliasetItem() {
        super(200, Rarity.RARE);
    }

    @Override
    protected void useAbility(World world, PlayerEntity player) {
        for (Entity entity : world.getEntitiesWithinAABBExcludingEntity(player, player.getBoundingBox().grow(5.0D))) {
            if (entity instanceof LivingEntity) {
                Vector3d away = entity.getPositionVec().subtract(player.getPositionVec());
                away = new Vector3d(away.x, 0.0D, away.z);
                if (away.lengthSquared() < 0.01D) {
                    away = player.getLookVec().scale(-1.0D);
                }
                away = away.normalize().scale(1.8D).add(0.0D, 0.6D, 0.0D);
                entity.setMotion(entity.getMotion().add(away));
                entity.velocityChanged = true;
            }
        }
        world.playSound(null, player.getPosition(), SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.PLAYERS, 1.0F, 0.8F);
    }
}
