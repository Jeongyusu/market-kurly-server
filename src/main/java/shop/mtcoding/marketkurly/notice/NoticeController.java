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

    private final HttpServletRequest request;

    @GetMapping("/notice")
    public String 웹공지목록() {
        WebNoticeMainDTO dto = noticeService.웹공지목록();

        User user = (User) session.getAttribute("sessionUser");
        if (user.getRole().toString().equals("ADMIN")) {
            request.setAttribute("isAdmin", true);
        }
        if (user.getRole().toString().equals("SELLER")) {
            request.setAttribute("isSeller", true);
        }

        System.out.println("sessionUser id : " + user.getId());
        System.out.println("sessionUser email : " + user.getUserEmail());
        System.out.println("sessionUser role : " + user.getRole());
        System.out.println("sessionUser DTO전 : " + dto.getWebNoticeDTOs().get(0).getNoticeTypeAndTitle());
        System.out.println("sessionUser DTO전 isAdmin : " + request.getAttribute("isAdmin"));
        System.out.println("sessionUser DTO전 isSeller : " + request.getAttribute("isSeller"));
        System.out.println("sessionUser DTO전 : " + dto.getWebNoticeDTOs().get(0).getNoticeTypeAndTitle());
        request.setAttribute("webNoticeDTO", dto.getWebNoticeDTOs());
        System.out.println("sessionUser DTO 후 : " + dto.getWebNoticeDTOs().get(0).getNoticeTypeAndTitle());
        return "noticeList";
    }

    @PostMapping("/admin/notice/save")
    public String 공지등록(NoticeSaveDTO noticeSaveDTO) {

        User user = (User) session.getAttribute("sessionUser");
        if (user.getRole().toString().equals("ADMIN")) {
            request.setAttribute("isSeller", true);

        }
        if (user.getRole().toString().equals("SELLER")) {
            request.setAttribute("isAdmin", true);
        }

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
