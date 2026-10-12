package com.lololoshka.thirteenflames;

import com.lololoshka.thirteenflames.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ThirteenFlames.MODID);

    // ===== Trinadcat Ognej (the Thirteen Flames) =====
    public static final RegistryObject<Item> MOLOT_MONTU = ITEMS.register("molot_montu", HammerOfMontuItem::new);
    public static final RegistryObject<Item> PERCHATKI_MONTU = ITEMS.register("perchatki_montu", GlovesOfMontuItem::new);
    public static final RegistryObject<Item> KLYK_RONASA = ITEMS.register("klyk_ronasa", FangOfRonasItem::new);
    public static final RegistryObject<Item> SHCHIT_RONASA = ITEMS.register("shchit_ronasa", ShieldOfRonasItem::new);
    public static final RegistryObject<Item> LUK_KNEFMTITI = ITEMS.register("luk_knefmtiti", BowOfKnefmtitiItem::new);
    public static final RegistryObject<Item> CHERNAYA_ROZA = ITEMS.register("chernaya_roza", BlackRoseItem::new);
    public static final RegistryObject<Item> GORN_SELIASET = ITEMS.register("gorn_seliaset", HornOfSeliasetItem::new);
    public static final RegistryObject<Item> SOLNTSE_SELIASET = ITEMS.register("solntse_seliaset", SunOfSeliasetItem::new);
    public static final RegistryObject<Item> PERO_HETINTEPA = ITEMS.register("pero_hetintepa", FeatherOfHetintepItem::new);
    public static final RegistryObject<Item> SVITOK_PRAVDY = ITEMS.register("svitok_pravdy", ScrollOfTruthItem::new);
    public static final RegistryObject<Item> MECH_PUTESHESTVENNIKA = ITEMS.register("mech_puteshestvennika", TravelerSwordItem::new);
    public static final RegistryObject<Item> POSOH_DZHODAHA = ITEMS.register("posoh_dzhodaha", StaffOfJodahItem::new);
    public static final RegistryObject<Item> MASKA_MEZHDUMIRTSA = ITEMS.register("maska_mezhdumirtsa", InterworldMaskItem::new);

    // ===== Atributika (merch items) =====
    public static final RegistryObject<Item> MASKA_LOLOLOSHKI = ITEMS.register("maska_lololoshki", LololoshkaMaskItem::new);
    public static final RegistryObject<Item> SHARF_JOHNA = ITEMS.register("sharf_johna", JohnScarfItem::new);
    public static final RegistryObject<Item> OCHKI_JOHNA = ITEMS.register("ochki_johna", JohnGlassesItem::new);
    public static final RegistryObject<Item> ZNACHOK_JOHNA = ITEMS.register("znachok_johna", JohnPinItem::new);
}
