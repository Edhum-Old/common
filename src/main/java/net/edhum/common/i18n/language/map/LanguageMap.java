package net.edhum.common.i18n.language.map;

import net.edhum.common.i18n.language.Language;

import java.util.Collection;
import java.util.Optional;

public interface LanguageMap {

    Optional<Language> getLanguageByTag(String tag);

    Optional<Language> getLanguageByName(String name);

    Collection<Language> getLanguages();
}
