package exmekanism.common.tile;

import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.common.capabilities.fluid.BasicFluidTank;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.capabilities.holder.fluid.FluidTankHelper;
import mekanism.common.capabilities.holder.fluid.IFluidTankHolder;
import mekanism.common.tile.machine.TileEntityChemicalWasher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TileEntityQuantumChemicalWasher extends TileEntityChemicalWasher {
    public TileEntityQuantumChemicalWasher(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public static final long MAX_SLURRY = Long.MAX_VALUE;
    public static final int MAX_FLUID = Integer.MAX_VALUE;

    @Override
    public @NotNull IChemicalTankHolder getInitialChemicalTanks(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(inputTank = BasicChemicalTank.inputModern(MAX_SLURRY, slurry -> containsRecipeBA(fluidTank.getFluid(), slurry), this::containsRecipeB, recipeCacheListener));
        builder.addTank(outputTank = BasicChemicalTank.output(MAX_SLURRY, recipeCacheUnpauseListener));
        return builder.build();
    }

    @Override
    protected @NotNull IFluidTankHolder getInitialFluidTanks(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        FluidTankHelper builder = FluidTankHelper.forSideWithConfig(this);
        builder.addTank(fluidTank = BasicFluidTank.input(MAX_FLUID, fluid -> containsRecipeAB(fluid, inputTank.getStack()), this::containsRecipeA, recipeCacheListener));
        return builder.build();
    }
}
