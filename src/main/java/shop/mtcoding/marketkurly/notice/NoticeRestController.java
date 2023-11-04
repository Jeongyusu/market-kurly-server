package shop.mtcoding.marketkurly.notice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly._core.utils.ApiUtils;
import shop.mtcoding.marketkurly.notice.NoticeResponse.NoticeMainDTO;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NoticeRestController {

    private final NoticeService noticeService;

    @GetMapping("/api/test/notices")
    public ResponseEntity<?> 공지목록() {
        System.out.println("option 컨트롤러 호출");
        NoticeMainDTO dto = noticeService.공지목록();
        return ResponseEntity.ok().body(ApiUtils.success(dto));
    }
}
