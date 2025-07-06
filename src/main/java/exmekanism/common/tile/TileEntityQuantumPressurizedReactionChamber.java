package exmekanism.common.tile;

import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.chemical.attribute.ChemicalAttributeValidator;
import mekanism.common.capabilities.fluid.BasicFluidTank;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.capabilities.holder.fluid.FluidTankHelper;
import mekanism.common.capabilities.holder.fluid.IFluidTankHolder;
import mekanism.common.integration.computer.SpecialComputerMethodWrapper;
import mekanism.common.integration.computer.annotation.WrappingComputerMethod;
import mekanism.common.inventory.slot.InputInventorySlot;
import mekanism.common.tile.machine.TileEntityPressurizedReactionChamber;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TileEntityQuantumPressurizedReactionChamber extends TileEntityPressurizedReactionChamber {
    public TileEntityQuantumPressurizedReactionChamber(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public static final long MAX_GAS = Long.MAX_VALUE;
    public static final int MAX_FLUID = Integer.MAX_VALUE;

    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getInputItem", docPlaceholder = "item input slot")
    InputInventorySlot inputSlot;

    @Override
    public @NotNull IChemicalTankHolder getInitialChemicalTanks(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(inputGasTank = BasicChemicalTank.createModern(MAX_GAS, ChemicalTankHelper.radioactiveInputTankPredicate(() -> outputGasTank),
                (gas, automationType) -> containsRecipeCAB(inputSlot.getStack(), inputFluidTank.getFluid(), gas), this::containsRecipeC,
                ChemicalAttributeValidator.ALWAYS_ALLOW, recipeCacheListener));
        builder.addTank(outputGasTank = BasicChemicalTank.output(MAX_GAS, recipeCacheUnpauseListener));
        return builder.build();
    }

    @Override
    protected @NotNull IFluidTankHolder getInitialFluidTanks(IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        FluidTankHelper builder = FluidTankHelper.forSideWithConfig(this);
        builder.addTank(inputFluidTank = BasicFluidTank.input(MAX_FLUID, fluid -> containsRecipeBAC(inputSlot.getStack(), fluid, inputGasTank.getStack()),
                this::containsRecipeB, recipeCacheListener));
        return builder.build();
    }
}
