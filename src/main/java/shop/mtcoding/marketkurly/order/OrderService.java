package shop.mtcoding.marketkurly.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.marketkurly._core.errors.exception.Exception400;
import shop.mtcoding.marketkurly.address.Address;
import shop.mtcoding.marketkurly.address.AddressJPARepository;
import shop.mtcoding.marketkurly.cart.CartJPARepository;
import shop.mtcoding.marketkurly.user.User;
import shop.mtcoding.marketkurly.user.UserJPARepository;
import shop.mtcoding.marketkurly.usercoupon.UserCoupon;
import shop.mtcoding.marketkurly.usercoupon.UserCouponJPARepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderJPARepository orderJPARepository;
    private final UserJPARepository userJPARepository;
    private final AddressJPARepository addressJPARepository;
    private final UserCouponJPARepository userCouponJPARepository;
    private final CartJPARepository cartJPARepository;

    @Transactional
    public Integer 주문하기(Integer userId, OrderRequest.CreateOrderDTO requestDTO) {
        User user = userJPARepository.findById(userId)
                .orElseThrow(() -> new Exception400("존재하지 않는 회원입니다"));

        Address address = addressJPARepository.findById(requestDTO.getAddressId())
                .orElseThrow(() -> new Exception400("존재하지 않은 배송지 주소 id 입니다."));

        UserCoupon userCoupon = userCouponJPARepository.findById(requestDTO.getUserCouponId())
                .orElseThrow(() -> new Exception400("유저 쿠폰이 없습니다."));

        Order order = new Order(user, address, cartJPARepository.findByUser_Id(userId), requestDTO.getOrdererTel(), userCoupon, requestDTO.getPayment());
        return orderJPARepository.save(order).getId();
    }
}
