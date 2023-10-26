package shop.mtcoding.marketkurly.user;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.errors.exception.Exception400;
import shop.mtcoding.marketkurly.user.UserRequest.LoginDTO;
import shop.mtcoding.marketkurly.user.UserRequest.UserFindUsernameDTO;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserJPARepository userJPARepository;

    @Transactional
    public User 회원가입(UserRequest.UserJoinDTO userJoinDTO) {

        // 1. 아이디 중복 체크
        checkUserId(userJoinDTO.getUserId());

        // 2. 디비 저장
        User userPS = userJPARepository.save(userJoinDTO.toEntity());
        return userPS;

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
        System.out.println(encPassword);
        Optional<User> optUser = userJPARepository.findByUserId(loginDTO.getUserId());
        if (optUser.isEmpty()) {
            throw new Exception400("아이디가 일치하지 않습니다.");
        }
        User user = optUser.get();
        if (!BCrypt.checkpw(loginDTO.getUserPassword(), user.getUserPassword())) {
            throw new Exception400("비밀번호가 일치하지 않습니다.");
        }
        return new UserInfo(user.getId(), user.getUsername(), user.getRole().name());

    }

    public String 아이디찾기(UserFindUsernameDTO requestDTO) {
        Optional<User> optUser = userJPARepository.findByUsernameAndUserEmail(requestDTO.getUsername(),
                requestDTO.getUserEmail());

        if (optUser.isPresent()) {
            System.out.println("있다!!");
            return optUser.get().getUserId();
        } else {
            return null;
        }
    }

}
