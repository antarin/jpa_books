package com.mazsi.jpademo.security;

import com.mazsi.jpademo.config.Application;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static com.mazsi.jpademo.security.SecurityConstants.HEADER_STRING;
import static com.mazsi.jpademo.security.SecurityConstants.SECRET;
import static com.mazsi.jpademo.security.SecurityConstants.TOKEN_PREFIX;


@Slf4j
public class SecurityUtils {

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 300000))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();
    }

    public static String getUsername(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        return SecurityUtils.getUsernameFromToken(token);
    }

    private static String getUsernameFromToken(String token) {
        String user = null;
        if (token != null) {
            user = Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
        }

        log.info(user);

        return user;
    }

}
