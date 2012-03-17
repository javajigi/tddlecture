package net.slipp.support.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

public class ConnectionManager {
	private static DataSource dataSource;
	
    public static Connection getConnection() throws SQLException {
    	if (dataSource == null) {
    		dataSource = getDataSource();
    	}
        return dataSource.getConnection();
    }

    public static DataSource getDataSource() {
		EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
		factory.setDatabaseName("slipp-user");
		factory.setDatabaseType(EmbeddedDatabaseType.H2);
		factory.setDatabasePopulator(databasePopulator());
		return factory.getDatabase();
    }
    
	private static DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("user.sql"));
		return populator;
	}
}
