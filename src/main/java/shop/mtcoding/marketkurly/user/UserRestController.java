package shop.mtcoding.marketkurly.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/userLogin")
    public UserResponse.LoginDTO 로그인(@RequestBody UserRequest.LoginDTO loginDTO) {
        UserInfo userInfo = userService.로그인(loginDTO);
        // TODO 토큰으로 변경예정
        return new UserResponse.LoginDTO(userInfo.getUserId());
    }

    @PostMapping("/api/userJoin")
    public void 회원가입(@RequestBody UserRequest.UserJoinDTO userJoinDTO) {
        userService.회원가입(userJoinDTO);

    }

    @PostMapping("/api/userId/duplicated")
    public void 중복확인(@RequestBody UserRequest.UserIdDuplicatedDTO request) {
        userService.중복확인(request.getUserId());
    }

}