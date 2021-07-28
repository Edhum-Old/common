package net.edhum.common.i18n.language.map;

import com.google.inject.throwingproviders.CheckedProvider;

import java.sql.SQLException;

public interface LanguageMapProvider extends CheckedProvider<LanguageMap> {

    @Override
    LanguageMap get() throws SQLException;
}
