package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

/** Mech Puteshestvennika - oskolok vremennogo paradoksa.
 *  Voinspiriruet na priklyucheniya: rsvok po PKM; uron ot padeniya pogloshchaetsya (sm. ModEvents). */
public class TravelerSwordItem extends SwordItem {

    public TravelerSwordItem() {
        super(ItemTier.DIAMOND, 4, -2.4F,
                new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).rarity(Rarity.EPIC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (player.getCooldownTracker().hasCooldown(this)) {
            return ActionResult.resultPass(stack);
        }
        if (!world.isRemote) {
            Vector3d look = player.getLookVec();
            player.setMotion(player.getMotion().add(look.scale(1.2D)).add(0.0D, 0.15D, 0.0D));
            player.fallDistance = 0.0F;
            player.velocityChanged = true;
            world.playSound(null, player.getPosition(), SoundEvents.ENTITY_ENDER_DRAGON_FLAP,
                    SoundCategory.PLAYERS, 0.8F, 1.4F);
            player.getCooldownTracker().setCooldown(this, 60);
        }
        return ActionResult.resultSuccess(stack);
    }
}
