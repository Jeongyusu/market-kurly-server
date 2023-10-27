package shop.mtcoding.marketkurly.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJPARepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserId(String userId);

    Optional<User> findByUsernameAndUserEmail(@Param("username") String username, @Param("userEmail") String userEmail);

}
