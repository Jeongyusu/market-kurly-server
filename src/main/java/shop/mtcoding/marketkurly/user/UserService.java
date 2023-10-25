package shop.mtcoding.marketkurly.user;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly._core.errors.exception.Exception400;
import shop.mtcoding.marketkurly._core.errors.exception.Exception500;
import shop.mtcoding.marketkurly.user.UserRequest.LoginDTO;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserJPARepository userJPARepository;

    @Transactional
    public User 회원가입(UserRequest.UserJoinDTO userJoinDTO) {
        try {
            // 1. 아이디 중복 체크
            checkUserId(userJoinDTO.getUserId());

            // 2. 디비 저장
            User userPS = userJPARepository.save(userJoinDTO.toEntity());
            return userPS;
        } catch (Exception e) {
            throw new Exception500("unknown server error");
        }
    }

    private void checkUserId(String userId) {
        Optional<User> optUser = userJPARepository.findByUserId(userId);
        optUser.ifPresent(user -> {
            throw new Exception400("중복된 아이디입니다");
        });
    }

    public void 중복확인(String userLoginId) {
        checkUserId(userLoginId);

    }

    public UserInfo 로그인(LoginDTO loginDTO) {

        String encPassword = BCrypt.hashpw(loginDTO.getUserPassword(), BCrypt.gensalt());

        Optional<User> optUser = userJPARepository.findByUserId(loginDTO.getUserId());
        if (optUser.isEmpty()) {
            throw new Exception400("아이디가 일치하지 않습니다.");
        }
        User user = optUser.get();
        if (!user.getUserPassword().equals(encPassword)) {
            throw new Exception400("비밀번호가 일치하지 않습니다.");
        }
        return new UserInfo(user.getId(), user.getUserId());

    }

}