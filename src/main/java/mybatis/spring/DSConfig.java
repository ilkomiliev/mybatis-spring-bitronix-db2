package mybatis.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by ILIEVI on 14.10.2015.
 */
@Configuration
public class DSConfig {

    @Bean
    public DataSource getDataSource1() {
        return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.HSQL)
                    .setName("testdb1")
                    .addScript("classpath:hsqldb-schema1.sql")
                    .build();
    }

    @Bean
    public DataSource getDataSource2() {
        return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.HSQL)
                    .setName("testdb2")
                    .addScript("classpath:hsqldb-schema2.sql")
                    .build();
    }
}
