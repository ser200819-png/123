package com.lololoshka.thirteenflames.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Rarity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/** Posoh Dzhodaha - artefakt pervogo Boga-Faraona Misra. PKM - peremeschenie v smotrjaschej storone. */
public class StaffOfJodahItem extends AbilityItem {

    public StaffOfJodahItem() {
        super(100, Rarity.EPIC);
    }

    @Override
    protected void useAbility(World world, PlayerEntity player) {
        if (!(world instanceof ServerWorld)) return;
        ServerWorld serverWorld = (ServerWorld) world;

        serverWorld.spawnParticle(ParticleTypes.PORTAL, player.getPosX(), player.getPosY() + 1.0D, player.getPosZ(),
                30, 0.4D, 0.8D, 0.4D, 0.02D);

        RayTraceResult ray = player.pick(12.0D, 1.0F, false);
        double tx = player.getPosX() + player.getLookVec().x * 12.0D;
        double ty = player.getPosY() + player.getLookVec().y * 12.0D;
        double tz = player.getPosZ() + player.getLookVec().z * 12.0D;
        if (ray.getType() == RayTraceResult.Type.BLOCK) {
            BlockRayTraceResult blockRay = (BlockRayTraceResult) ray;
            BlockPos pos = blockRay.getPos().offset(blockRay.getFace());
            tx = pos.getX() + 0.5D;
            ty = pos.getY();
            tz = pos.getZ() + 0.5D;
        }

        player.setPositionAndUpdate(tx, ty, tz);
        player.fallDistance = 0.0F;
        serverWorld.spawnParticle(ParticleTypes.PORTAL, tx, ty + 1.0D, tz, 30, 0.4D, 0.8D, 0.4D, 0.02D);
        world.playSound(null, player.getPosition(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT,
                SoundCategory.PLAYERS, 1.0F, 1.0F);
    }
}
