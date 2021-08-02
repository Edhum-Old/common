package net.edhum.common.i18n;

import java.util.Arrays;
import java.util.Optional;

public enum Language {

    ENGLISH(1, "en_EN"),
    FRENCH(2, "fr_FR");

    private final int id;
    private final String tag;

    Language(int id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public Optional<Language> findLanguage(int id) {
        return Arrays.stream(values())
                .filter(language -> language.id == id)
                .findAny();
    }

    public int getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }
}
