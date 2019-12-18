package shop.tanjie.content.contentserver.utils;



import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.UUID;

/**
 * @author Created by chenxx on 2016/6/21
 */
public class StringUtil {

//    public static String baseurl = "https://apis.tanjie.wang";//正式环境
    public static String baseurl = "http://localhost:5001";//本地环境


    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty() || value.trim().isEmpty() || value == "null" ||
                value.replaceAll("\\(","").replaceAll("\\)", "").equals("null");
    }

    public static boolean isEmpty(Object value) {
        return value == null;
    }

    public static boolean isNotEmpty(String value) {
        return value != "null" && value != null && !value.isEmpty() && !value.trim().isEmpty()
                && !value.replaceAll("\\(","").replaceAll("\\)", "").equals("null");
    }
    public static boolean isNotEmpty(Object value) {
        return value != null;
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 拿取用户主键
     * @param request
     * @return
     */
    public static String getUserid(HttpServletRequest request){
        String token = request.getHeader(RedisKeys.AUTHORITITION);//拿取当前登录的Token
        String userId = AuthToken.authToken(1, token);
        return userId;
    }

    /**
     * 生成验证码
     */
    public static String refreshCode() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        //设置验证码长度
        for (int i = 0; i < 6; i++) {
            builder.append(random.nextInt(9));
        }
        return builder.toString();
    }


}
