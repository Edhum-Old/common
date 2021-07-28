package net.edhum.common.persistence.sql.exception;

import net.edhum.common.persistence.sql.credentials.SQLCredentials;

import java.sql.SQLException;

public class SQLInitialisationException extends SQLException {

    public SQLInitialisationException(SQLCredentials credentials, Throwable throwable) {
        super(
                String.format(
                        "An exception occurred during the creation of the SQL pool.\n" +
                                "The SQL configuration used was : %s",
                        credentials.toString()
                ),
                throwable
        );
    }
}
