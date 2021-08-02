package net.edhum.common.i18n.filter;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.i18n.Language;

import java.util.function.Predicate;

public class LanguageIdFilter implements Predicate<Language> {

    private final int id;

    @AssistedInject
    public LanguageIdFilter(@Assisted int id) {
        this.id = id;
    }

    @Override
    public boolean test(Language language) {
        return language.getId() == this.id;
    }
}
