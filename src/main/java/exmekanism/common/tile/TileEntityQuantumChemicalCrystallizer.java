package exmekanism.common.tile;

import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.tile.machine.TileEntityChemicalCrystallizer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TileEntityQuantumChemicalCrystallizer extends TileEntityChemicalCrystallizer {
    public TileEntityQuantumChemicalCrystallizer(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public static final long MAX_CHEMICAL = Long.MAX_VALUE;

    @Override
    public @NotNull IChemicalTankHolder getInitialChemicalTanks(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(inputTank = BasicChemicalTank.inputModern(MAX_CHEMICAL, this::containsRecipe, recipeCacheListener));
        return builder.build();
    }
}
