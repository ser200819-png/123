package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModArmorMaterial;
import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/** Maska Mezhdumirca - poslednij iz Ognjej, aktivator Otpravleniya.
 *  PKM s Shift - Otpravlenie k tochke spawnа; nadevayetsya na golovu, poka nadeta - ogneustojchivost'. */
public class InterworldMaskItem extends ArmorItem {

    public InterworldMaskItem() {
        super(ModArmorMaterial.THIRTEEN, EquipmentSlotType.HEAD,
                new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).maxStackSize(1).rarity(Rarity.EPIC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (player.isSneaking()) {
            if (!world.isRemote && !player.getCooldownTracker().hasCooldown(this)) {
                BlockPos spawn = world.getSpawnPoint();
                if (world instanceof ServerWorld) {
                    ((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, player.getPosX(),
                            player.getPosY() + 1.0D, player.getPosZ(), 40, 0.5D, 1.0D, 0.5D, 0.02D);
                }
                player.setPositionAndUpdate(spawn.getX() + 0.5D, spawn.getY() + 1.0D, spawn.getZ() + 0.5D);
                player.getCooldownTracker().setCooldown(this, 600);
                world.playSound(null, player.getPosition(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT,
                        SoundCategory.PLAYERS, 1.0F, 1.0F);
            }
            return ActionResult.resultSuccess(stack);
        }
        return super.onItemRightClick(world, player, hand);
    }
}
