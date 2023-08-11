package net.teamkyr.onepiecemod.fruitpowers;

import net.minecraft.nbt.CompoundTag;

public class PlayerPowers {
    private int fruits;
    private boolean zoan = false;
    private String mob = "";

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
        this.zoan = false;
        this.mob = "";
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
    public String getMob(){return this.mob;}
    public boolean isZoan(){
        return this.zoan;
    }
    public void setMob(String Mobname){
        this.mob = Mobname;
    }
}
