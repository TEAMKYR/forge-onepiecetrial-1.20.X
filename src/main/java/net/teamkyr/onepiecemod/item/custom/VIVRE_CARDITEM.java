package net.teamkyr.onepiecemod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

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

    private LivingEntity attatchedentity;
    private boolean attatched = false;

    public VIVRE_CARDITEM(Properties properties) {
        super(properties);
    }

    @Override
    //"Eye of Ender"s over to the entity to which the item is "attatched" to; can only be used if attatched = true | not implemented
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND && attatched) {

        }
        return super.use(level, player, hand);
    }

    //When used on a named entity, it "attatches" to them, so when used again it will "Eye of Ender" towards their location
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (entity.hasCustomName() && !attatched) {
            if (!player.level().isClientSide && entity.isAlive()) {
                attatchedentity = entity;
                stack.setHoverName(Component.literal(attatchedentity.getCustomName()+"'s Vivre Card"));
                attatched = true;
                //system message for process confirmation
                player.sendSystemMessage(Component.literal("yep"));
            }
            return InteractionResult.sidedSuccess(player.level().isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }
}
