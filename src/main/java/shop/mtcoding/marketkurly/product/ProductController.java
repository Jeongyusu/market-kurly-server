package shop.mtcoding.marketkurly.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
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
        request.setAttribute("sellerProductList", dto.getSellerProductDTOs());
        return "seller/sellerProduct";
    }

}