package exmekanism.common.tile;

import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.tile.machine.TileEntityChemicalInfuser;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TileEntityQuantumChemicalInfuser extends TileEntityChemicalInfuser {
    public TileEntityQuantumChemicalInfuser(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public static final long MAX_GAS = Long.MAX_VALUE;

    @Override
    public @NotNull IChemicalTankHolder getInitialChemicalTanks(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(leftTank = BasicChemicalTank.inputModern(MAX_GAS, gas -> containsRecipe(gas, rightTank.getStack()), this::containsRecipe, recipeCacheListener));
        builder.addTank(rightTank = BasicChemicalTank.inputModern(MAX_GAS, gas -> containsRecipe(gas, leftTank.getStack()), this::containsRecipe, recipeCacheListener));
        builder.addTank(centerTank = BasicChemicalTank.output(MAX_GAS, recipeCacheUnpauseListener));
        return builder.build();
    }
}
