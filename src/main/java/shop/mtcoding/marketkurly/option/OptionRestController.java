package shop.mtcoding.marketkurly.option;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.option.OptionResponse.OptionSelectMainDTO;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OptionRestController {

    private final OptionService optionService;

    @GetMapping("/api/product/options")
    public ResponseEntity<?> 상품옵션목록() {
        System.out.println("option 컨트롤러 호출");
        OptionSelectMainDTO dto = optionService.상품옵션목록();
        return ResponseEntity.ok().body(ApiUtils.success(dto));
    }
}
