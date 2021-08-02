package net.edhum.common.i18n;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public enum Language {

    ENGLISH(1, "en_EN"),
    FRENCH(2, "fr_FR");

    private final int id;
    private final String tag;

    Language(int id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public static Optional<Language> find(Predicate<Language> predicate) {
        return Arrays.stream(values())
                .filter(predicate)
                .findAny();
    }

    public int getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }
}
