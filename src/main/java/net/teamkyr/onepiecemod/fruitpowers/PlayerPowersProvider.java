package net.teamkyr.onepiecemod.fruitpowers;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerPowersProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerPowers> PLAYER_POWERS = CapabilityManager.get(new CapabilityToken<PlayerPowers>() { });

    private PlayerPowers powers = null;

    private final LazyOptional<PlayerPowers> optional= LazyOptional.of(this::createPlayerPowers);

    private PlayerPowers createPlayerPowers() {
        if(this.powers == null){
            this.powers = new PlayerPowers();
        }
        return this.powers;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_POWERS){
            return  optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerPowers().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerPowers().loadNBTData(nbt);
    }
}
