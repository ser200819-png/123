package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShieldItem;

/** Shchit Ronasa - mogushchestvennyj artefakt boga vojny.
 *  Pas'evno: soprotivlenie, poka shchit v levoj ruke (sm. ModEvents). */
public class ShieldOfRonasItem extends ShieldItem {

    public ShieldOfRonasItem() {
        super(new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).maxDamage(504).rarity(Rarity.EPIC));
    }
}
