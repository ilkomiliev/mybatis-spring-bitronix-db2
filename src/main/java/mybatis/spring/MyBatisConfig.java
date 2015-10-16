package mybatis.spring;

import mybatis.spring.persistence.Schema1Mapper;
import mybatis.spring.persistence.Schema2Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by ILIEVI on 14.10.2015.
 */
@Configuration
@Import(DSConfig.class)
public class MyBatisConfig {

    @Autowired
    private DSConfig dsConfig;

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean1() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dsConfig.getDataSource1());
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean2() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dsConfig.getDataSource2());
        return sqlSessionFactoryBean;
    }

    // Mapper Interfaces

    @Bean
    public MapperFactoryBean<Schema1Mapper> getSchema1Mapper() throws Exception {
        MapperFactoryBean<Schema1Mapper> mapperMapperFactoryBean = new MapperFactoryBean<>();
        mapperMapperFactoryBean.setMapperInterface(Schema1Mapper.class);
        mapperMapperFactoryBean.setSqlSessionFactory(getSqlSessionFactoryBean1().getObject());
        return mapperMapperFactoryBean;
    }

    @Bean
    public MapperFactoryBean<Schema2Mapper> getSchema2Mapper() throws Exception {
        MapperFactoryBean<Schema2Mapper> mapperMapperFactoryBean = new MapperFactoryBean<>();
        mapperMapperFactoryBean.setMapperInterface(Schema2Mapper.class);
        mapperMapperFactoryBean.setSqlSessionFactory(getSqlSessionFactoryBean2().getObject());
        return mapperMapperFactoryBean;
    }
}
