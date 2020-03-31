package pers.paopa.springboot.demo.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    static final long EXPIRATIONTIME = 432_000_000;     // 5天
    static final String TOKEN_PREFIX = "Bearer";        // Token前缀
    static final String HEADER_STRING = "Authorization";// 存放Token的Header Key
    static final Key key = MacProvider.generateKey();    //給定一組密鑰，用來解密以及加密使用

    // JWT產生方法
    public static void addAuthentication(HttpServletResponse response, Authentication user) {

        // 生成JWT
        String jws = Jwts.builder()
                // 在Payload放入自定義的聲明方法如下
                //.claim("XXXXX",XXXXX)
                // 在Payload放入sub保留聲明
                .setSubject(user.getName())
                // 在Payload放入exp保留聲明
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512,key).compact();
        // 把JWT傳回response
        try {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getOutputStream().println(jws);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


