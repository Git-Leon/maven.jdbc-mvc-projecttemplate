package com.github.curriculeon;

import com.github.curriculeon.utils.ConnectionBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by leon on 2/18/2020.
 */
public interface DatabaseConnectionInterface {
    String getDatabaseName();

    ConnectionBuilder getDatabaseConnectionBuilder();

    default Connection getDatabaseConnection() {
        return new ConnectionBuilder(getDatabaseConnectionBuilder())
                .setDatabaseName(getDatabaseName())
                .build();
    }

    default Connection getDatabaseEngineConnection() {
        return getDatabaseConnectionBuilder().build();
    }

    default void drop() {
        try {
            String sqlStatement = "DROP DATABASE IF EXISTS " + getDatabaseName() + ";";
            String successMessage = String.format("Unsuccessfully executed statement \n\t`%s`", sqlStatement);
            // TODO - Complete method implementation
            throw new SQLException(new UnsupportedOperationException("Method not yet implemented"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    default void create() {
        String sqlStatement = "CREATE DATABASE IF NOT EXISTS " + getDatabaseName().toLowerCase() + ";";
        try {
            String successMessage = String.format("Successfully executed statement \n\t`%s`", sqlStatement);
            // TODO - Complete method implementation
            throw new SQLException(new UnsupportedOperationException("Method not yet implemented"));
        } catch (SQLException e) {
            String errorMessage = String.format("Failed to execute statement\n\t`%s`", sqlStatement);
            throw new RuntimeException(errorMessage, e);
        }
    }

    default void use() {
        try {
            String sqlStatement = "USE " + getDatabaseName().toLowerCase() + ";";
            String successMessage = String.format("Successfully executed statement \n\t`%s`", sqlStatement);
            // TODO - Complete method implementation
            throw new SQLException(new UnsupportedOperationException("Method not yet implemented"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    default void executeStatement(String sqlStatement) {
        try {
            sqlStatement = sqlStatement.trim();
            String successMessage = String.format("Successfully executed statement \n\t`%s`", sqlStatement);
            // TODO - Complete method implementation
            throw new SQLException(new UnsupportedOperationException("Method not yet implemented"));
        } catch (SQLException e) {
            String errorMessage = String.format("Failed to execute statement \n\t`%s`", sqlStatement);
            throw new RuntimeException(errorMessage, e);
        }
    }

    default ResultSet executeQuery(String sqlQuery) {
        try {
            String successMessage = String.format("Successfully executed query \n\t`%s`", sqlQuery);
            // TODO - Complete method implementation
            throw new SQLException(new UnsupportedOperationException("Method not yet implemented"));
        } catch (SQLException e) {
            String errorMessage = String.format("Failed to execute query \n\t`%s`", sqlQuery);
            throw new RuntimeException(errorMessage, e);
        }
    }

    default Statement getScrollableStatement() {
        int resultSetType = ResultSet.TYPE_SCROLL_INSENSITIVE;
        int resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;
        try {
            return getDatabaseConnection().createStatement(resultSetType, resultSetConcurrency);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
