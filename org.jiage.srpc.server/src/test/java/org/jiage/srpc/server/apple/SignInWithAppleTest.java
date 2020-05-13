package org.jiage.srpc.server.apple;

import com.google.gson.Gson;
import io.jsonwebtoken.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.List;


public class SignInWithAppleTest {


    private static OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static String APPLE_PUBLIC_KEY_URL = "https://appleid.apple.com/auth/keys";

    private static Gson GSON = new Gson();

    @Test
    public void testing(){
        System.out.println(getPublicKey());
    }


    public boolean verify(String identityToken,String iss,String aud,String sub)  {
        PublicKey publicKey = getPublicKey();
        JwtParser jwtParser = Jwts.parser().setSigningKey(publicKey);
        jwtParser.requireIssuer(iss);
        jwtParser.requireAudience(aud);
        jwtParser.requireSubject(sub);
        try {
            Jws<Claims> claim = jwtParser.parseClaimsJws(identityToken);
            if (null != claim && claim.getBody().containsKey("auth_time")) {
                return true;
            }
            return false;
        } catch (ExpiredJwtException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }


    public static PublicKey getPublicKey() {
        try {
            String res =  getHttp(APPLE_PUBLIC_KEY_URL);
            if(StringUtils.isEmpty(res)){ return null; }
            AppleKeys appleKeys = GSON.fromJson(res,AppleKeys.class);
            List<AppleKey> keys = appleKeys.getKeys();
            String n = keys.get(0).getN();
            String e = keys.get(0).getE();
            final BigInteger modulus = new BigInteger(
                    1, Base64.getMimeDecoder().decode(n));
            final BigInteger publicExponent = new BigInteger(1,
                    Base64.getMimeDecoder().decode(e));
            final RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus, publicExponent);
            final KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePublic(spec);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getHttp(String url) throws Exception{
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
