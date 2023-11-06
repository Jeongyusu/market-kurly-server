package shop.mtcoding.marketkurly.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly.user.UserRequest.SellerJoinDTO;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @PostMapping("/api/sellers/join")
    public String 판매자회원가입(SellerJoinDTO sellerJoinDTO) {
        userService.판매자회원가입(sellerJoinDTO);
        return "redirect:/login";
    }

}
