package exmekanism.registries;

import exmekanism.ExMekanism;
import exmekanism.common.tile.TileEntityQuantumChemicalOxidizer;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.registration.impl.TileEntityTypeDeferredRegister;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;

public class ExMekanismTileEntityTypes {
    private ExMekanismTileEntityTypes() {}

    public static final TileEntityTypeDeferredRegister DR = new TileEntityTypeDeferredRegister(ExMekanism.MODID);

    public static final TileEntityTypeRegistryObject<TileEntityQuantumChemicalOxidizer> CHEMICAL_OXIDIZER = DR.mekBuilder(ExMekanismBlocks.CHEMICAL_OXIDIZER, TileEntityQuantumChemicalOxidizer::new)
            .clientTicker(TileEntityMekanism::tickClient)
            .serverTicker(TileEntityMekanism::tickServer)
            .withSimple(Capabilities.CONFIG_CARD)
            .build();
}