package exmekanism.common.tile;

import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.common.capabilities.fluid.BasicFluidTank;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.capabilities.holder.fluid.FluidTankHelper;
import mekanism.common.capabilities.holder.fluid.IFluidTankHolder;
import mekanism.common.tile.machine.TileEntityElectrolyticSeparator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TileEntityQuantumElectrolyticSeparator extends TileEntityElectrolyticSeparator {
    public TileEntityQuantumElectrolyticSeparator(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public static final long MAX_GAS = Long.MAX_VALUE;
    public static final int MAX_FLUID = Integer.MAX_VALUE;

    @Override
    protected @NotNull IFluidTankHolder getInitialFluidTanks(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        FluidTankHelper builder = FluidTankHelper.forSideWithConfig(this);
        builder.addTank(fluidTank = BasicFluidTank.input(MAX_FLUID, this::containsRecipe, recipeCacheListener));
        return builder.build();
    }

    @Override
    public @NotNull IChemicalTankHolder getInitialChemicalTanks(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(leftTank = BasicChemicalTank.output(MAX_GAS, recipeCacheUnpauseListener));
        builder.addTank(rightTank = BasicChemicalTank.output(MAX_GAS, recipeCacheUnpauseListener));
        return builder.build();
    }
}
