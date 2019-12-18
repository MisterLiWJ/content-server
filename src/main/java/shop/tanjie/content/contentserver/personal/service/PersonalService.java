package shop.tanjie.content.contentserver.personal.service;

import org.springframework.stereotype.Service;
import shop.tanjie.content.contentserver.base.entity.ApiReuslt;
import shop.tanjie.content.contentserver.personal.entity.PersonalEntity;
import shop.tanjie.content.contentserver.utils.elasticsearch.ElasticsearchUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 用户信息展示
 * @author liwj
 * @date 2019/12/16 0016 16:15
 * @description
 */
@Service
public class PersonalService {

    @Resource
    private ElasticsearchUtils elasticsearchUtils;

    /**
     * 个人中心
     * @param userid
     * @return
     */
    public ApiReuslt findPersonal(String userid){
        try{
            System.out.println("==============================:"+userid);
            PersonalEntity entity=elasticsearchUtils.getPersional(userid);
            if(entity==null){
                return ApiReuslt.fail();
            }
            //浏览量设置万单位
            entity.setRed_sum(asRedNumber(Integer.parseInt(entity.getRed_sum())));

            if(entity.getIs_card()==2){
                entity.setShowCrownText("已认证");
            }

            //设置我的二维码
//            entity.setCodeUrl(jedisPoolResource.cmd(jedis -> jedis.hget(RedisKeys.QRCODE_URL, userid)));

            return ApiReuslt.success(entity);
        }catch (Exception e){
            e.printStackTrace();
            return ApiReuslt.fail();
        }
    }

    /**
     * 转换为万结尾单位
     * @param num
     * @return
     */
    public static String asRedNumber(int num){
        try{
            if(num>=10000){
                BigDecimal b = new BigDecimal(num);
                return b.divide(BigDecimal.valueOf(10000)).setScale(1, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString() + "万";
            }else{
                return String.valueOf(num);
            }
        }catch (Exception e){
            return "0";
        }
    }

}
