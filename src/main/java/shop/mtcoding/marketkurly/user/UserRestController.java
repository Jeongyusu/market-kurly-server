package shop.mtcoding.marketkurly.user;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.errors.exception.Exception400;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;

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

    // Get 요청은 Body가 없다.
    // Json데이터는 @RequestBody 어노테이션을 사용해서 받기
    @PostMapping("/api/user/findId")
    public ResponseEntity<?> 아이디찾기(@RequestBody UserRequest.UserFindUsernameDTO userFindUsernameDTO) {
        String userId = userService.아이디찾기(userFindUsernameDTO);

        if (userId == null) {
            throw new Exception400("입력하신 정보가 일치하지 않습니다");
        }

        System.out.println(ResponseEntity.ok().body(ApiUtils.success(userId)));
        return ResponseEntity.ok()
                .body(ApiUtils.success(userId.substring(0, 1) + "*".repeat((userId.length() - 1))));
    }

    @PostMapping("/api/user/login")
    public ResponseEntity<?> 로그인(@RequestBody UserRequest.LoginDTO loginDTO) {
        String jwt = userService.로그인(loginDTO);
        UserResponse.LoginDTO userPS = userService.로그인정보조회(loginDTO.getUserId());
        return ResponseEntity.ok().header("Authorization", "Bearer " + jwt)
                .body(ApiUtils.success((userPS)));
    }

    @PostMapping("/api/user/join")
    public ResponseEntity<?> 회원가입(@RequestBody UserRequest.UserJoinDTO userJoinDTO) {
        User userPS = userService.회원가입(userJoinDTO);
        userPS.setUserPassword(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiUtils.success(userPS));
    }

    @PostMapping("/api/userId/duplicated")
    public ResponseEntity<?> 중복확인(@RequestBody UserRequest.UserIdDuplicatedDTO request) {
        userService.중복확인(request.getUserId());
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

}