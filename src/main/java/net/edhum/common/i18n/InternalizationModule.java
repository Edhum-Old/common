package net.edhum.common.i18n;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;
import net.edhum.common.i18n.filter.LanguageFilterFactory;
import net.edhum.common.i18n.filter.LanguageIdFilter;
import net.edhum.common.i18n.filter.LanguageTagFilter;

import java.util.function.Predicate;

public class InternalizationModule extends AbstractModule {

    private static final Language DEFAULT_SERVER_LANGUAGE = Language.FRENCH;

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder()
                .implement(new TypeLiteral<Predicate<Language>>() {}, Names.named("id"), LanguageIdFilter.class)
                .implement(new TypeLiteral<Predicate<Language>>() {}, Names.named("tag"), LanguageTagFilter.class)
                .build(LanguageFilterFactory.class));
    }

    @Provides
    @ServerLanguage
    public Language provideServerLanguage() {
        return DEFAULT_SERVER_LANGUAGE;
    }
}
