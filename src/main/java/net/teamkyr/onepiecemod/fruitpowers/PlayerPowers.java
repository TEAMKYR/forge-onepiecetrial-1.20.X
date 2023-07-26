package net.teamkyr.onepiecemod.fruitpowers;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;

@AutoRegisterCapability
public class PlayerPowers {
    private int fruits;

    public int getFruits(){
        return fruits;
    }

    public void fruitAdd(){
        this.fruits++;
    }

    public void fruitSub(){
        this.fruits--;
    }

    public void fruitReset(){
        this.fruits =0;
    }
    public void copyFrom(PlayerPowers source){
        this.fruits = source.fruits;
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("fruits", fruits);
    }

    public void loadNBTData(CompoundTag nbt){
        fruits = nbt.getInt("fruits");
    }
}
