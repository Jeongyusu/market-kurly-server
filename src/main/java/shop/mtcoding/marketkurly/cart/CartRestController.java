package shop.mtcoding.marketkurly.cart;

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
import shop.mtcoding.marketkurly.cart.CartRequest.CartSaveDTO;
import shop.mtcoding.marketkurly.cart.CartRequest.SelectedCartListDTO;
import shop.mtcoding.marketkurly.cart.CartRequest.SelectedCartProductDTO;
import shop.mtcoding.marketkurly.usercoupon.UserCoupon;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CartRestController {

    private final CartService cartService;

    @GetMapping("/api/carts")
    public ResponseEntity<?> 장바구니목록조회(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.hasText(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
            throw new Exception401("인증되지 않은 회원입니다");
        }
        String token = authorizationHeader.substring("Bearer ".length());
        Integer userID = JwtTokenUtils.verify(token).getClaim("id").as(Integer.class);
        CartResponse.FindAllDTO findAllDTO = cartService.장바구니목록조회(userID);
        return ResponseEntity.ok().body(ApiUtils.success(findAllDTO));
    }

    @PostMapping("/api/carts/order")
    public ResponseEntity<?> 장바구니주문검증(@RequestBody SelectedCartListDTO selectedCartListDTO) {

        System.out.println("SelectedCartProductDTO 호출됨 : " + selectedCartListDTO);
        Integer sessionUserId = 1;
        cartService.장바구니주문검증(selectedCartListDTO, sessionUserId);
        return ResponseEntity.ok().body(ApiUtils.success(selectedCartListDTO));
    }

    @PostMapping("/api/carts/insert")
    public ResponseEntity<?> 장바구니담기(@RequestBody CartSaveDTO cartSaveDTO) {

        Integer sessionUserId = 1; // TODO << 나중에 SessionUserId로 바꿔야함
        cartService.장바구니담기(cartSaveDTO, sessionUserId);
        return ResponseEntity.ok().body(ApiUtils.success(cartSaveDTO));
    }

}
