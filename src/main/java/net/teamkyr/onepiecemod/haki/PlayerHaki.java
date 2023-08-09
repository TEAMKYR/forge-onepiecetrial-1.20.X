package net.teamkyr.onepiecemod.haki;

import net.minecraft.nbt.CompoundTag;

public class PlayerHaki {
    private int Ahaki;
    private int Ohaki;
    private int PlayerAhakiCap;
    private int PlayerOhakiCap;
    private boolean Achosen = true;
    private int toNextAhakiLvl;
    private  int toNextOhakiLvl;
    private int Ahakilvl;
    private int Ohakilvl;

    public int getAHaki(){
        return Ahaki;
    }

    public void AHakiAdd(){
        this.Ahaki++;
    }

    public void AHakiSub(){
        this.Ahaki--;
    }

    public void AHakiReset(){
        this.Ahaki = 0;
    }
    public void copyFrom(PlayerHaki source){
        this.Ahaki = source.Ahaki;
        this.Ohaki = source.Ohaki;
        this.PlayerAhakiCap = source.PlayerAhakiCap;
        this.PlayerOhakiCap = source.PlayerOhakiCap;
        this.Achosen = source.Achosen;
        this.toNextAhakiLvl = source.toNextAhakiLvl;
        this.toNextOhakiLvl = source.toNextOhakiLvl;
    }

    public void saveNBTDataA(CompoundTag nbt){
        nbt.putInt("Ahaki", Ahaki);
    }

    public void loadNBTDataA(CompoundTag nbt){
        Ahaki = nbt.getInt("Ahaki");
    }
    public int getAHNeededForNextLevel() {
        if (this.Ahakilvl >= 30) {
            return 112 + (this.Ahakilvl - 30) * 9;
        } else {
            return this.Ahakilvl >= 15 ? 37 + (this.Ahakilvl - 15) * 5 : 7 + this.Ahakilvl * 2;
        }
    }
    public int getOHNeededForNextLevel(){
        if (this.Ohakilvl >= 30) {
            return 112 + (this.Ohakilvl - 30) * 9;
        } else {
            return this.Ohakilvl >= 15 ? 37 + (this.Ohakilvl - 15) * 5 : 7 + this.Ohakilvl * 2;
        }
    }
    public int getAhakilevel(){
        return Ahakilvl;
    }
    public int getOhakilevel(){
        return Ohakilvl;
    }

    public void Ahakileveladd(){
        this.Ahakilvl++;
    }
    public void Ohakileveladd(){
        this.Ohakilvl++;
    }

    public int getOHaki(){
        return Ohaki;
    }

    public void OHakiAdd(){
        this.Ohaki++;
    }

    public void OHakiSub(){
        this.Ohaki--;
    }

    public void OHakiReset(){
        this.Ohaki =0;
    }
    public void saveNBTDataO(CompoundTag nbt){
        nbt.putInt("Ohaki", Ohaki);
    }

    public void loadNBTDataO(CompoundTag nbt){
        Ohaki = nbt.getInt("Ohaki");
    }

    public boolean getAchosen(){
        return Achosen;
    }
}
