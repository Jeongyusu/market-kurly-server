package shop.mtcoding.marketkurly.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserId(String userId);

}
