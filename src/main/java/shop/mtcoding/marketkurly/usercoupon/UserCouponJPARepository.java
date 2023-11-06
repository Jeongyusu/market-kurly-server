package shop.mtcoding.marketkurly.usercoupon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.mtcoding.marketkurly.coupon.Coupon;

import java.util.List;

public interface UserCouponJPARepository extends JpaRepository<UserCoupon, Integer> {

    @Query("select uc.coupon from UserCoupon uc where uc.user.id = :userPk")
    List<Coupon> findCouponByUserId(Integer userPk);
}
