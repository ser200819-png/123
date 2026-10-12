package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public abstract class AbilityItem extends Item {
    private final int cooldown;

    public AbilityItem(int cooldown, Rarity rarity) {
        super(new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).maxStackSize(1).rarity(rarity));
        this.cooldown = cooldown;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (player.getCooldownTracker().hasCooldown(this)) {
            return ActionResult.resultPass(stack);
        }
        if (!world.isRemote) {
            useAbility(world, player);
            player.getCooldownTracker().setCooldown(this, cooldown);
        }
        return ActionResult.resultSuccess(stack);
    }

    protected abstract void useAbility(World world, PlayerEntity player);
}
