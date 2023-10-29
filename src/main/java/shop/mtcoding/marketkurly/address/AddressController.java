package shop.mtcoding.marketkurly.address;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/api/addresses")
    public ResponseEntity<?> 모든주소찾기() {
        log.info("addressContoller 호출됨");
        Integer sessionUserId = 1;
        List<Address> addresses = addressService.모든주소찾기(sessionUserId);
        return ResponseEntity.ok().body(ApiUtils.success(addresses));
    }

}
