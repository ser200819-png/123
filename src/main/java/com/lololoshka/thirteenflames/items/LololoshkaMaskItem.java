package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModArmorMaterial;
import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Rarity;

/** Maska Lololoshki (fan-atributika). Nadevayetsya na golovu: skorost' (sm. ModEvents). */
public class LololoshkaMaskItem extends ArmorItem {

    public LololoshkaMaskItem() {
        super(ModArmorMaterial.THIRTEEN, EquipmentSlotType.HEAD,
                new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).maxStackSize(1).rarity(Rarity.UNCOMMON));
    }
}
