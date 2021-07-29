package net.edhum.common.i18n;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.throwingproviders.CheckedProvides;
import com.google.inject.throwingproviders.ThrowingProviderBinder;
import net.edhum.common.i18n.language.Language;
import net.edhum.common.i18n.language.LanguageImpl;
import net.edhum.common.i18n.language.ServerLanguage;
import net.edhum.common.i18n.language.exceptions.LanguageNotFoundException;
import net.edhum.common.i18n.language.map.LanguageMap;
import net.edhum.common.i18n.language.map.LanguageMapProvider;
import net.edhum.common.i18n.language.map.PluginLanguageMap;
import net.edhum.common.i18n.language.map.UnavailableLanguageMap;
import net.edhum.common.i18n.language.persistence.LanguageBean;
import net.edhum.common.i18n.language.persistence.LanguageDao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.stream.Collectors;

public class InternalisationModule extends AbstractModule {

    private static final String DEFAULT_SERVER_LANGUAGE_NAME = "french";

    @Override
    protected void configure() {
        install(ThrowingProviderBinder.forModule(this));
    }

    @CheckedProvides(LanguageMapProvider.class)
    public LanguageMap provideLanguageMap(LanguageDao languageDao) throws SQLException {
        Collection<LanguageBean> beans = languageDao.getLanguages();

        Collection<Language> languages = beans.stream()
                .map(bean -> new LanguageImpl(bean.id(), bean.tag(), bean.name()))
                .collect(Collectors.toSet());

        return new PluginLanguageMap(languages);
    }

    @Provides
    @ServerLanguage
    public Language provideServerLanguage(LanguageMapProvider languageMapProvider) {
        LanguageMap languageMap;

        try {
            languageMap = languageMapProvider.get();
        } catch (SQLException e) {
            e.printStackTrace();

            languageMap = UnavailableLanguageMap.getDefaultLanguageMap();
        }

        return languageMap.getLanguageByName(DEFAULT_SERVER_LANGUAGE_NAME).orElseThrow(() -> new LanguageNotFoundException(DEFAULT_SERVER_LANGUAGE_NAME));
    }
}
