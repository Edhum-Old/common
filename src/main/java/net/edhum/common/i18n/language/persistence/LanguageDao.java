package net.edhum.common.i18n.language.persistence;

import com.google.inject.Inject;
import net.edhum.common.persistence.sql.SQLAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

public class LanguageDao {

    private final SQLAccess sqlAccess;

    @Inject
    public LanguageDao(SQLAccess sqlAccess) {
        this.sqlAccess = sqlAccess;
    }

    public Collection<LanguageBean> getLanguages() throws SQLException {
        Collection<LanguageBean> beans = new HashSet<>();

        try (Connection connection = this.sqlAccess.getResource()) {
            final String SQL = "SELECT * FROM languages";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tag = resultSet.getString("tag");
                String name = resultSet.getString("name");

                LanguageBean bean = new LanguageBean(id, tag, name);
                beans.add(bean);
            }
        }

        return beans;
    }
}
