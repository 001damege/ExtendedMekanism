package exmekanism.registries;

import exmekanism.ExMekanism;
import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.text.ILangEntry;
import net.minecraft.Util;

@NothingNullByDefault
public enum ExMekanismLang implements ILangEntry {
    EXMEKANISM("constants", "mod_name"),
    DESCRIPTION_QUANTUM_CHEMICAL_OXIDIZER("description", "quantum_chemical_oxidizer"),
    ;

    private final String key;

    ExMekanismLang(String type, String path) {
        this(Util.makeDescriptionId(type, ExMekanism.makeId(path)));
    }

    ExMekanismLang(String key) {
        this.key = key;
    }

    @Override
    public String getTranslationKey() {
        return key;
    }
}
