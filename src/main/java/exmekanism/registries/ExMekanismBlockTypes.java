package exmekanism.registries;

import exmekanism.common.tile.TileEntityQuantumChemicalOxidizer;
import mekanism.common.block.attribute.AttributeSideConfig;
import mekanism.common.config.MekanismConfig;
import mekanism.common.content.blocktype.BlockShapes;
import mekanism.common.content.blocktype.Machine;
import mekanism.common.content.blocktype.Machine.*;
import mekanism.common.registries.MekanismSounds;

public class ExMekanismBlockTypes {
    private ExMekanismBlockTypes() {}

    public static final Machine<TileEntityQuantumChemicalOxidizer> CHEMICAL_OXIDIZER = MachineBuilder
            .createMachine(() -> ExMekanismTileEntityTypes.CHEMICAL_OXIDIZER, ExMekanismLang.DESCRIPTION_QUANTUM_CHEMICAL_OXIDIZER)
            .withGui(() -> ExMekanismContainerTypes.CHEMICAL_OXIDIZER)
            .withSound(MekanismSounds.CHEMICAL_OXIDIZER)
            .withEnergyConfig(MekanismConfig.usage.chemicalOxidizer, MekanismConfig.storage.chemicalOxidizer)
            .with(AttributeSideConfig.ADVANCED_ELECTRIC_MACHINE)
            .withCustomShape(BlockShapes.CHEMICAL_OXIDIZER)
            .withComputerSupport("chemicalOxidizer")
            .build();
}
