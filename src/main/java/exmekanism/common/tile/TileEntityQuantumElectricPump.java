package exmekanism.common.tile;

import mekanism.api.IContentsListener;
import mekanism.api.RelativeSide;
import mekanism.common.capabilities.fluid.BasicFluidTank;
import mekanism.common.capabilities.holder.fluid.FluidTankHelper;
import mekanism.common.capabilities.holder.fluid.IFluidTankHolder;
import mekanism.common.tile.machine.TileEntityElectricPump;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TileEntityQuantumElectricPump extends TileEntityElectricPump {
    public TileEntityQuantumElectricPump(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public static final int MAX_FLUID = Integer.MAX_VALUE;

    @Override
    protected @NotNull IFluidTankHolder getInitialFluidTanks(IContentsListener listener) {
        FluidTankHelper builder = FluidTankHelper.forSide(facingSupplier);
        builder.addTank(fluidTank = BasicFluidTank.output(MAX_FLUID, listener), RelativeSide.TOP);
        return builder.build();
    }
}
