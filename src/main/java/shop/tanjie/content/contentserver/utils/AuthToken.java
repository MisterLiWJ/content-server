package shop.tanjie.content.contentserver.utils;



import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;

/**
 * Created by chenjz on 2017/8/2.
 * token的生成/解密工具
 * 1-用户的ID 2-用户手机的唯一识别码 3-私钥 用英文的。分隔
 * token
 */
public class AuthToken {

    /*DES加密*/
    private final static String DES = "DES";
    private final static String ENCODE = "UTF-8";
    private final static String defaultKey = "tanjie2019.v1";

    /**
     * des加密生成token
     * @param userid - 用户id
     * @param pwd - 密码
     * @return
     */
    public static String createToken(String userid, String pwd){
        String token = userid+"."+pwd;
        try {
            token = encrypt(token).trim();
        } catch (Exception e) {
            return null;
        }
        return token;
    }
    /**
     * des加密生成token
     * @param userid - 用户id
     * @param tel - 密码
     * @return
     */
    public static String createTokenByTel(String userid, String tel){
        String token = userid+"."+ tel;
        try {
            token = encrypt(token).trim();
        } catch (Exception e) {
            return null;
        }
        return token;
    }

    /**
     * 解密token
     * @param num - 1 - 拿取用户ID 2 - 拿取sessionId 3 - 拿取公钥(暂时不启用)
     * @param encreptMess - 密文：token
     * @return
     */
    public static String authToken(int num, String encreptMess){
        if(StringUtil.isEmpty(encreptMess)) return null;
        try {
            /*拿到解密后的源文件*/
            String userid_mac = decrypt(encreptMess);
            String []token = userid_mac.split("\\.");
            switch (num){
                case 1:
                    return token[0];
                case 2:
                    return token[1];
                case 3:
                    return token[2];
                default:
                    return token[0];
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 使用 默认key 加密
     * @return String
     * @date 2015-3-17 下午02:46:43
     */
    public static String encrypt(String data) throws Exception {
        byte[] bt = encrypt(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
        String strs = new Base64().encode(bt);
        return strs;
    }

    /**
     * 使用 默认key 解密
     * @return String
     * @date 2015-3-17 下午02:49:52
     */
    public static String decrypt(String data) throws IOException, Exception {
        if (data == null)
            return null;
        Base64 decoder = new Base64();
        byte[] buf = decoder.decode(data);
        byte[] bt = decrypt(buf, defaultKey.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }

    /**
     * Description 根据键值进行加密
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
        String strs = new Base64().encode(bt);
        return strs;
    }

    /**
     * Description 根据键值进行解密
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws Exception {
        if (data == null){
            return null;
        }
        Base64 decoder = new Base64();
        byte[] buf = decoder.decode(data);
        byte[] bt = decrypt(buf, key.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }

    /**
     * Description 根据键值进行加密
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     * @param data
     * @param key
     *            加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }


}

