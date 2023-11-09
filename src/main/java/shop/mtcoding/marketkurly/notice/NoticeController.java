package shop.mtcoding.marketkurly.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly.notice.NoticeRequest.NoticeSaveDTO;
import shop.mtcoding.marketkurly.notice.NoticeResponse.WebNoticeMainDTO;
import shop.mtcoding.marketkurly.user.User;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    private final HttpSession session;

    @GetMapping("/notice")
    public String 웹공지목록(HttpServletRequest request) {
        WebNoticeMainDTO dto = noticeService.웹공지목록();
        Boolean isAdmin = false;
        User user = (User) session.getAttribute("sessionUser");
        System.out.println("sessionUser role : " + user.getRole());
        request.setAttribute("webNoticeDTO", dto.getWebNoticeDTOs());
        request.setAttribute("isAdmin", isAdmin);
        return "noticeList";
    }

    @PostMapping("/admin/notice/save")
    public String 공지등록(NoticeSaveDTO noticeSaveDTO) {
        System.out.println("공지등록 호출");
        noticeService.공지등록(noticeSaveDTO);
        return "redirect:/notice";
    }

    @GetMapping("/notice/detail/{noticeId}")
    public String 공지상세보기(@PathVariable Integer noticeId, HttpServletRequest request) {
        Notice notice = noticeService.공지상세보기(noticeId);
        request.setAttribute("notice", notice);
        return "noticeDetail";
    }

    @GetMapping("/admin/notice")
    public String noticeWrite() {
        return "admin/noticeWrite";
    }
}
