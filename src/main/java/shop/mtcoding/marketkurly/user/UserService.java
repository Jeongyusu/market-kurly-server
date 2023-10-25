package shop.mtcoding.marketkurly.user;

import java.util.Optional;

import javax.management.RuntimeErrorException;

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
    public void 회원가입(UserRequest.UserJoinDTO userJoinDTO) {
        try {
            userJPARepository.save(userJoinDTO.toEntity());
        } catch (Exception e) {
            throw new Exception500("unknown server error");
        }

        checkUserId(userJoinDTO.getUserId());
        User user = User.builder()
                .userId(userJoinDTO.getUserId())
                .userPassword(userJoinDTO.getUserPassword())
                .username(userJoinDTO.getUsername())
                .userEmail(userJoinDTO.getUserEmail())
                .userBirth(userJoinDTO.getUserBirth())
                .userGender(userJoinDTO.getUserGender())
                .build();
        userJPARepository.save(user);
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
        Optional<User> optUser = userJPARepository.findByUserId(loginDTO.getUserId());
        if (optUser.isEmpty()) {
            throw new Exception400("아이디가 일치하지 않습니다.");
        }
        User user = optUser.get();
        if (!user.getUserPassword().equals(loginDTO.getUserPassword())) {
            throw new Exception400("비밀번호가 일치하지 않습니다.");
        }
        return new UserInfo(user.getId(), user.getUserId());

    }

}