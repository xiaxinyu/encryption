package com.xiaxinyu.encryption;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JasyptTest {
    @Autowired
    StringEncryptor encryptor;

    @Test
    public void testEncrypt() {
        String key = "event";
        String encryptKey = this.encryptor.encrypt(key);

        Map<String, String> map = new HashMap();
        map.put("key", key);
        map.put("encryptKey", encryptKey);

        String pretty = JSON.toJSONString(map, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        log.info(pretty);
    }

    @Test
    public void testDecrypt() {
        String encryption = "hp6LOf8rCIKr8lPjZGFwXXkpRJN5PRfVh2Do2D3Bht5+5/BjC8feBvU4Ia2f4a3h";
        String key = this.encryptor.decrypt(encryption);

        Map<String, String> map = new HashMap();
        map.put("encryption", encryption);
        map.put("key", key);

        String pretty = JSON.toJSONString(map, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        log.info(pretty);
    }
}
