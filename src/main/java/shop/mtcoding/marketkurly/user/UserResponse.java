package shop.mtcoding.marketkurly.user;

import java.time.LocalDate;

import javax.annotation.Generated;

import org.springframework.format.annotation.DateTimeFormat;

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
        private String userId;
        private String userPassword;
        private String username;
        private String userEmail;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate userBirth;
        private String userGender;

        public JoinDTO(User user) {
            this.id = getId();
            this.userId = getUserId();
            this.userPassword = null;
            this.username = getUsername();
            this.userEmail = getUserEmail();
            this.userBirth = getUserBirth();
            this.userGender = getUserGender();
        }

    }

}
