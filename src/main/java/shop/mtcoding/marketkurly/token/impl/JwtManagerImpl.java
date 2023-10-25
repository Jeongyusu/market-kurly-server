package shop.mtcoding.marketkurly.token.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import shop.mtcoding.marketkurly._core.errors.exception.Exception401;
import shop.mtcoding.marketkurly.token.JwtManager;
import shop.mtcoding.marketkurly.token.Payload;
import shop.mtcoding.marketkurly.token.TokenType;

import java.time.Instant;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtManagerImpl implements JwtManager {

    private final Environment env;

    @Override
    public Payload parse(String token) {
        String secret = getSecretKey();
        try {
            DecodedJWT decoded = JWT.require(Algorithm.HMAC512(secret)).build().verify(token);
            return Payload.createAtk(
                    decoded.getIssuedAtAsInstant(),
                    decoded.getExpiresAtAsInstant(),
                    decoded.getClaim("id").asInt(),
                    decoded.getClaim("username").asString(),
                    decoded.getClaim("role").asString()
            );
        } catch (JWTVerificationException e) {
            log.error("jwt 검증 오류", e);
            throw new Exception401("jwt 검증 오류");
        }
    }

    private String getSecretKey() {
        return env.getProperty("jwt.secret");
    }

    private long getAtkExpiry() {
        return Long.parseLong(Objects.requireNonNull(env.getProperty("jwt.atk.expire")));
    }

    @Override
    public boolean verifyAtk(String token) {
        String secret = getSecretKey();
        try {
            JWT.require(Algorithm.HMAC512(secret)).build().verify(token);
        } catch (JWTVerificationException e) {
            log.error("jwt 검증 오류", e);
            return false;
        }
        return true;
    }

    @Override
    public String buildAtk(Integer id, String username, String role) {
        String secret = getSecretKey();
        Instant now = Instant.now();
        return JWT.create()
                .withSubject(TokenType.ATK.name())
                .withIssuedAt(now)
                .withExpiresAt(now.plusSeconds(getAtkExpiry()))
                .withClaim("id", id)
                .withClaim("username", username)
                .withClaim("role", role)
                .sign(Algorithm.HMAC512(secret));
    }
}
