package exmekanism.common.tile;

import mekanism.common.tile.machine.TileEntityRotaryCondensentrator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityQuantumRotaryCondensentrator extends TileEntityRotaryCondensentrator {
    public TileEntityQuantumRotaryCondensentrator(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public static final int CAPACITY = Integer.MAX_VALUE;
}
