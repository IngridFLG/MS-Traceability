package org.restaurante.mstrazabilidad.infrastructure.configuration.util;


import io.jsonwebtoken.*;
import org.restaurante.mstrazabilidad.infrastructure.configuration.exception.JwtException;

import java.util.Collections;
import java.util.List;

public class JwtUtil {

    private static final String jwtSecret = "9c9c48d57077710e8a8ec4a72f0c959fa11ea2c2e1073b7c7d39b4eefff5ddf8";

    public static List<String> getRoles(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(jwtSecret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

        String authority = claims.get("authorities", String.class);
        return Collections.singletonList(authority);
    }

    public static boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtSecret.getBytes())
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            throw new JwtException("Invalid Jwt token");
        } catch (ExpiredJwtException e) {
            throw new JwtException("JWT token is expired");
        } catch (UnsupportedJwtException e) {
            throw new JwtException("JWT token is unsupported");
        } catch (IllegalArgumentException e) {
            throw new JwtException("JWT claims string is empty");
        }
    }

    public static Long getUserId(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(jwtSecret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("userId", Long.class);
    }
}

