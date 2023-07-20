package net.teamkyr.onepiecemod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.teamkyr.onepiecemod.OpMod;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OpMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OP_TAB = CREATIVE_MODE_TABS.register("one_piece_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.VIVRE_CARD.get()))
                    .title(Component.translatable("creativetab.one_piece_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.VIVRE_CARD.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("testing_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(Items.ANVIL))
                    .title(Component.translatable("creativetab.testing_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.VIVRE_CARD.get());
                        pOutput.accept(Items.ANVIL);
                        pOutput.accept(Items.NAME_TAG);
                        pOutput.accept(Items.POLAR_BEAR_SPAWN_EGG);
                        pOutput.accept(Items.ENDER_EYE);
                        pOutput.accept(Items.PAPER);
                    })
                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
