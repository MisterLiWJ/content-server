package shop.tanjie.content.contentserver.utils.redis;

import redis.clients.jedis.JedisCluster;

/**
 * @author Created by chenjz on 2019/1/9.
 */
public class ClusterResource extends PoolResource<JedisCluster>{
    private JedisCluster cluster;

    public ClusterResource() {
    }

    public ClusterResource(JedisCluster cluster) {
        this.cluster = cluster;
    }

    @Override
    public JedisCluster resource() {
        return cluster;
    }

    @Override
    public void returnResourceObject(JedisCluster conn) {
        //不用操作
    }
}
