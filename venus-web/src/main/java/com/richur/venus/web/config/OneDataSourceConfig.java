package com.richur.venus.web.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * @Author richur
// * @Date 2019/10/11 10:05 AM
// * 数据源配置
// */
//@Configuration
//@MapperScan(basePackages = {"com.example.springbootdruidmultsource.mapper.master"}, sqlSessionFactoryRef = "oneSqlSessionFactory")
public class OneDataSourceConfig {
//    private static final String MAPPER_LOCAL = "classpath:mybatis/one/*.xml";
//
//    @ConfigurationProperties("spring.datasource.druid.one")
//    @Primary
//    @Bean(name = "oneDataSource")
//    public DruidDataSource druidDataSource() {
//        return new DruidDataSource();
//    }
//
//    @Bean(name = "oneTransactionManager")
//    @Primary
//    public DataSourceTransactionManager masterTransactionManager() {
//        return new DataSourceTransactionManager(druidDataSource());
//    }
//
//    @Bean(name = "oneSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("oneDataSource") DataSource dataSource) throws Exception {
//        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCAL));
//        return sessionFactoryBean.getObject();
//    }
}
