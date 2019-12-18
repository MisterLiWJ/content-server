package shop.tanjie.content.contentserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@ComponentScan("shop.tanjie.content.contentserver")
@ImportResource("classpath:applicationContext.xml")
@EnableAsync
@PropertySource("classpath:application.properties")
public class ContentServerApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ContentServerApplication.class, args);
    }

//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
//        dataSource.setInitialSize(2);// 初始化连接数量
//        dataSource.setMaxActive(1000);//最大活跃链接数
//        dataSource.setMinIdle(0);//最小连接池数量
//        dataSource.setMaxWait(60000);//配置获取连接等待超时的时间 毫秒
//        dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql，要求是一个查询语句。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会其作用。
//        dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
//        dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于 timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
//        dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement
//        return dataSource;
//    }

    /**
     * ES配置
     * @return
     * @throws Exception
     */
//    @Bean
//    public TransportClient transportClient() throws Exception{
//        Settings settings = Settings.builder()
//                .put("cluster.name",env.getProperty("es.name") )
//                .build();
//        TransportClient client = new PreBuiltTransportClient(settings)
//                .addTransportAddress(new TransportAddress(InetAddress.getByName(env.getProperty("es.localhost")), Integer.parseInt(env.getProperty("es.port"))));
//        return client;
//    }

}
