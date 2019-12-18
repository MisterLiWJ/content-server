package shop.tanjie.content.contentserver.base.interceptor.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import shop.tanjie.content.contentserver.utils.IpUtil;
import shop.tanjie.content.contentserver.utils.JSONUtil;
import shop.tanjie.content.contentserver.utils.RequestHolder;
import shop.tanjie.content.contentserver.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author: Chenjz
 * @Date: 2019/3/11 16:36
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LoggingService {
    private Logger logger = LoggerFactory.getLogger(LoggingService.class);


    @Transactional(rollbackFor = Exception.class)
    public void save(ProceedingJoinPoint joinPoint, Logging logging){
        // 获取request
        HttpServletRequest request = RequestHolder.getHttpServletRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log log = method.getAnnotation(Log.class);
        // 描述
        if (log != null) {
            logging.setDescription(log.description());
        }
        // 方法路径
        String methodName = joinPoint.getTarget().getClass().getName()+"."+signature.getName()+"()";
        String params = "{";
        //参数值
        Object[] argValues = joinPoint.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        // 用户名
        if(argValues != null){
            for (int i = 0; i < argValues.length; i++) {
                params += " " + argNames[i] + ": " + argValues[i];
            }
        }
        // 获取IP地址
        logging.setRequestIp(IpUtil.getIP(request));
        //获取用户主键
        String userid = StringUtil.getUserid(request);
        if(StringUtil.isNotEmpty(userid)){//前台用户登录
            logging.setUid(userid);
        }
        logging.setMethod(methodName);
        logging.setUid("");
        logging.setParams(params + " }");
        logger.info("统一日志打印==>>>"+ JSONUtil.toJSON(logging));
    }
}
