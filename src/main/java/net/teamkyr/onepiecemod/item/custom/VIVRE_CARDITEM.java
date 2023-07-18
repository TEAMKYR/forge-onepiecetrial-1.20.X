package net.teamkyr.onepiecemod.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

/*
How I want it to work:
 Starts as an unattatched Vivre_Card
 When !attatched, Vivre_Card has no use
 To attatch: Interact with living named entity while Vivre_Card is in main hand (this entity is known as attatchedentity)
 Once attatched, the Vivre_Card's title will change from Vivre Card to attatchedentity.getCustomName()+"'s Vivre Card"
                 the Vivre Card loses the ability to attatch to entities and is perma attatched to attatchedentity
                 it gains its use function
                 Texture changes based on attatchedentity.getHealth()/attatchedentity.getMaxHealth()
 Attatched Vivre_Card use:
                            "Ender Eyes" over to the location of attatchedentity
A named entity should be able to have multiple Vivre Cards attatched to it, but a Vivre Card can only attatch to one entity
___________________________________________________________________________________________________________________________________
Current Issues with implementation:
when interacting with a named entity, the vivre card's hover name doesn't change
after having one vivre card interact with an entity grabbing a new vivre card from creative inventory and interacting with the any entity does not display the confirmation message

Use not implemented
Texture Change not implemented

 */
public class VIVRE_CARDITEM extends Item {
    public VIVRE_CARDITEM(Properties properties) {
        super(properties);
    }

    @Override
    //"Eye of Ender"s over to the entity to which the item is "attatched" to; can only be used if attatched = true | not implemented
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND && player.getItemInHand(hand).hasTag()) {
            String output = findEntityCoords(player.getItemInHand(hand), level)[0]+
                    ", "+findEntityCoords(player.getItemInHand(hand), level)[1]+
                    ", "+
                    findEntityCoords(player.getItemInHand(hand), level)[2];
            player.sendSystemMessage(Component.literal(output));
        }
        return super.use(level, player, hand);
    }

    public double[] findEntityCoords(ItemStack stack, @Nullable Level level){
        double[] coords = new double[3];
        if (stack.hasTag()) {
                Entity e = ((ServerLevel)level).getEntity(stack.getTag().getUUID("onepiecemod.attatchedentity"));
                LivingEntity E = (LivingEntity) e;
                coords = new double[]{E.getX(), E.getY(), E.getZ()};
            }
        return coords;
    }

    //When used on a named entity, it "attatches" to them, so when used again it will "Eye of Ender" towards their location
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (entity.hasCustomName() && (!stack.hasTag() || !stack.getTag().getBoolean("onepiecemod.attatched"))) {
            if (!player.level().isClientSide && entity.isAlive()) {
                String s = entity.getCustomName().toString()+"'s Vivre Card";
                stack.setHoverName(Component.literal(s));
                player.sendSystemMessage(Component.literal(s));
                //system message for process confirmation
                addNbtToVIVRECARD(player, entity, true, hand);
                player.sendSystemMessage(Component.literal("yep"));
            }
            return InteractionResult.sidedSuccess(player.level().isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

    public boolean isFoil(ItemStack stack) {
        return stack.hasTag();
    }

    private void addNbtToVIVRECARD(Player player, LivingEntity entity, boolean a, InteractionHand hand){
        ItemStack vivreCard =
                player.getItemInHand(hand);
        CompoundTag nbtData = new CompoundTag();
        nbtData.putBoolean("onepiecemod.attatched", a);
        nbtData.putUUID("onepiecemod.attatchedentity", entity.getUUID());
        vivreCard.setTag(nbtData);
    }
}
