package net.edhum.common.persistence.sql;

import net.edhum.common.persistence.sql.exception.SQLInitialisationException;

import java.sql.Connection;
import java.sql.SQLException;

public interface SQLAccess {

    Connection getResource() throws SQLException;

    void init() throws SQLInitialisationException;

    void close();
}
