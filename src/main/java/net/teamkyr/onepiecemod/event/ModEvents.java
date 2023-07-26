package net.teamkyr.onepiecemod.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.teamkyr.onepiecemod.OpMod;
import net.teamkyr.onepiecemod.fruitpowers.PlayerPowersProvider;
import net.teamkyr.onepiecemod.item.custom.Devil_Fruit;

@Mod.EventBusSubscriber(modid = OpMod.MOD_ID)
public class ModEvents {
        @SubscribeEvent
        public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
            if(event.getObject() instanceof Player){
                if(!event.getObject().getCapability(PlayerPowersProvider.PLAYER_POWERS).isPresent()){
                    event.addCapability(new ResourceLocation(OpMod.MOD_ID, "properties"), new PlayerPowersProvider());
                }
            }
        }
        
        @SubscribeEvent
        public static void onPlayerCloned(PlayerEvent.Clone event){
            if(event.isWasDeath()){
                event.getOriginal().getCapability(PlayerPowersProvider.PLAYER_POWERS).ifPresent(oldStore ->{
                    event.getOriginal().getCapability(PlayerPowersProvider.PLAYER_POWERS).ifPresent(newStore ->{
                        newStore.copyFrom(oldStore);
                    });
                });
            }
        }

        @SubscribeEvent
        public static void onFruitEaten(LivingEntityUseItemEvent.Finish event){
            if(event.getItem().isEdible()){
                if(event.getItem().getItem() instanceof Devil_Fruit){

                }

            }
        }




}
