package com.lololoshka.thirteenflames;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ThirteenFlames.MODID)
public class ThirteenFlames {
    public static final String MODID = "thirteenflames";

    public ThirteenFlames() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(modBus);
        MinecraftForge.EVENT_BUS.register(ModEvents.class);
    }
}
