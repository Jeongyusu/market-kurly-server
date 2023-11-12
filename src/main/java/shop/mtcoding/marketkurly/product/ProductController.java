package shop.mtcoding.marketkurly.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly.option.OptionService;
import shop.mtcoding.marketkurly.orderedoption.OrderOptionJAPRepository;
import shop.mtcoding.marketkurly.orderedoption.OrderedOptionResponse.OrderedOptionListDTO;
import shop.mtcoding.marketkurly.orderedoption.OrderedOptionService;
import shop.mtcoding.marketkurly.product.ProductResponse.ProductDetailListDTO;
import shop.mtcoding.marketkurly.product.ProductResponse.SellerProductListDTO;
import shop.mtcoding.marketkurly.user.User;
import shop.mtcoding.marketkurly.waitingoption.WaitingOptionResponse.WOptionListDTO;
import shop.mtcoding.marketkurly.waitingproduct.WaitingProductResponse.WaitingProductListDTO;
import shop.mtcoding.marketkurly.waitingproduct.WaitingProductService;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;
    private final OptionService optionService;
    private final WaitingProductService waitingProductService;
    private final HttpSession session;
    private final OrderedOptionService orderedOptionService;

    @GetMapping("/seller/product")
    public String 판매상품메인(HttpServletRequest request) {
        System.out.println("판매 상품 메인 컨트롤러");

        User user = (User) session.getAttribute("sessionUser");
        log.info("sessionUser number : " + user.getId());

        Boolean isAdmin = false;
        Boolean isSeller = false;
        if (user.getRole().toString().equals("ADMIN")) {
            isAdmin = true;
        }
        if (user.getRole().toString().equals("SELLER")) {
            isSeller = true;
        }

        SellerProductListDTO dto1 = productService.판매상품목록(user.getId());
        WaitingProductListDTO dto2 = waitingProductService.대기상품목록(user.getId());
        request.setAttribute("sellerProductList", dto1.getSellerProductDTOs());
        request.setAttribute("waitingProductList", dto2.getWaitingProductDTOs());
        request.setAttribute("isAdmin", isAdmin);
        request.setAttribute("isSeller", isSeller);
        return "seller/sellerProduct";
    }

    @GetMapping("/seller/product/{productId}")
    public String 판매상품디테일(@PathVariable Integer productId, HttpServletRequest request) {
        System.out.println("판매 상품 디테일 컨트롤러");

        ProductDetailListDTO dto = optionService.대기상품디테일(productId);
        request.setAttribute("product", dto.getProduct());
        request.setAttribute("optionList", dto.getOptionDTOs());
        return "seller/productDetail";
    }

    @GetMapping("/seller")
    public String 판매관리(HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");
        log.info("sessionUser number : " + user.getId());
        Boolean isAdmin = false;
        Boolean isSeller = false;
        if (user.getRole().toString().equals("ADMIN")) {
            isAdmin = true;
        }
        if (user.getRole().toString().equals("SELLER")) {
            isSeller = true;
        }
        request.setAttribute("isAdmin", isAdmin);
        request.setAttribute("isSeller", isSeller);

        OrderedOptionListDTO dto = orderedOptionService.판매된상품찾기(user.getId());
        request.setAttribute("orders", dto.getOrderedOptionDTOs());
        return "seller/sellerMain";
    }
}