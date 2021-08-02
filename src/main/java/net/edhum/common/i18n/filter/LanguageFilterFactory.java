package net.edhum.common.i18n.filter;

import net.edhum.common.i18n.Language;

import javax.inject.Named;
import java.util.function.Predicate;

public interface LanguageFilterFactory {

    @Named("id")
    Predicate<Language> id(int id);

    @Named("tag")
    Predicate<Language> tag(String tag);
}
