package shop.mtcoding.marketkurly.user;

import javax.annotation.Generated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResponse {
    @Getter
    @AllArgsConstructor
    public static class LoginDTO {
        private String accessToken;
    }

    @Getter
    @AllArgsConstructor
    public static class JoinDTO {
        private Integer id;
        private String username;
        private String userPassword;

        public JoinDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.userPassword = null;
        }

    }

}
