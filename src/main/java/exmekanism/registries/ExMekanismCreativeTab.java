package exmekanism.registries;

import exmekanism.ExMekanism;
import mekanism.common.registration.MekanismDeferredHolder;
import mekanism.common.registration.impl.CreativeTabDeferredRegister;
import mekanism.common.registries.MekanismBlocks;
import net.minecraft.world.item.CreativeModeTab;

public class ExMekanismCreativeTab {
    public static final CreativeTabDeferredRegister DR = new CreativeTabDeferredRegister(ExMekanism.MODID);

    public static final MekanismDeferredHolder<CreativeModeTab, CreativeModeTab> TAB = DR.registerMain(ExMekanismLang.EXMEKANISM,
            MekanismBlocks.ANTIPROTONIC_NUCLEOSYNTHESIZER.getItemHolder(), builder -> builder.withSearchBar()
                    .displayItems((params, output) -> {
                        CreativeTabDeferredRegister.addToDisplay(ExMekanismBlocks.DR, output);
                        CreativeTabDeferredRegister.addToDisplay(ExMekanismItems.DR, output);
                    }));
}
