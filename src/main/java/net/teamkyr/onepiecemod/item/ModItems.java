package net.teamkyr.onepiecemod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.teamkyr.onepiecemod.OpMod;
import net.teamkyr.onepiecemod.item.custom.VIVRE_CARDITEM;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OpMod.MOD_ID);

    public static final RegistryObject<Item> VIVRE_CARD = ITEMS.register("vivre_card",
            ()-> new VIVRE_CARDITEM(new Item.Properties().fireResistant().stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}