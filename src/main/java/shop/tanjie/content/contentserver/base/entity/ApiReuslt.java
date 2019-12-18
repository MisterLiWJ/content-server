package shop.tanjie.content.contentserver.base.entity;


/**
 * 统一返回的数据实体
 * @Author Chenjz
 * @Description Date 2019/12/12 15:31
 * @Version
 */
public class ApiReuslt<T> {
    private static final int SUCCESS_CODE = 200;
    private static final String SUCCESS_MSG = "SUCCESS";
    private static final int ERROR_CODE = 500;
    private static final String ERROR_MSG = "ERROR";

    private int code;
    private String msg;
    private T data;

    public static <T> ApiReuslt<T> success(){
        ApiReuslt<T> apiReuslt = new ApiReuslt<>();
        apiReuslt.setCode(SUCCESS_CODE);
        apiReuslt.setMsg(SUCCESS_MSG);
        return apiReuslt;
    }

    public static <T> ApiReuslt<T> success(String msg){
        ApiReuslt<T> apiReuslt = new ApiReuslt<>();
        apiReuslt.setCode(SUCCESS_CODE);
        apiReuslt.setMsg(msg);
        return apiReuslt;
    }

    public static <T> ApiReuslt<T> success(int code, String msg){
        ApiReuslt<T> apiReuslt = new ApiReuslt<>();
        apiReuslt.setCode(code);
        apiReuslt.setMsg(msg);
        return apiReuslt;
    }

    public static <T> ApiReuslt<T> success(T data){
        ApiReuslt<T> apiReuslt = new ApiReuslt<>();
        apiReuslt.setCode(SUCCESS_CODE);
        apiReuslt.setMsg(SUCCESS_MSG);
        apiReuslt.setData(data);
        return apiReuslt;
    }

    public static <T> ApiReuslt<T> success(int code, String msg, T data){
        ApiReuslt<T> apiReuslt = new ApiReuslt<>();
        apiReuslt.setCode(code);
        apiReuslt.setMsg(msg);
        apiReuslt.setData(data);
        return apiReuslt;
    }

    public static <T> ApiReuslt<T> fail(){
        ApiReuslt<T> apiReuslt = new ApiReuslt<>();
        apiReuslt.setCode(ERROR_CODE);
        apiReuslt.setMsg(ERROR_MSG);
        return apiReuslt;
    }

    public static <T> ApiReuslt<T> fail(String msg){
        ApiReuslt<T> apiReuslt = new ApiReuslt<>();
        apiReuslt.setCode(ERROR_CODE);
        apiReuslt.setMsg(msg);
        return apiReuslt;
    }

    public static <T> ApiReuslt<T> fail(int code, String msg){
        ApiReuslt<T> apiReuslt = new ApiReuslt<>();
        apiReuslt.setCode(code);
        apiReuslt.setMsg(msg);
        return apiReuslt;
    }

    public static <T> ApiReuslt<T> fail(T data){
        ApiReuslt<T> apiReuslt = new ApiReuslt<>();
        apiReuslt.setCode(ERROR_CODE);
        apiReuslt.setMsg(ERROR_MSG);
        apiReuslt.setData(data);
        return apiReuslt;
    }

    public static <T> ApiReuslt<T> fail(int code, String msg, T data){
        ApiReuslt<T> apiReuslt = new ApiReuslt<>();
        apiReuslt.setCode(code);
        apiReuslt.setMsg(msg);
        apiReuslt.setData(data);
        return apiReuslt;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
