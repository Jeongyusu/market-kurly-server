package shop.mtcoding.marketkurly.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.user.UserRequest.UserJoinDTO;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;
    private final UserJPARepository userJPARepository;

    @GetMapping("/test")
    void test() {
        log.info("인포");
        log.debug("디버그");
        log.trace("트레이스");
        log.warn("경고");
        log.error("에러");

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/userLogin")
    public UserResponse.LoginDTO 로그인(@RequestBody UserRequest.LoginDTO loginDTO) {
        UserInfo userInfo = userService.로그인(loginDTO);
        // TODO 토큰으로 변경예정
        return new UserResponse.LoginDTO(userInfo.getUserId());
    }

    @PostMapping("/api/userJoin")
    public ResponseEntity<?> 회원가입(@RequestBody UserRequest.UserJoinDTO userJoinDTO) {
        String encPassword = BCrypt.hashpw(userJoinDTO.getUserPassword(), BCrypt.gensalt());
        userJoinDTO.setUserPassword(encPassword);
        User userPS = userService.회원가입(userJoinDTO);
        userPS.setUserPassword(null);
        return ResponseEntity.ok().body(ApiUtils.success(userPS));
    }

    @PostMapping("/api/userId/duplicated")
    public void 중복확인(@RequestBody UserRequest.UserIdDuplicatedDTO request) {
        userService.중복확인(request.getUserId());
    }

}