package shop.tanjie.content.contentserver.base.interceptor.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Chenjz
 * @Date: 2019/1/27 18:45
 */
@Component
@Aspect
public class LogPointCut {

    private long currentTime = 0L;
    @Autowired
    private LoggingService loggingService;

    /**
     * 配置切入点
     */
    @Pointcut("@annotation(shop.tanjie.content.contentserver.base.interceptor.log.Log)")
    public void logPointcut(){

    }

    /**
     * 配置环绕通知打印日志
     * @param joinPoint
     * @return
     */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint){
        Object result = null;
        currentTime = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
            Logging logging = new Logging("INFO",System.currentTimeMillis() - currentTime);
            loggingService.save(joinPoint, logging);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    /**
     * 配置异常通知
     *
     * @param joinPoint join point for advice
     * @param throwable exception
     */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "throwable")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable throwable){
        Logging logging = new Logging("ERROR", System.currentTimeMillis() - currentTime);
        logging.setDescription(throwable.getMessage());
    }
}
