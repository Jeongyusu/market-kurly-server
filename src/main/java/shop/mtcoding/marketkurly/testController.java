package shop.mtcoding.marketkurly;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

    @GetMapping({ "/", "/login" })
    public String main() {
        System.out.println("테스트 : 로그인 호출");
        return "loginForm";
    }

    @GetMapping("/join")
    public String join() {
        System.out.println("테스트 : 조인 호출");
        return "joinForm";
    }

    @GetMapping("/seller")
    public String sellerMain() {
        System.out.println("테스트 : sellerMain 호출");
        return "seller/sellerMain";
    }

    @GetMapping("/seller/product")
    public String sellerProduct() {
        System.out.println("테스트 : sellerProduct 호출");
        return "seller/sellerProduct";
    }

    @GetMapping("/seller/product/submit")
    public String sellerProductSubmit() {
        System.out.println("테스트 : sellerProductSubmit 호출");
        return "seller/sellerProductSubmit";
    }
}
