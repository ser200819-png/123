package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

/** Perchatki Montu - povyshayut effektivnost' truda. Passevno: Speshlenie II, esli derzhat' v ruke (sm. ModEvents). */
public class GlovesOfMontuItem extends Item {

    public GlovesOfMontuItem() {
        super(new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).maxStackSize(1).rarity(Rarity.RARE));
    }
}
