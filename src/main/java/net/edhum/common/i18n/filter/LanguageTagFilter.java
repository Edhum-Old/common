package net.edhum.common.i18n.filter;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.i18n.Language;

import java.util.function.Predicate;

public class LanguageTagFilter implements Predicate<Language> {

    private final String tag;

    @AssistedInject
    public LanguageTagFilter(@Assisted String tag) {
        this.tag = tag;
    }

    @Override
    public boolean test(Language language) {
        return language.getTag().equalsIgnoreCase(this.tag);
    }
}
