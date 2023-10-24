package shop.mtcoding.marketkurly.user;

import javax.annotation.Generated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResponse {
    @Getter
    @AllArgsConstructor
    public static class LoginDTO{
        private String accessToken;
    }
}
