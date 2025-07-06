package exmekanism.common.tile;

import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.tile.machine.TileEntityChemicalOxidizer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TileEntityQuantumChemicalOxidizer extends TileEntityChemicalOxidizer {
    public TileEntityQuantumChemicalOxidizer(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public static final long MAX_GAS = Long.MAX_VALUE;

    @Override
    public @NotNull IChemicalTankHolder getInitialChemicalTanks(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(gasTank = BasicChemicalTank.output(MAX_GAS, recipeCacheListener));
        return builder.build();
    }
}
