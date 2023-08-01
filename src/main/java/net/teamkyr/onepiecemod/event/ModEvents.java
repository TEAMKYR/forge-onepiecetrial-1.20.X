package net.teamkyr.onepiecemod.event;

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
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.teamkyr.onepiecemod.OpMod;
import net.teamkyr.onepiecemod.fruitpowers.PlayerPowers;
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

    private static final int FRUIT_KILL_AMOUNT = 2;
    @SubscribeEvent
    public static void onFruitEaten(LivingEntityUseItemEvent.Finish event){
        if(event.getEntity().level().isClientSide) return;

        if(event.getItem().isEdible()){
            if(event.getItem().getItem() instanceof Devil_Fruit devilFruit && event.getEntity() instanceof Player player){
                ServerLevel serverLevel = (ServerLevel) event.getEntity().level();
                LazyOptional<PlayerPowers> playerPowers = serverLevel.getCapability(PlayerPowersProvider.PLAYER_POWERS);
                playerPowers.ifPresent(cap -> {
                    cap.fruitAdd();
                    if(cap.getFruits() > FRUIT_KILL_AMOUNT){
                        serverLevel.explode((Entity)null, serverLevel.damageSources().badRespawnPointExplosion(player.position()), (ExplosionDamageCalculator)null, (double)player.getX() + 0.5D, (double)player.getY() + 0.5D, (double)player.getZ() + 0.5D, 5.0F, true, Level.ExplosionInteraction.MOB);
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
            LazyOptional<PlayerPowers> playerPowers = serverLevel.getCapability(PlayerPowersProvider.PLAYER_POWERS);
            playerPowers.ifPresent(cap -> {
                cap.fruitReset();
            });
        }
    }

    @SubscribeEvent
    public static  void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(PlayerPowers.class);
    }




}
