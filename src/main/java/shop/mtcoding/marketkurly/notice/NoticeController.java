package shop.mtcoding.marketkurly.notice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly.notice.NoticeResponse.WebNoticeMainDTO;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/notice")
    public String 웹공지목록(HttpServletRequest request) {
        WebNoticeMainDTO dto = noticeService.웹공지목록();
        Boolean isAdmin = true;
        request.setAttribute("webNoticeDTO", dto.getWebNoticeDTOs());
        request.setAttribute("isAdmin", isAdmin);
        return "noticeList";
    }
}
