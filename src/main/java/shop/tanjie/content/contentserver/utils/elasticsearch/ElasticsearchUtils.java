package shop.tanjie.content.contentserver.utils.elasticsearch;

import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.stereotype.Component;
import shop.tanjie.content.contentserver.personal.entity.PersonalEntity;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author liwj
 * @date 2019/12/16 0016 18:25
 * @description
 */
@Component
public class ElasticsearchUtils {

    @Resource
    private TransportClient client;

    /**
     * 获取我的页面数据
     * @param userid
     * @return
     */
    public PersonalEntity getPersional(String userid){
        try{
            PersonalEntity personalEntity=new PersonalEntity();
            Map<String,Object> returnMap=client.prepareGet("users2.0", "user", userid).setFetchSource(new String[]{"userid","name","head","red_sum","volids","fans","focusNumber","read_newly","volids_newly","fans_newly","focus_newly","is_card",""}, null).get().getSourceAsMap();
            if(returnMap!=null){
                personalEntity.setUserid(String.valueOf(returnMap.get("userid")));
                personalEntity.setName(String.valueOf(returnMap.get("name")));
                personalEntity.setHead(String.valueOf(returnMap.get("head")));
                personalEntity.setRed_sum(String.valueOf(returnMap.get("red_sum")));
                personalEntity.setVolids(Integer.parseInt(String.valueOf(returnMap.get("volids"))));
                personalEntity.setFan(Integer.parseInt(String.valueOf(returnMap.get("fans"))));
                personalEntity.setFocusNumber(Integer.parseInt(String.valueOf(returnMap.get("focusNumber"))));
                personalEntity.setRead_newly(Integer.parseInt(String.valueOf(returnMap.get("read_newly"))));
                personalEntity.setVolids_newly(Integer.parseInt(String.valueOf(returnMap.get("volids_newly"))));
                personalEntity.setFans_newly(Integer.parseInt(String.valueOf(returnMap.get("fans_newly"))));
                personalEntity.setFocus_newly(Integer.parseInt(String.valueOf(returnMap.get("focus_newly"))));
                personalEntity.setIs_card(Integer.parseInt(String.valueOf(returnMap.get("is_card"))));
            }
            return personalEntity;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
