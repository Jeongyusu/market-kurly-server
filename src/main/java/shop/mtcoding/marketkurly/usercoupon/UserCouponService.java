package shop.mtcoding.marketkurly.usercoupon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCouponService {

    private final UserCouponJPARepository userCouponJPARepository;

    public UserCouponResponse.CouponListDTO 내쿠폰목록조회(Integer userPk) {
        return new UserCouponResponse.CouponListDTO(userCouponJPARepository.findCouponByUserId(userPk));
    }
}
