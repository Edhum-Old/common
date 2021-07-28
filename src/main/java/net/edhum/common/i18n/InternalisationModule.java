package net.edhum.common.i18n;

import com.google.inject.AbstractModule;
import net.edhum.common.i18n.language.LanguageModule;

public class InternalisationModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new LanguageModule());
    }
}
