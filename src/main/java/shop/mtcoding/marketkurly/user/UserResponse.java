package shop.mtcoding.marketkurly.user;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UserResponse {
    @Getter
    @AllArgsConstructor
    public static class UserFindUsernameDTO {
        private String username;

        public UserFindUsernameDTO(User user) {
            this.username = user.getUsername();
        }
    }

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
        private String role;

        public JoinDTO(User user) {
            this.id = user.getId();
            this.userId = user.getUserId();
            this.userPassword = null;
            this.username = user.getUsername();
            this.userEmail = user.getUserEmail();
            this.userBirth = user.getUserBirth();
            this.userGender = user.getUserGender().name();
            this.role = user.getRole().name();
        }

    }

}
