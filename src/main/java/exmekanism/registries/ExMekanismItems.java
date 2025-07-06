package exmekanism.registries;

import exmekanism.ExMekanism;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ExMekanismItems {
    private ExMekanismItems() {}

    public static final ItemDeferredRegister DR = new ItemDeferredRegister(ExMekanism.MODID);

    public static final ItemRegistryObject<Item> QUANTUM_CONTROL_CURCUIT = registerCircuit("quantum", Item::new);

    public static final ItemRegistryObject<Item> QUANTUM_ALLOY = registerAlloy("quantum", Item::new);

    private static ItemRegistryObject<Item> registerCircuit(String id, Function<Item.Properties, ? extends Item> factory) {
        return DR.registerItem(id + "_control_circuit", p -> factory.apply(new Item.Properties()));
    }

    private static ItemRegistryObject<Item> registerAlloy(String id, Function<Item.Properties, ? extends Item> factory) {
        return DR.registerItem("alloy_" + id, p -> factory.apply(new Item.Properties()));
    }
}
