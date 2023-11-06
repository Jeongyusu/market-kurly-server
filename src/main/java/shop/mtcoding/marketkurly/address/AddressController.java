package shop.mtcoding.marketkurly.address;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.errors.exception.Exception401;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly._core.utils.JwtTokenUtils;
import shop.mtcoding.marketkurly.address.AddressRequest.AddressSaveReqDTO;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/api/addresses")
    public ResponseEntity<?> 모든주소찾기(HttpServletRequest request) {
        log.info("addressContoller 모든주소찾기 호출됨");
        // userPk 1로 고정되어 있던거 수정했습니다.
        // 요청 헤더에 token으로 유저 pk 꺼냅니다.
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.hasText(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
            throw new Exception401("인증되지 않은 회원입니다");
        }
        String token = authorizationHeader.substring("Bearer ".length());
        Integer userPk = JwtTokenUtils.verify(token).getClaim("id").as(Integer.class);
        List<Address> addresses = addressService.모든주소찾기(userPk);
        return ResponseEntity.ok().body(ApiUtils.success(addresses));
    }

    @PostMapping("/api/test/save/address")
    public ResponseEntity<?> 배송지저장(@RequestBody AddressSaveReqDTO addressSaveReqDTO) {
        log.info("addressContoller 배송지저장 호출됨");
        Address result = addressService.배송지저장(addressSaveReqDTO);
        return ResponseEntity.ok().body(ApiUtils.success(result));
    }

    @GetMapping("/api/addresses/my/default")
    public ResponseEntity<?> 기본배송지조회(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.hasText(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
            throw new Exception401("인증되지 않은 회원입니다");
        }
        String token = authorizationHeader.substring("Bearer ".length());
        Integer userPk = JwtTokenUtils.verify(token).getClaim("id").as(Integer.class);
        return ResponseEntity.ok().body(ApiUtils.success(addressService.기본배송지조회(userPk)));
    }

}
