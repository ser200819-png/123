package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.item.BowItem;
import net.minecraft.item.Rarity;

/** Lunnyj Luk Knefmtiti - boginya smerti nasyala lyudej molniiami. Strela iz luka prizyvaet molniu (sm. ModEvents). */
public class BowOfKnefmtitiItem extends BowItem {

    public BowOfKnefmtitiItem() {
        super(new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).maxDamage(768).rarity(Rarity.EPIC));
    }
}
