package shop.mtcoding.marketkurly.token;

import lombok.Getter;

@Getter
public enum TokenType {

    ATK("access-token", "엑세스 토큰"),
    ;

    private final String value;
    private final String description;

    TokenType(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public boolean isAtk() {
        return this == ATK;
    }
}
