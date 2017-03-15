package neu.scweb.util;

import java.security.SecureRandom;
// 生成随机 固定位数 字符串
public class ScRandomString {
	/** 
     * 每位允许的字符 
     */  
    private static final String POSSIBLE_CHARS="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";  
      
    /** 
     * 生产一个指定长度的随机字符串 
     * @param length 字符串长度 
     * @return 
     */  
    public static String GenerateRandomString(int length) {  
        StringBuilder sb = new StringBuilder(length);  
        SecureRandom random = new SecureRandom();  
        for (int i = 0; i < length; i++) {  
            sb.append(POSSIBLE_CHARS.charAt(random.nextInt(POSSIBLE_CHARS.length())));  
        }  
        return sb.toString();  
    }  

    /** 
     * 生产一个指定长度的随机字符串 
     * @param 16 字符串长度 
     * @return 
     */  
    public static String GenerateRandomString16() {  
        StringBuilder sb = new StringBuilder(16);  
        SecureRandom random = new SecureRandom();  
        for (int i = 0; i < 16; i++) {  
            sb.append(POSSIBLE_CHARS.charAt(random.nextInt(POSSIBLE_CHARS.length())));  
        }  
        return sb.toString();  
    }  
}
