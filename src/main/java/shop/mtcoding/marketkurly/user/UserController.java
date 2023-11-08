package shop.mtcoding.marketkurly.user;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.user.UserRequest.SellerJoinDTO;
import shop.mtcoding.marketkurly.user.UserResponse.TokenDTO;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @PostMapping("/webJoin")
    public String 판매자회원가입(SellerJoinDTO sellerJoinDTO) {
        System.out.println("판매자 회원가입 호출");
        userService.판매자회원가입(sellerJoinDTO);
        return "loginForm";
    }

    @PostMapping("/users/login")
    @ResponseBody
    public ResponseEntity<?> 판매자로그인(@RequestBody UserRequest.LoginDTO loginDTO, HttpServletResponse response) {

        System.out.println("login 호출");
        TokenDTO tokenDTO = userService.로그인(loginDTO);
        // String jwt = "Bearer " + tokenDTO.getJwt();

        // Cookie cookie = new Cookie("jwt", tokenDTO.getJwt());
        // cookie.setHttpOnly(true);
        // cookie.setPath("/");
        // response.addCookie(cookie);

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiUtils.success(null));
    }

    @GetMapping("/seller")
    public String sellerMain() {
        System.out.println("테스트 : sellerMain 호출");
        return "seller/sellerMain";
    }

}
