package shop.mtcoding.marketkurly.user;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.errors.exception.Exception400;
import shop.mtcoding.marketkurly._core.utils.JwtTokenUtils;
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
         Optional<User> optUser = userJPARepository.findByUserId(userJoinDTO.getUserId());
        optUser.ifPresent(user -> {
            throw new Exception400("중복된 아이디입니다");
        });

        // 2. 디비 저장
        User userPS = userJPARepository.save(userJoinDTO.toEntity());
        return userPS;

    }

   

    public void 중복확인(String userLoginId) {
         Optional<User> optUser = userJPARepository.findByUserId(userLoginId);
        optUser.ifPresent(user -> {
            throw new Exception400("중복된 아이디입니다");
        });
    }


    public String 로그인(LoginDTO loginDTO) {

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

        return JwtTokenUtils.create(user);
    }


    public String 아이디찾기(UserFindUsernameDTO requestDTO) {
        Optional<User> optUser = userJPARepository.findByUsernameAndUserEmail(requestDTO.getUsername(),
                requestDTO.getUserEmail());

        if (optUser.isPresent()) {
            return optUser.get().getUserId();
        } else {
            return null;
        }
    }

}
