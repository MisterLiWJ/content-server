package shop.tanjie.content.contentserver.base.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.tanjie.content.contentserver.base.entity.ApiReuslt;
import shop.tanjie.content.contentserver.base.interceptor.log.Log;


/**
 * @Author Chenjz
 * @Description Date 2019/12/12 10:43
 * @Version
 */
@Slf4j
@RequestMapping("/content")
@ResponseBody
public class BaseController {

    @Log(description = "登录拦截")
    @GetMapping(value = "/needSign")
    public ApiReuslt needSign(){
        return ApiReuslt.fail("请先登录！");
    }


}
