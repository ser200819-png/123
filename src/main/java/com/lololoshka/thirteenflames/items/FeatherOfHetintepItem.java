package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

/** Pero Hetintepe - artefakt boga znanij. Pas'sivno: medlennoe padenie v inventare (sm. ModEvents). */
public class FeatherOfHetintepItem extends Item {

    public FeatherOfHetintepItem() {
        super(new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).maxStackSize(1).rarity(Rarity.RARE));
    }
}
