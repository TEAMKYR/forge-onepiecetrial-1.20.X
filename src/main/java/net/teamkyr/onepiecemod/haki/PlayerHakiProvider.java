package net.teamkyr.onepiecemod.haki;

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

public class PlayerHakiProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerHaki> PLAYER_HAKI = CapabilityManager.get(new CapabilityToken<PlayerHaki>() { });

    private PlayerHaki haki = null;

    private final LazyOptional<PlayerHaki> optional= LazyOptional.of(this::createPlayerHaki);

    private PlayerHaki createPlayerHaki() {
        if(this.haki == null){
            this.haki = new PlayerHaki();
        }
        return this.haki;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_HAKI){
            return  optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerHaki().saveNBTDataA(nbt);
        createPlayerHaki().saveNBTDataO(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerHaki().loadNBTDataO(nbt);
        createPlayerHaki().loadNBTDataA(nbt);
    }
}
