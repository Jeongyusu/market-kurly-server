package shop.mtcoding.marketkurly.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;

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
    public ResponseEntity<UserResponse.JoinDTO> 회원가입(@RequestBody UserRequest.UserJoinDTO userJoinDTO) {
        // 회원가입 로직 실행
        userService.회원가입(userJoinDTO);

        // 회원가입이 성공한 경우 JoinDTO를 생성하여 반환
        UserResponse.JoinDTO joinDTO = new UserResponse.JoinDTO(userJoinDTO.getId(), userJoinDTO.getUsername(),
                userJoinDTO.getUserPassword());

        return ResponseEntity.ok(joinDTO);
    }

    @PostMapping("/api/userId/duplicated")
    public void 중복확인(@RequestBody UserRequest.UserIdDuplicatedDTO request) {
        userService.중복확인(request.getUserId());
    }

}