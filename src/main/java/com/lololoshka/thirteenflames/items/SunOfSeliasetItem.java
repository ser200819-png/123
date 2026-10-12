package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

/** Solnce Seliaseht - daruet silu nesti svet i razgonyat t'mu. Pas'sivno: nochnoe zrenie v inventare (sm. ModEvents). */
public class SunOfSeliasetItem extends Item {

    public SunOfSeliasetItem() {
        super(new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).maxStackSize(1).rarity(Rarity.RARE));
    }
}
