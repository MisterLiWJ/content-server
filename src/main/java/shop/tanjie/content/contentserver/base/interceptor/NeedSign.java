package shop.tanjie.content.contentserver.base.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义拦截登录的注解
 * @Author: Chenjz
 * @Date: 2019/1/27 21:05
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedSign {
}
