package shop.tanjie.content.contentserver.base.dao;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 基础的请求类
 * @Author Chenjz
 * @Description Date 2019/12/12 10:42
 * @Version
 */
@Repository
public class BaseDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    protected MongoTemplate mongoTemplate;

    public int addLogs(String id, String uid, String parmas){
        String sql = "INSERT INTO `logs` (id,uid,params) VALUES (?,?,?);";
        return jdbcTemplate.update(sql, id, uid, parmas);
    }

}
