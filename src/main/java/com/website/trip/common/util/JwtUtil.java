package com.website.trip.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60 * 30;         // 한달(30일 기준)

    //retrieve username from jwt token(토큰으로부터 사용자 이름 가져오기)
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getId);
    }

    //retrieve expiration date from jwt token(토큰으로부터 유효기간 가져오기)
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //for retrieveing any information from token we will need the secret key(토큰에 저장된 모든정보 가져오기)
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //check if the token has expired (토큰의 유효기간 검사)
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //generate token for user (토큰 생성)
    public String generateToken(int userId, String userName) {
        return generateToken(userId, userName,new HashMap<>());
    }

    public String generateToken(int userId, String userName, Map<String, Object> claims) {
        return doGenerateToken(userId, userName, claims);
    }


    //while creating the token - (토큰에 정보를 넣고, 시크릿 키를 이용해서 토큰을 compact하게 만든다)
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    private String doGenerateToken(int userId, String userName, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setId(String.valueOf(userId))
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    //validate token (토큰의 유효여부를 검사한다)
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

}
