package mybatis.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by ILIEVI on 14.10.2015.
 */
@EnableTransactionManagement
@ComponentScan("mybatis.spring.service")
@Import({DSConfig.class, TxManagerConfig.class, MyBatisConfig.class})
@Configuration
public class AppConfig {
}
