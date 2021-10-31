package com.blackfish.config;


import com.auth0.jwt.algorithms.Algorithm;
import com.blackfish.entity.User;
import com.blackfish.vo.TokenVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.cache.annotation.Cacheable;

import java.util.Date;

public class JWTUtil {
    private JWTUtil() {

    }

    // 过期时间 单位秒
    private static final long EFFECT_TIME = 1800;

    private static String SECRETKEY = "DyoonSecret_0581";

    /**
     * 生成token， 并设置JWT过期时间
     *
     * @param jwtInfo
     * @return
     */

    public static TokenVO generateToken(User jwtInfo) {
        try {
            Date expireDate = new Date(System.currentTimeMillis() + EFFECT_TIME * 1000);
            Algorithm algorithm = Algorithm.HMAC256(SECRETKEY);
            // 附带username信息
            String token = Jwts.builder()
                    .setExpiration(expireDate)
                    .setSubject("black")
                    .claim(CommonConstant.JWT_TOKEN_USERNAME, jwtInfo.getUserId())
                    //到期时间
                    .signWith(SignatureAlgorithm.HS256, SECRETKEY)
                    .compact();

            return new TokenVO(token, EFFECT_TIME, expireDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过jwt解析token中的信息
     *
     * @param token
     * @return
     */
    public static User getInfoFromToken(String token) {
        try {
            // 目前只有userName
            Claims claims = Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody();
            return new User((String) claims.get(CommonConstant.JWT_TOKEN_USERNAME));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
