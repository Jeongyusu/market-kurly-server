package shop.mtcoding.marketkurly.user;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequest {
    @Getter
    @NoArgsConstructor
    public static class LoginDTO{
        private String userId;
        private String userPassword;
    }
    @NoArgsConstructor
    @Getter
    public static class UserJoinDTO {
        private String userId;
        private String userPassword;
        private String username;
        private String userEmail;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate userBirth;
      
        private String userGender;

        // enum.valueOf (String)이 String 변수를 읽어서 enum 타입으로 바꿔준다.
        
        public Gender getUserGender() {
            System.out.println("TEST" + userGender.toUpperCase());
            return Gender.valueOf(userGender.toUpperCase());
        }
    }

    @NoArgsConstructor
    @Getter
    public static class UserIdDuplicatedDTO {
        private String userId;
    }

}