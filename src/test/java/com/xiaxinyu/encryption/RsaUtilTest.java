package com.xiaxinyu.encryption;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class RsaUtilTest {

    @Test
    public void testRas(){
        try{
            Map<String, String> keys = RsaUtils.genKeyPair();
            String publicKey = keys.get(RsaUtils.PUBLIC_KEY);
            String privateKey = keys.get(RsaUtils.PRIVATE_KEY);
            System.out.println(publicKey);
            System.out.println();
            System.out.println(privateKey);

            String testStr = "abc@123";
            String encryptedStr = RsaUtils.encrypt(testStr, publicKey);
            String decryptedStr = RsaUtils.decrypt(encryptedStr, privateKey);

            Assert.assertTrue(testStr.equals(decryptedStr));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
