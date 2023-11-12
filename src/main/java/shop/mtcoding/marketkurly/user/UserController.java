package shop.mtcoding.marketkurly.user;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

    @PostMapping("/users/join")
    public String 판매자회원가입(SellerJoinDTO sellerJoinDTO) {
        System.out.println("판매자 회원가입 호출");
        userService.판매자회원가입(sellerJoinDTO);
        return "loginForm";
    }

    @PostMapping("/users/login")
    @ResponseBody
    public ResponseEntity<?> 판매자로그인(@RequestBody UserRequest.LoginDTO loginDTO, HttpServletResponse response,
            HttpServletRequest request) {

        System.out.println("login 호출");

        TokenDTO tokenDTO = userService.로그인(loginDTO);

        String jwt = "Bearer " + tokenDTO.getJwt();
        String encodedJwt = null;
        try {
            encodedJwt = URLEncoder.encode(jwt, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        response.setHeader("Set-Cookie", "token=" + encodedJwt + "; Path=/; HttpOnly; samesite=Strict");

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }
}
