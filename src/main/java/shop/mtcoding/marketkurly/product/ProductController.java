package shop.mtcoding.marketkurly.product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly.product.ProductResponse.SellerProductListDTO;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("/seller/product")
    public String 판매상품목록(HttpServletRequest request) {
        Integer userId = 7;
        SellerProductListDTO dto = productService.판매상품목록(userId);
        System.out.println("판매 상품 목록 컨트롤러");
        request.setAttribute("sellerProductList", dto.getSellerProductDTOs());
        return "seller/sellerProduct";
    }

}