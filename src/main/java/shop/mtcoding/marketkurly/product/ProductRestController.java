package shop.mtcoding.marketkurly.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ProductRestController {
    private final ProductService productService;

    @GetMapping("/api/bestProduct")
    public ResponseEntity<?> 베스트(@RequestParam int page){
        ProductResponse.ProductListDTO response = productService.베스트(page);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }

    @GetMapping("/api/finalSale")
    public ResponseEntity<?> 마감세일(@RequestParam int page, @RequestParam Integer categoryId){
        ProductResponse.ProductListDTO response = productService.마감세일(page, categoryId);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }

    @GetMapping("/api/newProdcut")
    public ResponseEntity<?> 신상품(@RequestParam int page){
        System.out.println("실행됨?");
        ProductResponse.ProductListDTO response = productService.신상품(page);
        return ResponseEntity.ok().body(ApiUtils.success(response));

    }

    @GetMapping("/api/productHome")
    public ResponseEntity<?> 컬리추천(@RequestParam int page) {
        ProductResponse.ProductListDTO response = productService.컬리추천(page);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }

    @GetMapping("/api/event")
    public  ResponseEntity<?> 금주혜택(){
        List<String> imageUrls = List.of(
                "https://github.com/KimHaYu/practice/assets/135561708/7a2478a3-1bfe-43c0-aeea-452944066cc0",
                "https://github.com/KimHaYu/practice/assets/135561708/606a9571-0142-4b90-b0cc-0018d25652a9",
                "https://github.com/KimHaYu/practice/assets/135561708/a5153a13-8064-42be-a6a9-b4c93f26a97a",
                "https://github.com/KimHaYu/practice/assets/135561708/056c0611-31a1-4787-880e-c21abf5a90a0"
        );
        return ResponseEntity.ok().body(ApiUtils.success(Map.of("imageUrls", imageUrls)));
    }
}