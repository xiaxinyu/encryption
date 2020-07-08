package com.xiaxinyu.encryption;

import com.xiaxinyu.encryption.des.DesUtils;

public class DesUtil {

    private static final String password = "devops12#$";

    // 测试
    public static void main(String args[]) throws Exception {
        // 待加密内容
        String str = "cryptology";

        String result = DesUtils.encrypt(str);
        System.out.println("加密后：" + result);

        // 直接将如上内容解密
        String decryResult = DesUtils.decrypt(result);
        System.out.println("解密后：" + new String(decryResult));
    }
}