package com.lololoshka.thirteenflames;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ThirteenFlames.MODID)
public class ModEvents {

    private static final int DURATION = 220; // 11 sekund, obnovlyaetsya kazhdyj tik

    private static boolean hasItem(PlayerEntity player, Item item) {
        return player.inventory.mainInventory.stream().anyMatch(s -> s.getItem() == item)
                || player.inventory.armorInventory.stream().anyMatch(s -> s.getItem() == item)
                || player.inventory.offHandInventory.stream().anyMatch(s -> s.getItem() == item);
    }

    private static void grant(LivingEntity entity, Effect effect) {
        entity.addPotionEffect(new EffectInstance(effect, DURATION, 0, true, false));
    }

    /** Passivnye sposobnosti predmetov v inventare i nadetyh. */
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player == null || event.player.world.isRemote) return;
        PlayerEntity player = event.player;

        // Solnce Seliaseht - neset svet, razgonyaet t'mu
        if (hasItem(player, ModItems.SOLNTSE_SELIASET.get())) {
            grant(player, Effects.NIGHT_VISION);
        }
        // Pero Hetintepe - shag pervoprohodca
        if (hasItem(player, ModItems.PERO_HETINTEPA.get())) {
            grant(player, Effects.SLOW_FALLING);
        }
        // Znachok Dzhona - udacha iskatelya mirov
        if (hasItem(player, ModItems.ZNACHOK_JOHNA.get())) {
            grant(player, Effects.LUCK);
        }
        // Perchatki Montu - bog trudolyubiya uskoryaet rabotu
        if (player.getHeldItemMainhand().getItem() == ModItems.PERCHATKI_MONTU.get()
                || player.getHeldItemOffhand().getItem() == ModItems.PERCHATKI_MONTU.get()) {
            player.addPotionEffect(new EffectInstance(Effects.HASTE, DURATION, 1, true, false));
        }
        // Shchit Ronasa - sila boga vojny
        if (player.getHeldItemOffhand().getItem() == ModItems.SHCHIT_RONASA.get()) {
            player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, DURATION, 0, true, false));
        }

        // Atributika v slotah broni
        Item head = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem();
        if (head == ModItems.MASKA_LOLOLOSHKI.get()) {
            grant(player, Effects.SPEED);
        }
        if (head == ModItems.OCHKI_JOHNA.get()) {
            grant(player, Effects.NIGHT_VISION);
        }
        if (head == ModItems.MASKA_MEZHDUMIRTSA.get()) {
            grant(player, Effects.FIRE_RESISTANCE);
        }
        Item chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem();
        if (chest == ModItems.SHARF_JOHNA.get()) {
            grant(player, Effects.FIRE_RESISTANCE);
        }
    }

    /** Lunnyj Luk Knefmtiti - nasylyaet molnii na zhertv. */
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        if (!(source.getDirectEntity() instanceof AbstractArrowEntity)) return;
        if (!(source.getTrueSource() instanceof PlayerEntity)) return;
        PlayerEntity shooter = (PlayerEntity) source.getTrueSource();
        World world = shooter.world;
        if (world.isRemote) return;
        if (shooter.getHeldItemMainhand().getItem() != ModItems.LUK_KNEFMTITI.get()
                && shooter.getHeldItemOffhand().getItem() != ModItems.LUK_KNEFMTITI.get()) return;

        LivingEntity target = event.getEntityLiving();
        LightningBoltEntity bolt = EntityType.LIGHTNING_BOLT.create(world);
        if (bolt != null) {
            bolt.refreshDimensions();
            bolt.setPosition(target.getPosX(), target.getPosY(), target.getPosZ());
            world.addEntity(bolt);
            target.onStruckByLightning(bolt);
        }
    }

    /** Mech Puteshestvennika pogloshchaet uron ot padeniya. */
    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if (!player.world.isRemote && hasItem(player, ModItems.MECH_PUTESHESTVENNIKA.get())) {
                event.setCanceled(true);
            }
        }
    }
}
