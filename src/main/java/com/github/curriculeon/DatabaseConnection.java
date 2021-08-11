package com.github.curriculeon;

import com.github.curriculeon.utils.ConnectionBuilder;
import com.github.curriculeon.utils.IOConsole;

import java.util.Locale;

/**
 * Created by leon on 2/18/2020.
 */
public enum DatabaseConnection implements DatabaseConnectionInterface {
    PRODUCTION_DATABASE(new ConnectionBuilder()
            .setUser("root")
            .setPassword("")
            .setPort(3306)
            .setDatabaseVendor("mariadb")
            .setHost("127.0.0.1")),

    TESTING_DATABASE(new ConnectionBuilder()
            .setUser("root")
            .setPassword("")
            .setPort(3306)
            .setDatabaseVendor("mariadb")
            .setHost("127.0.0.1"));

    private final ConnectionBuilder connectionBuilder;

    DatabaseConnection(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    @Override
    public String getDatabaseName() {
        return name().toLowerCase(Locale.ROOT);
    }

    @Override
    public ConnectionBuilder getDatabaseConnectionBuilder() {
        return connectionBuilder;
    }
}
