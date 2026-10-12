package com.lololoshka.thirteenflames;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    THIRTEEN("thirteen", 14, new int[]{2, 4, 3, 1}, 12,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 0.05F, () -> Ingredient.fromItems(Items.GOLD_INGOT));

    private final String name;
    private final int durability;
    private final int[] protection;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairMaterial;

    ModArmorMaterial(String name, int durability, int[] protection, int enchantability,
                     SoundEvent equipSound, float toughness, float knockbackResistance,
                     Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.durability = durability;
        this.protection = protection;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slot) {
        return this.durability * (slot == EquipmentSlotType.HEAD ? 11 : slot == EquipmentSlotType.CHEST ? 16 : 13);
    }

    @Override
    public int getDamageReductionAmountForSlot(EquipmentSlotType slot) {
        return this.protection[slot.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.equipSound;
    }

    @Override
    public Supplier<Ingredient> getRepairMaterial() {
        return this.repairMaterial;
    }

    @Override
    public String getName() {
        return ThirteenFlames.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
