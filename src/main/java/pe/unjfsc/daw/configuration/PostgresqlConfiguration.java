package pe.unjfsc.daw.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.core.io.Resource;

@Configuration
public class PostgresqlConfiguration {

	@Value("classpath:/org/springframework/batch/core/schema-postgresql.sql")
	private Resource dataScript;
	
	@Value("classpath:/org/springframework/batch/core/schema-drop-postgresql.sql")
	private Resource dataScriptDrop;
	
	@Bean
	public SingleConnectionDataSource getDataSource() {
		SingleConnectionDataSource connection = new SingleConnectionDataSource();
		connection.setDriverClassName("org.postgresql.Driver");
		connection.setUrl("jdbc:postgresql://localhost:5432/ExamenM2G06");
		connection.setUsername("postgres");
		connection.setPassword("admin");
		connection.setSuppressClose(true);
		initializeDataBase().execute(connection);
		return connection;
	}
	
	@Bean
	public ResourceDatabasePopulator initializeDataBase() {
	    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	    populator.addScript(dataScriptDrop);
	    populator.addScript(dataScript);
	    return populator;
	}
	
	@Bean
	public DataSourceTransactionManager transactionM() {
		DataSourceTransactionManager transactionM = new DataSourceTransactionManager();
		transactionM.setDataSource(getDataSource());
		return transactionM;
	}
	
}