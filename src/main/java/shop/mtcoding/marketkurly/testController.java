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
import shop.mtcoding.marketkurly.waitingproduct.WaitingProduct;
import shop.mtcoding.marketkurly.waitingproduct.WaitingProductService;

@Controller
@RequiredArgsConstructor
public class testController {

    private final CategoryService categoryService;
    private final WaitingProductService waitingProductService;

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

    @GetMapping("/admin")
    public String 대기상품전체(HttpServletRequest request) {
        System.out.println("테스트 : adminMain 호출");
        List<WaitingProduct> waitingproducts = waitingProductService.대기상품전체();
        Boolean isAdmin = true;
        request.setAttribute("allWaitingProduct", waitingproducts);
        request.setAttribute("isAdmin", isAdmin);
        return "admin/adminMain";
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
