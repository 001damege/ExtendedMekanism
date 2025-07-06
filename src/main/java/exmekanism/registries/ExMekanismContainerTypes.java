package exmekanism.registries;

import exmekanism.ExMekanism;
import exmekanism.common.tile.TileEntityQuantumChemicalOxidizer;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registration.impl.ContainerTypeDeferredRegister;
import mekanism.common.registration.impl.ContainerTypeRegistryObject;

public class ExMekanismContainerTypes {
    private ExMekanismContainerTypes() {}

    public static final ContainerTypeDeferredRegister DR = new ContainerTypeDeferredRegister(ExMekanism.MODID);

    public static final ContainerTypeRegistryObject<MekanismTileContainer<TileEntityQuantumChemicalOxidizer>> CHEMICAL_OXIDIZER = DR.register(ExMekanismBlocks.CHEMICAL_OXIDIZER, TileEntityQuantumChemicalOxidizer.class);
}
