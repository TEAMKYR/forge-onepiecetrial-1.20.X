package net.teamkyr.onepiecemod.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.teamkyr.onepiecemod.OpMod;
import net.teamkyr.onepiecemod.item.custom.Devil_Fruit;
import net.teamkyr.onepiecemod.item.custom.VIVRE_CARDITEM;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OpMod.MOD_ID);

    public static final RegistryObject<Item> VIVRE_CARD = ITEMS.register("vivre_card",
            ()-> new VIVRE_CARDITEM(new Item.Properties().fireResistant().stacksTo(1)));

    //Effect Fruits
    public static final RegistryObject<Item> FIRERESIST_FRUIT = ITEMS.register("fireresist_fruit",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, -1, 0), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> REGEN_FRUIT_I = ITEMS.register("regen_fruit_i",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.REGENERATION, -1, 0), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> REGEN_FRUIT_II = ITEMS.register("regen_fruit_ii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.REGENERATION, -1, 1), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> REGEN_FRUIT_III = ITEMS.register("regen_fruit_iii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> SPEED_FRUIT_I = ITEMS.register("speed_fruit_i",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 0), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> SPEED_FRUIT_II = ITEMS.register("speed_fruit_ii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 1), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> SPEED_FRUIT_III = ITEMS.register("speed_fruit_iii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 2), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> STRENGTH_FRUIT_I = ITEMS.register("strength_fruit_i",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 0), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> STRENGTH_FRUIT_II = ITEMS.register("strength_fruit_ii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 1), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> STRENGTH_FRUIT_III = ITEMS.register("strength_fruit_iii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 2), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> INVISIBLE_FRUIT = ITEMS.register("invisible_fruit",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.INVISIBILITY, -1, 0), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> NV_FRUIT = ITEMS.register("nv_fruit",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, -1, 0), 1.0F)
                            .alwaysEat()
                            .build())));
    public static final RegistryObject<Item> LEAP_FRUIT_I = ITEMS.register("leap_fruit_i",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.JUMP, -1, 0), 1.0F)
                            .alwaysEat().build())));
    public static final RegistryObject<Item> LEAP_FRUIT_II = ITEMS.register("leap_fruit_ii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.JUMP, -1, 1), 1.0F)
                            .alwaysEat().build())));
    public static final RegistryObject<Item> LEAP_FRUIT_III = ITEMS.register("leap_fruit_iii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.JUMP, -1, 2), 1.0F)
                            .alwaysEat().build())));
    public static final RegistryObject<Item> HASTE_FRUIT_I = ITEMS.register("haste_fruit_i",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.DIG_SPEED, -1, 0), 1.0F)
                            .alwaysEat().build())));
    public static final RegistryObject<Item> HASTE_FRUIT_II = ITEMS.register("haste_fruit_ii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.DIG_SPEED, -1, 1), 1.0F)
                            .alwaysEat().build())));
    public static final RegistryObject<Item> HASTE_FRUIT_III = ITEMS.register("haste_fruit_iii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.DIG_SPEED, -1, 2), 1.0F)
                            .alwaysEat().build())));
    public static final RegistryObject<Item> RESIST_FRUIT_I = ITEMS.register("resist_fruit_i",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 0), 1.0F)
                            .alwaysEat().build())));
    public static final RegistryObject<Item> RESIST_FRUIT_II = ITEMS.register("resist_fruit_ii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 1), 1.0F)
                            .alwaysEat().build())));
    public static final RegistryObject<Item> RESIST_FRUIT_III = ITEMS.register("resist_fruit_iii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 2), 1.0F)
                            .alwaysEat().build())));
    public static final RegistryObject<Item> LUCK_FRUIT_I = ITEMS.register("luck_fruit_i",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.LUCK, -1, 0), 1.0F)
                            .alwaysEat().build())));
    public static final RegistryObject<Item> LUCK_FRUIT_II = ITEMS.register("luck_fruit_ii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.LUCK, -1, 1), 1.0F)
                            .alwaysEat().build())));
    public static final RegistryObject<Item> LUCK_FRUIT_III = ITEMS.register("luck_fruit_iii",
            ()-> new Devil_Fruit(new Item.Properties().fireResistant().rarity(Rarity.create("Legendary", ChatFormatting.GOLD)).stacksTo(1)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.LUCK, -1, 2), 1.0F)
                            .alwaysEat().build())));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}