package mybatis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by ILIEVI on 14.10.2015.
 */
@Configuration
@Import(DSConfig.class)
public class TxManagerConfig {

    @Autowired
    private DSConfig dsConfig;

    @Bean
    public PlatformTransactionManager getTransactionManager() {
        ChainedTransactionManager chainedTransactionManager
                = new ChainedTransactionManager(getTransactionManager1(), getTransactionManager2());
        return chainedTransactionManager;
    }

    private PlatformTransactionManager getTransactionManager1() {
        return new DataSourceTransactionManager(dsConfig.getDataSource1());
    }


    private PlatformTransactionManager getTransactionManager2() {
        return new DataSourceTransactionManager(dsConfig.getDataSource2());
    }
}
