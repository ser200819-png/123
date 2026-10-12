package com.lololoshka.thirteenflames.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/** Chernaya Roza Knefmtiti - daruet vlast' nad pavshimi: prizyvaet soyuznogo zhivogo mertvca. */
public class BlackRoseItem extends AbilityItem {

    public BlackRoseItem() {
        super(600, Rarity.EPIC);
    }

    @Override
    protected void useAbility(World world, PlayerEntity player) {
        if (!(world instanceof ServerWorld)) return;
        ZombieEntity risen = new ZombieEntity(EntityType.ZOMBIE, world);
        risen.setPosition(player.getPosX() + 2.0D, player.getPosY(), player.getPosZ());
        risen.setCustomName(new StringTextComponent("Pavshij"));
        risen.setCustomNameVisible(false);
        risen.enablePersistence();
        risen.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(risen, MonsterEntity.class, false));
        ((ServerWorld) world).addEntity(risen);
        world.playSound(null, player.getPosition(), SoundEvents.ENTITY_ZOMBIE_AMBIENT, SoundCategory.PLAYERS, 1.0F, 0.6F);
    }
}
