package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

/** Znachok Dzhona (JDH). Pas'sivno: udacha, poka lezhit v inventare (sm. ModEvents). */
public class JohnPinItem extends Item {

    public JohnPinItem() {
        super(new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).rarity(Rarity.UNCOMMON));
    }
}
