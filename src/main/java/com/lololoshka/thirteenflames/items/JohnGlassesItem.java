package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModArmorMaterial;
import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Rarity;

/** Ochki Dzhona (JDH) - oranzhevye ochki. Nadevayutsya na golovu: nochnoe zrenie (sm. ModEvents). */
public class JohnGlassesItem extends ArmorItem {

    public JohnGlassesItem() {
        super(ModArmorMaterial.THIRTEEN, EquipmentSlotType.HEAD,
                new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).maxStackSize(1).rarity(Rarity.UNCOMMON));
    }
}
