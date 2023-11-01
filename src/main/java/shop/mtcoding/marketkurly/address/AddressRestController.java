package shop.mtcoding.marketkurly.address;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.address.AddressRequest.AddressSaveReqDTO;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AddressRestController {

    private final AddressService addressService;

    @GetMapping("/api/addresses")
    public ResponseEntity<?> 모든주소찾기() {
        log.info("addressContoller 모든주소찾기 호출됨");
        Integer sessionUserId = 1;
        List<Address> addresses = addressService.모든주소찾기(sessionUserId);
        return ResponseEntity.ok().body(ApiUtils.success(addresses));
    }

    @PostMapping("/api/addresses/save")
    public ResponseEntity<?> 배송지저장(@RequestBody AddressSaveReqDTO addressSaveReqDTO) {
        log.info("addressContoller 배송지저장 호출됨");
        Address result = addressService.배송지저장(addressSaveReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success(result));
    }
}
