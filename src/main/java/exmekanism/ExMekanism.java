package exmekanism;

import exmekanism.registries.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(ExMekanism.MODID)
public class ExMekanism {
    public static final String MODID = "exmekanism";
    public static final Logger LOGGER = LoggerFactory.getLogger("Extended Mekanism");

    public static ExMekanism INSTANCE;

    public ExMekanism(IEventBus eventBus, ModContainer container) {
        INSTANCE = this;

        ExMekanismBlocks.DR.register(eventBus);
        ExMekanismContainerTypes.DR.register(eventBus);
        ExMekanismTileEntityTypes.DR.register(eventBus);
        ExMekanismCreativeTab.DR.register(eventBus);
        ExMekanismItems.DR.register(eventBus);
    }

    public static ResourceLocation makeId(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }


}
