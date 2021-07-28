package net.edhum.common.i18n.language.map;

import net.edhum.common.i18n.language.Language;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PluginLanguageMap implements LanguageMap {

    private final Map<Integer, Language> languages;

    public PluginLanguageMap(Collection<Language> languages) {
        this.languages = languages.stream()
                .collect(Collectors.toMap(Language::getId, Function.identity()));
    }

    @Override
    public Optional<Language> getLanguageByTag(String tag) {
        return this.languages.values().stream()
                .filter(language -> language.getTag().equalsIgnoreCase(tag))
                .findAny();
    }

    @Override
    public Optional<Language> getLanguageByName(String name) {
        return this.languages.values().stream()
                .filter(language -> language.getName().equalsIgnoreCase(name))
                .findAny();
    }

    @Override
    public Collection<Language> getLanguages() {
        return this.languages.values();
    }
}
