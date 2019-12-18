package shop.tanjie.content.contentserver.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjz on 2019/1/9;
 */
public class JSONUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * @param object
     * @return
     */
    public static String toJSON(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    /**
     * 转换为对象
     *
     * @param jsonString
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> T toObject(String jsonString, Class<T> clazz) throws Exception {
        return mapper.readValue(jsonString, clazz);
    }

    /**
     * 转换为对象
     *
     * @param jsonString
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> T toObjectNoException(String jsonString, Class<? extends T> clazz) {
        try {
            return mapper.readValue(jsonString, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 转换为json对象
     *
     * @param jsonString
     * @return
     * @throws Exception
     */
    public static JsonNode read(String jsonString) throws Exception {
        return mapper.readTree(jsonString);
    }

    /**
     * 转换为列表对象
     *
     * @param jsonString
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> List<T> toList(String jsonString, Class<T> clazz) throws Exception {
        JavaType javaType = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
        return mapper.readValue(jsonString, javaType);
    }

    /**
     * 处理异常之后返回
     * @param jsonString - 要转换的json串
     * @param clazz - 转换成的实体类型
     * @param <T> - 实体
     * @return
     */
    public static <T> List<T> toListNoException(String jsonString, Class<T> clazz) {
        JavaType javaType = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
        try {
            return mapper.readValue(jsonString, javaType);
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    /**
     * 字符串转JSON
     * @param json
     * @return
     */
    public static JsonNode jsonParser(String json) {
        try {
            return mapper.readTree(json);
        } catch (IOException e) {
            return null;
        }
    }

}
