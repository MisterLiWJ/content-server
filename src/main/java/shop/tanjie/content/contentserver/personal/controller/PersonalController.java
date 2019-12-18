package shop.tanjie.content.contentserver.personal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import shop.tanjie.content.contentserver.base.controller.BaseController;
import shop.tanjie.content.contentserver.base.entity.ApiReuslt;
import shop.tanjie.content.contentserver.base.interceptor.NeedSign;
import shop.tanjie.content.contentserver.personal.service.PersonalService;
import shop.tanjie.content.contentserver.utils.AuthToken;
import shop.tanjie.content.contentserver.utils.RedisKeys;

import javax.annotation.Resource;

/**
 * 用户信息展示
 * @author liwj
 * @date 2019/12/16 0016 16:14
 * @description
 */
@Controller
public class PersonalController extends BaseController  {

    @Resource
    private PersonalService personalService;

    /**
     * 获取我的界面数据
     * @param userid
     * @return
     */
    @NeedSign
    @PostMapping("/getPersonal")
    public ApiReuslt getPersonal(@RequestHeader(RedisKeys.AUTHORITITION) String token){
        return personalService.findPersonal(AuthToken.authToken(1, token));
    }


}
