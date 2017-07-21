package com.nduyhai.store.configuration;

import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.tomcat.jdbc.pool.jmx.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author nduyhai
 */
@Configuration
@EnableJpaRepositories(
    basePackages = "com.nduyhai.store.repository", 
    entityManagerFactoryRef = "storeManagerFactory", 
    transactionManagerRef = "storeTransactionManager"
)
public class DataSourceConfiguration extends AbstractDataSourceConfiguration {

    @Autowired
    private JpaProperties jpaProperties;

    private final String DATA_SOURCE = "storeDataSource";
    private final String JMX_POOL = "jmxPool";
    private final String TRANSACTION_MANAGER = "storeTransactionManager";
    private final String MANAGER_FACTORY = "storeManagerFactory";
    private final String[] PACKAGE = {"com.nduyhai.store.repository.entities"};
    private final String UNIT_NAME = "storeUnitName";

    @Override
    @ConfigurationProperties(prefix = "app.datasource.store")
    @Primary
    @Bean(name = DATA_SOURCE)
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Override
    @Bean(name = JMX_POOL)
    @ConditionalOnExpression("${app.datasource.store.jmxEnabled:true}")
    public ConnectionPool jmxPool(@Qualifier(DATA_SOURCE) DataSource dataSource) throws SQLException {
        return this.getJmxPool(dataSource);
    }

    @Override
    @Primary
    @Bean(name = TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager(@Qualifier(DATA_SOURCE) DataSource dataSource) {
        return this.getTransactionManager(dataSource);
    }

    @Override
    @Primary
    @Bean(name = MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier(DATA_SOURCE) DataSource dataSource) {
        return this.getEntityManagerFactory(dataSource);
    }

    @Override
    protected String[] getPackageScan() {
        return PACKAGE;
    }

    @Override
    protected String getPersistentUnitName() {
        return UNIT_NAME;
    }

    @Override
    protected Map<String, String> getJpaPropertyMap() {
        return jpaProperties.getProperties();
    }
}
