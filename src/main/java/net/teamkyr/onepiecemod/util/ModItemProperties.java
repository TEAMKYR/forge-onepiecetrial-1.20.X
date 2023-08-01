package net.teamkyr.onepiecemod.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.teamkyr.onepiecemod.item.ModItems;

public class ModItemProperties extends ItemProperties {
    public static void addCustomItemProperties(){
        makeCard(ModItems.VIVRE_CARD.get());
    }
    private static void makeCard(Item item) {
        ItemProperties.register(item, new ResourceLocation("tracking"), (p_272332_, p_272333_, p_272334_, p_272335_) -> {
            Float hp = 1F;
            if(p_272332_.hasTag()){
                ServerLevel serverLevel = (ServerLevel) p_272334_.level();
                Entity e =(serverLevel.getEntity(p_272332_.getTag().getUUID("onepiecemod.attatchedentity")));
                LivingEntity E = (LivingEntity)e;
                hp = E.getHealth()/E.getMaxHealth();
            }
            return hp;
        });
        register(item, new ResourceLocation("damaged"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
            Float hp = 1F;
            if(p_174630_.hasTag()){
                ServerLevel serverLevel = (ServerLevel)p_174632_.level();
                Entity e =(serverLevel.getEntity(item.getDefaultInstance().getTag().getUUID("onepiecemod.attatchedentity")));
                LivingEntity E = (LivingEntity)e;
                hp = E.getHealth()/E.getMaxHealth();
            }
            if(hp == 1F){
                return 0F;
            }
            else{
                return 1F;
            }
        });
    }

}
