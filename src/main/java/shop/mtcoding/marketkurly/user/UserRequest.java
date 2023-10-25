package shop.mtcoding.marketkurly.user;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.marketkurly.user.UserResponse.JoinDTO;

public class UserRequest {
    @Getter
    @NoArgsConstructor
    public static class LoginDTO {
        private String userId;
        private String userPassword;
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class UserJoinDTO {
        private Integer id; // PK
        private String userId;
        private String userPassword;
        private String username;
        private String userEmail;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate userBirth;
        private String userGender;

        // enum.valueOf (String)이 String 변수를 읽어서 enum 타입으로 바꿔준다.

        public Gender getUserGender() {
            return Gender.valueOf(userGender.toUpperCase());
        }

        public User toEntity() {
            return User.builder()
                    .userId(userId)
                    .userPassword(userPassword)
                    .username(username)
                    .userEmail(userEmail)
                    .userBirth(userBirth)
                    .userGender(Gender.valueOf(userGender))
                    .build();
        }

    }

    @NoArgsConstructor
    @Getter
    public static class UserIdDuplicatedDTO {
        private String userId;
    }

}