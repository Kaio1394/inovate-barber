//package br.com.app.inovate_barber.application.service;
//
//import br.com.app.inovate_barber.application.interfaces.JwtService;
//import br.com.app.inovate_barber.domain.model.User;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import lombok.Getter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//import java.util.UUID;
//
//@Service
//public class JwtServiceImpl implements JwtService {
//
//    @Value("${security.jwt.secret}")
//    private String secret;
//
//    @Getter
//    @Value("${security.jwt.expiration}")
//    private long expiration;
//
//    @Override
//    public String generate(User user) {
//        return Jwts.builder()
//                .subject(user.getId().toString())
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(getKey())
//                .compact();
//    }
//
//    private UUID extractUserId(String token) {
//        return UUID.fromString(
//                Jwts.parser()
//                        .verifyWith(getKey())
//                        .build()
//                        .parseSignedClaims(token)
//                        .getPayload()
//                        .getSubject()
//        );
//    }
//
//    @Override
//    public boolean isValid(String token) {
//        try {
//            extractUserId(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    private SecretKey getKey() {
//        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
//    }
//}
