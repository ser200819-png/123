package com.lololoshka.thirteenflames.items;

import com.lololoshka.thirteenflames.ModItemGroup;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/** Molot Montu - svyashennyj artefakt boga truda. Opustoshaet celye zalezhi rudy za paru vzmahov. */
public class HammerOfMontuItem extends PickaxeItem {

    public HammerOfMontuItem() {
        super(ItemTier.NETHERITE, 2, -3.0F,
                new Item.Properties().group(ModItemGroup.THIRTEEN_FLAMES).rarity(Rarity.EPIC));
    }

    @Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, PlayerEntity player) {
        World world = player.world;
        if (!world.isRemote) {
            // Lomom sosednie rudy razom s cel'yu (oblast' 3x3x3)
            for (BlockPos neighbor : BlockPos.getAllInBoxMutable(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
                BlockState state = world.getBlockState(neighbor);
                if ((state.getBlock() instanceof OreBlock || BlockTags.ORES.contains(state.getBlock()))
                        && !world.isAirBlock(neighbor)) {
                    world.destroyBlock(neighbor, true, player);
                    stack.damageItem(1, player, p -> p.sendBreakAnimation(Hand.MAIN_HAND));
                }
            }
        }
        return false;
    }
}
