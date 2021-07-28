package net.edhum.common.i18n.language.map;

import net.edhum.common.i18n.language.Language;
import net.edhum.common.i18n.language.LanguageImpl;

import java.util.Arrays;

public class UnavailableLanguageMap {

    public static final Language ENGLISH = new LanguageImpl(2, "en-EN", "english");
    public static final Language FRENCH = new LanguageImpl(3, "fr-FR", "french");

    private static final LanguageMap DEFAULT_LANGUAGE_MAP = new PluginLanguageMap(Arrays.asList(ENGLISH, FRENCH));

    public static LanguageMap getDefaultLanguageMap() {
        return DEFAULT_LANGUAGE_MAP;
    }
}
