package com.lololoshka.thirteenflames;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup extends ItemGroup {
    public static final ItemGroup THIRTEEN_FLAMES = new ModItemGroup();

    private ModItemGroup() {
        super("thirteenflames");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.MASKA_MEZHDUMIRTSA.get());
    }
}
