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
import shop.mtcoding.marketkurly.user.UserRequest.myPageDTO;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserJPARepository userJPARepository;

    @Transactional
    public void 회원가입(UserRequest.UserJoinDTO userJoinDTO) {

        System.out.println("서비스 진입가능?");
        System.out.println("userId에는 머가있지? " + userJoinDTO.getUserId());
        // 1. 아이디 중복 체크
        User optUser = userJPARepository.findByUserId(userJoinDTO.getUserId());
        if (optUser != null) {
            throw new Exception400("중복된 아이디입니다.");
        }

        String encPassword = BCrypt.hashpw(userJoinDTO.getUserPassword(), BCrypt.gensalt());
        System.out.println("회원가입 1 ");
        userJoinDTO.setUserPassword(encPassword);
        // 2. 디비 저장
        User userPS = userJPARepository.save(userJoinDTO.toEntity());
        System.out.println("회원가입 2 ");

    }

    public void 중복확인(String userLoginId) {
        User optUser = userJPARepository.findByUserId(userLoginId);
        if (optUser != null) {
            throw new Exception400("중복된 아이디입니다.");
        }
    }

    public String 로그인(LoginDTO loginDTO) {
        String encPassword = BCrypt.hashpw(loginDTO.getUserPassword(), BCrypt.gensalt());
        System.out.println(encPassword);
        User optUser = userJPARepository.findByUserId(loginDTO.getUserId());
        if (optUser.getUserId() == loginDTO.getUserId()) {
            throw new Exception400("아이디가 일치하지 않습니다.");
        }
        User user = optUser;
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

    public UserResponse.LoginDTO 로그인정보조회(String userId) {
        User userDTO = userJPARepository.findByUserId(userId);
        return new UserResponse.LoginDTO(userDTO);
    }

    public User 마이페이지(myPageDTO myPageDTO) {
        return null;
    }

}