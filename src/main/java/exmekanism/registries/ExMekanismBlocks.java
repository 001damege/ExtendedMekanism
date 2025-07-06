package exmekanism.registries;

import exmekanism.ExMekanism;
import exmekanism.common.tile.TileEntityQuantumChemicalOxidizer;
import mekanism.common.attachments.component.AttachedEjector;
import mekanism.common.attachments.component.AttachedSideConfig;
import mekanism.common.attachments.containers.ContainerType;
import mekanism.common.attachments.containers.chemical.ChemicalTanksBuilder;
import mekanism.common.attachments.containers.item.ItemSlotsBuilder;
import mekanism.common.block.prefab.BlockTile.*;
import mekanism.common.content.blocktype.Machine;
import mekanism.common.item.block.ItemBlockTooltip;
import mekanism.common.recipe.MekanismRecipeType;
import mekanism.common.recipe.lookup.cache.SingleInputRecipeCache;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import mekanism.common.registries.MekanismDataComponents;
import mekanism.common.resource.BlockResourceInfo;

@SuppressWarnings("rawtypes")
public class ExMekanismBlocks {
    private ExMekanismBlocks() {}

    public static final BlockDeferredRegister DR = new BlockDeferredRegister(ExMekanism.MODID);

    public static final BlockRegistryObject<BlockTileModel<TileEntityQuantumChemicalOxidizer, Machine<TileEntityQuantumChemicalOxidizer>>, ItemBlockTooltip<BlockTileModel<TileEntityQuantumChemicalOxidizer, Machine<TileEntityQuantumChemicalOxidizer>>>> CHEMICAL_OXIDIZER =
            DR.register("quantum_chemical_oxidizer", () -> new BlockTileModel<>(ExMekanismBlockTypes.CHEMICAL_OXIDIZER, props -> props.mapColor(BlockResourceInfo.STEEL.getMapColor())),
                    (b, props) -> new ItemBlockTooltip<>(b, true, props
                            .component(MekanismDataComponents.EJECTOR, AttachedEjector.DEFAULT)
                            .component(MekanismDataComponents.SIDE_CONFIG, AttachedSideConfig.CHEMICAL_OUT_MACHINE)))
                    .forItemHolder(holder -> holder
                    .addAttachmentOnlyContainers(ContainerType.CHEMICAL, () -> ChemicalTanksBuilder.builder()
                            .addBasic(TileEntityQuantumChemicalOxidizer.MAX_GAS)
                            .build()
                    ).addAttachmentOnlyContainers(ContainerType.ITEM, () -> ItemSlotsBuilder.builder()
                            .addInput(MekanismRecipeType.OXIDIZING, SingleInputRecipeCache::containsInput)
                            .addChemicalDrainSlot(0)
                            .addEnergy()
                            .build()));
}
