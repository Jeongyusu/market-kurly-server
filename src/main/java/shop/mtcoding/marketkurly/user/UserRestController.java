package shop.mtcoding.marketkurly.user;

import org.mindrot.jbcrypt.BCrypt;
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
import shop.mtcoding.marketkurly.token.JwtManager;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;
    private final JwtManager jwtManager;

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
    @PostMapping("/api/findUserId")
    public ResponseEntity<?> 아이디찾기(@RequestBody UserRequest.UserFindUsernameDTO userFindUsernameDTO) {
        System.out.println("--------------------------------------");
        System.out.println(userFindUsernameDTO.getUsername());
        System.out.println(userFindUsernameDTO.getUserEmail());
        System.out.println("--------------------------------------");

        String userId = userService.아이디찾기(userFindUsernameDTO);

        if (userId != null) {
            System.out.println(ResponseEntity.ok().body(ApiUtils.success(userId)));
            return ResponseEntity.ok().body(ApiUtils.success(userId.substring(0, 1) + "*".repeat((userId.length() - 1))));
        } else {
            throw new Exception400("입력하신 정보가 일치하지 않습니다");
        }
    }

    @PostMapping("/api/userLogin")
    public UserResponse.LoginDTO 로그인(@RequestBody UserRequest.LoginDTO loginDTO) {
        UserInfo userInfo = userService.로그인(loginDTO);
        String atk = jwtManager.buildAtk(userInfo.getId(), userInfo.getUsername(), userInfo.getRole());
        return new UserResponse.LoginDTO(atk);
    }
    
   
    @PostMapping("/api/userJoin")
    public ResponseEntity<?> 회원가입(@RequestBody UserRequest.UserJoinDTO userJoinDTO) {
        String encPassword = BCrypt.hashpw(userJoinDTO.getUserPassword(), BCrypt.gensalt());
        userJoinDTO.setUserPassword(encPassword);
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