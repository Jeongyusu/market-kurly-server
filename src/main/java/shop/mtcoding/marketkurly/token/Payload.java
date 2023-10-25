package shop.mtcoding.marketkurly.token;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Payload {

    private TokenType type;
    private Instant issuedAt;
    private Instant expiration;

    private Integer id;
    private String username;
    private String authorities;

    public static Payload createAtk(Instant issuedAt, Instant expiration,
                                    Integer id, String username, String role) {
        return new Payload(TokenType.ATK, issuedAt, expiration, id, username, role);
    }
}
