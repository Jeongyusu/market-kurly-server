package shop.mtcoding.marketkurly;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import shop.mtcoding.marketkurly._core.vo.MyPath;
import shop.mtcoding.marketkurly.category.Category;
import shop.mtcoding.marketkurly.category.CategoryService;
import shop.mtcoding.marketkurly.product.Product;

@Controller
@RequiredArgsConstructor
public class testController {

    private final CategoryService categoryService;

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

    // productController에 있음
    // @GetMapping("/seller/product")
    // public String sellerProduct() {
    // System.out.println("테스트 : sellerProduct 호출");
    // return "seller/sellerProduct";
    // }

    @GetMapping("/seller/product/submit")
    public String sellerProductSubmit(HttpServletRequest request) {
        List<Category> categorys = categoryService.모든카테고리찾기();
        request.setAttribute("categorys", categorys);
        return "seller/sellerProductSubmit";
    }

    @GetMapping("/seller/product/detail")
    public String sellerProductDetail(HttpServletRequest request) {
        return "seller/ProductDetail";
    }

}
