package com.example.TestEntity.security;

import com.example.TestEntity.repositery.UserRepositery;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private String SECRET_KEY = "secret";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    @Autowired
    UserRepositery userRepositery;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
            String role =this.userRepositery.findByUsername(userDetails.getUsername()).get().getRole();
            int userId=this.userRepositery.findByUsername(userDetails.getUsername()).get().getUserId();
        return createToken(claims, userDetails.getUsername(),role,userId);
    }

    private String createToken(Map<String, Object> claims, String subject,String role,int userId) {

        return Jwts.builder().setClaims(claims).setSubject(subject).claim("Role",role).claim("userId",userId).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10*24*100)) //24 hourse
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}