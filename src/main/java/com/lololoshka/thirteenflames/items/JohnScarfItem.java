package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModArmorMaterial;
import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Rarity;

/** Sharf Dzhona (JDH) - oranzhevyj sharf. Nadevayetsya na telo: ogneustojchivost' (sm. ModEvents). */
public class JohnScarfItem extends ArmorItem {

    public JohnScarfItem() {
        super(ModArmorMaterial.THIRTEEN, EquipmentSlotType.CHEST,
                new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).maxStackSize(1).rarity(Rarity.UNCOMMON));
    }
}
