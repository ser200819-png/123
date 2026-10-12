package com.lololoshka.thirteenflames.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/** Svitok pravdy Hetintepe - daruet vlast' nad pravdoj: vse sushchestva vokrug svetyatsya. */
public class ScrollOfTruthItem extends AbilityItem {

    public ScrollOfTruthItem() {
        super(300, Rarity.RARE);
    }

    @Override
    protected void useAbility(World world, PlayerEntity player) {
        if (!(world instanceof ServerWorld)) return;
        for (LivingEntity entity : world.getEntitiesWithinAABB(LivingEntity.class, player.getBoundingBox().grow(16.0D))) {
            if (entity != player) {
                entity.addPotionEffect(new EffectInstance(Effects.GLOWING, 400, 0));
            }
        }
        world.playSound(null, player.getPosition(), net.minecraft.util.SoundEvents.ENTITY_EVOKER_AMBIENT,
                net.minecraft.util.SoundCategory.PLAYERS, 1.0F, 1.2F);
    }
}
