package d6g.win.resource.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.ECDSAKeyProvider;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils
{

    private static final String SECRET = "_!ABC!@#EEE2353$_";

    /**
     * 获取Token
     * @param payload Token中内容
     * @param remeber 是否记住登陆
     * @return token
     */
    public static String getToken(Map<String, String> payload, boolean remeber) {

        JWTCreator.Builder builder = JWT.create();
        payload.forEach(builder::withClaim);

        int expire = remeber ? 365 : 7;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, expire);

        try {
            String token = JWT.create()
                    .withExpiresAt(calendar.getTime())
                    .sign(Algorithm.HMAC256(SECRET));

            return token;
        } catch (Exception e) {
            // 处理异常
            System.out.println(e);
            return null;
        }
    }

    public static DecodedJWT decode(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        return jwtVerifier.verify(token);
    }
}
