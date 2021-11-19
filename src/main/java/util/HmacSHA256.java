package util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacSHA256 {

    public static String sign(String secret, String data) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac sha256Hmac = Mac.getInstance("HmacSHA256");

        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),"HmacSHA256");
        sha256Hmac.init(secretKeySpec);

        byte[] signed = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));

        return Base64Url.encode(signed);
    }
}
