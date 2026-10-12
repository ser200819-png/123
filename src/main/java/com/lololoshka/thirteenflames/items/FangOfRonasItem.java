package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

/** Klyk Ronasa - klink boga vojny, iz kotorogo postoyanno vytekaet moshchnyj yad.
 *  Vladelec obrechen na vechnuyu anemiyu (slabost'), zhertva otravlyayetsya. */
public class FangOfRonasItem extends SwordItem {

    public FangOfRonasItem() {
        super(ItemTier.NETHERITE, 4, -2.6F,
                new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).rarity(Rarity.EPIC));
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addPotionEffect(new EffectInstance(Effects.POISON, 160, 1));
        if (attacker instanceof PlayerEntity) {
            // anemiya - cena vladeniya klinkom
            ((PlayerEntity) attacker).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200, 0));
        }
        return super.hitEntity(stack, target, attacker);
    }
}
