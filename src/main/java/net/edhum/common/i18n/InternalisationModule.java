package net.edhum.common.i18n;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class InternalisationModule extends AbstractModule {

    private static final Language DEFAULT_SERVER_LANGUAGE = Language.FRENCH;

    @Provides
    @ServerLanguage
    public Language provideServerLanguage() {
        return DEFAULT_SERVER_LANGUAGE;
    }
}
