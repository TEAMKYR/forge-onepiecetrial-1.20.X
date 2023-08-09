package net.teamkyr.onepiecemod.event;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.teamkyr.onepiecemod.OpMod;
import net.teamkyr.onepiecemod.fruitpowers.PlayerPowers;
import net.teamkyr.onepiecemod.fruitpowers.PlayerPowersProvider;
import net.teamkyr.onepiecemod.haki.PlayerHaki;
import net.teamkyr.onepiecemod.haki.PlayerHakiProvider;
import net.teamkyr.onepiecemod.item.custom.Devil_Fruit;

@Mod.EventBusSubscriber(modid = OpMod.MOD_ID)
public class ModEvents {
        @SubscribeEvent
        public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
            if(event.getObject() instanceof Player){
                if(!event.getObject().getCapability(PlayerPowersProvider.PLAYER_POWERS).isPresent()){
                    event.addCapability(new ResourceLocation(OpMod.MOD_ID, "powers"), new PlayerPowersProvider());
                }
                if(!event.getObject().getCapability(PlayerHakiProvider.PLAYER_HAKI).isPresent()){
                    event.addCapability(new ResourceLocation(OpMod.MOD_ID, "haki"), new PlayerHakiProvider());
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
                event.getOriginal().getCapability(PlayerHakiProvider.PLAYER_HAKI).ifPresent(oldStore ->{
                    event.getOriginal().getCapability(PlayerHakiProvider.PLAYER_HAKI).ifPresent(newStore ->{
                        newStore.copyFrom(oldStore);
                    });
                });
            }
        }

    private static final int FRUIT_KILL_AMOUNT = 1;
    @SubscribeEvent
    public static void onFruitEaten(LivingEntityUseItemEvent.Finish event){
        if(event.getEntity().level().isClientSide) return;

        if(event.getItem().isEdible()){
            if(event.getItem().getItem() instanceof Devil_Fruit devilFruit && event.getEntity() instanceof Player player){
                ServerLevel serverLevel = (ServerLevel) event.getEntity().level();
                LazyOptional<PlayerPowers> playerPowers = player.getCapability(PlayerPowersProvider.PLAYER_POWERS);
                playerPowers.ifPresent(cap -> {
                    cap.fruitAdd();
                    if(cap.getFruits() > FRUIT_KILL_AMOUNT){
                        serverLevel.explode((Entity)null, serverLevel.damageSources().badRespawnPointExplosion(player.position()), (ExplosionDamageCalculator)null, (double)player.getX() + 0.5D, (double)player.getY() + 0.5D, (double)player.getZ() + 0.5D, 30.0F, true, Level.ExplosionInteraction.MOB);
                        player.hurt(player.damageSources().badRespawnPointExplosion(player.position()), Float.MAX_VALUE);
                    }
                });
            }

        }
    }
    @SubscribeEvent
    public static void onKilled(LivingDeathEvent event) {
        if (event.getEntity().level().isClientSide) return;
        if (event.getEntity() instanceof Player player) {
            ServerLevel serverLevel = (ServerLevel) event.getEntity().level();
            LazyOptional<PlayerPowers> playerPowers = player.getCapability(PlayerPowersProvider.PLAYER_POWERS);
            playerPowers.ifPresent(cap -> {
                cap.fruitReset();
            });
        }
    }

    @SubscribeEvent
    public static void onExpGain(PlayerXpEvent.PickupXp event){
    Player player = event.getEntity();
    LazyOptional<PlayerHaki> playerHaki = player.getCapability(PlayerHakiProvider.PLAYER_HAKI);
        playerHaki.ifPresent(cap -> {
            if(cap.getAchosen()){
                for(int i = 0; i <= event.getOrb().getValue(); i++){
                    cap.AHakiAdd();
                    if(cap.getAHaki() == cap.getAHNeededForNextLevel()){
                        cap.Ahakileveladd();
                        cap.AHakiReset();
                        player.sendSystemMessage(Component.literal(""+cap.getAhakilevel()));
                    }
                }
            }
            else{
                for(int i = 0; i <= event.getOrb().getValue(); i++){
                    cap.OHakiAdd();
                    if(cap.getOHaki() == cap.getOHNeededForNextLevel()){
                        cap.Ohakileveladd();
                        cap.OHakiReset();
                        player.sendSystemMessage(Component.literal(""+cap.getOhakilevel()));
                    }
                }
            }
        });
    }

    @SubscribeEvent
    public static  void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(PlayerPowers.class);
        event.register(PlayerHaki.class);
    }




}
