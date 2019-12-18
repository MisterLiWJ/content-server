package shop.tanjie.content.contentserver.utils.elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import shop.tanjie.content.contentserver.utils.JSONUtil;

import java.net.InetAddress;

/**
 * es基础配置
 * @author liwj
 * @date 2019/12/16 0016 18:18
 * @description
 */
@Configuration
public class ElastcicsearchConfig {


    @Autowired
    private Environment env;

    @Bean
    public TransportClient transportClient() throws Exception{
        Settings settings = Settings.builder()
                .put("cluster.name",env.getProperty("es.name") )
                .build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(env.getProperty("es.localhost")), Integer.parseInt(env.getProperty("es.port"))));
        System.out.println(JSONUtil.toJSON(client));
        return client;
    }

}
