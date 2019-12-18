package shop.tanjie.content.contentserver.base.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import shop.tanjie.content.contentserver.utils.AuthToken;
import shop.tanjie.content.contentserver.utils.RedisKeys;
import shop.tanjie.content.contentserver.utils.StringUtil;
import shop.tanjie.content.contentserver.utils.redis.JedisPoolResource;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * 实际的登录拦截
 * @Author: Chenjz
 * @Date: 2019/1/27 21:07
 */
@Component
public class NeedSignInterCeptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(NeedSignInterCeptor.class);

    @Resource
    private JedisPoolResource jedisPoolResource;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            NeedSign needsign = findAnnotation((HandlerMethod) handler, NeedSign.class);
            if(StringUtil.isNotEmpty(needsign)){
                String token = request.getHeader(RedisKeys.AUTHORITITION);//拿取当前登录的Token
                if(StringUtil.isNotEmpty(token)){
                    String userId = AuthToken.authToken(1, token);
                    String nowToken = jedisPoolResource.cmd(jedis -> jedis.hget(RedisKeys.AUTHORITITION, userId));//拿取Redis中该用户存储的token
                    //两个token进行比对是否一致
                    if(!(StringUtil.isNotEmpty(nowToken)&&nowToken.equals(token))){
                        response.sendRedirect(StringUtil.baseurl + "/needsign");
                    }
                }else{
                    response.sendRedirect(StringUtil.baseurl + "/needsign");
                }
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    private <T extends Annotation> T findAnnotation(HandlerMethod handler, Class<T> annotationType) {
        T annotation = handler.getBeanType().getAnnotation(annotationType);
        if (annotation != null) return annotation;
        return handler.getMethodAnnotation(annotationType);
    }
}
