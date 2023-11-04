package shop.mtcoding.marketkurly.notice;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.marketkurly.notice.NoticeResponse.NoticeMainDTO;
import shop.mtcoding.marketkurly.notice.NoticeResponse.WebNoticeMainDTO;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeJPARepository noticeJPARepository;

    public NoticeMainDTO 공지목록() {
        List<Notice> notices = noticeJPARepository.findAll();
        return new NoticeResponse.NoticeMainDTO(notices);
    }

    public WebNoticeMainDTO 웹공지목록() {
        List<Notice> notices = noticeJPARepository.findAll();
        return new NoticeResponse.WebNoticeMainDTO(notices);
    }
}