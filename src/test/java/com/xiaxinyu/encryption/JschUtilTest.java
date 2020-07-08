package com.xiaxinyu.encryption;

import com.xiaxinyu.encryption.jsch.JschUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.Security;
import java.util.Base64;
import java.util.Map;

public class JschUtilTest {
    @Test
    public void testGenKeyPair() {
        try {
            Map<String, String> map = JschUtils.genKeyPair("summer");
            String publicKey = map.get(JschUtils.PUBLIC_KEY);
            String privateKey = map.get(JschUtils.PRIVATE_KEY);
            System.out.println("-------------------Original----------------------");
            System.out.println(publicKey);
            System.out.println();
            System.out.println(privateKey);
            System.out.println("-------------------Clean----------------------");
            publicKey = JschUtils.cleanPublicKey(publicKey);
            privateKey = JschUtils.cleanPrivateKey(privateKey);
            System.out.println(publicKey);
            System.out.println();
            System.out.println(privateKey);

            System.out.println("-------------------Verify----------------------");
            if (Security.getProvider("BC") == null) {
                Security.addProvider(new BouncyCastleProvider());
            }
            PrivateKey privateKey1 = JschUtils.readPemPrivateKey("d:\\privateKey.pem");
            System.out.println(new String(Base64.getEncoder().encode(privateKey1.getEncoded())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
