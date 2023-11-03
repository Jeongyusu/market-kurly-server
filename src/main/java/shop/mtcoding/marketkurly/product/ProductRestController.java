package shop.mtcoding.marketkurly.product;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductService productService;

    @GetMapping("/api/products/{productId}")
    public ResponseEntity<?> 제품상세조회(@PathVariable Integer productId) {
        ProductResponse.ProductDetailDTO productDetailDTO = productService.제품상세페이지(productId);
        return ResponseEntity.ok().body(ApiUtils.success(productDetailDTO));
    }

    @GetMapping("/api/products/finalsale")
    public ResponseEntity<?> 마감세일(@RequestParam int page) {
        ProductResponse.ProductListDTO response = productService.마감세일(page);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }

    @GetMapping("/api/products/bestproduct")
    public ResponseEntity<?> 베스트(@RequestParam int page) {
        ProductResponse.ProductListDTO response = productService.베스트(page);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }

    @GetMapping("/api/products/category")
    public ResponseEntity<?> 카테고리(@RequestParam int page, @RequestParam Integer categoryId) {
        ProductResponse.ProductListDTO response = productService.카테고리필터링(page, categoryId);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }

    @GetMapping("/api/products/newproduct")
    public ResponseEntity<?> 신상품(@RequestParam int page) {
        ProductResponse.ProductListDTO response = productService.신상품(page);
        return ResponseEntity.ok().body(ApiUtils.success(response));

    }

    @GetMapping("/api/products/home")
    public ResponseEntity<?> 컬리추천(@RequestParam int page) {
        ProductResponse.ProductListDTO response = productService.컬리추천(page);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }

    @GetMapping("/api/products/event")
    public ResponseEntity<?> 금주혜택() {
        List<String> imageUrls = List.of(
                "http://localhost:8080/images/list/Screenshot_1.jpg",
                "http://localhost:8080/images/list/Screenshot_2.jpg",
                "http://localhost:8080/images/list/Screenshot_3.jpg",
                "http://localhost:8080/images/list/Screenshot_4.jpg");
        return ResponseEntity.ok().body(ApiUtils.success(Map.of("imageUrls", imageUrls)));
    }

}