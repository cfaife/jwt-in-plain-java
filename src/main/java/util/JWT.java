package util;

import javax.management.monitor.StringMonitor;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class JWT {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        String header = "{ \"alg\":\"HS256\" }";

        String payLoad="{ \"nome\":\"Mallon\", \"idade\":\"7\" }";

        String secret= "filho";

        String encodedData = Base64Url.encode(header)+"."+Base64Url.encode(payLoad);

        String signature = HmacSHA256.sign(secret,encodedData);

        String jwt = encodedData+"."+signature;

        System.out.println(jwt);



    }
}
