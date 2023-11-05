package shop.mtcoding.marketkurly.waitingproduct;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shop.mtcoding.marketkurly.waitingoption.WaitingOptionResponse.WOptionListDTO;
import shop.mtcoding.marketkurly.waitingoption.WaitingOptionService;

@Slf4j
@RequiredArgsConstructor
@Controller
public class WaitingProductController {

    private final WaitingOptionService waitingOptionService;

    @GetMapping("/auth/product/waiting/{wProductId}")
    public String 대기상품디테일(@PathVariable Integer wProductId, HttpServletRequest request) {
        WOptionListDTO dto = waitingOptionService.대기상품디테일(wProductId);
        Boolean isAdmin = true;
        request.setAttribute("wProduct", dto.getWaitingProduct());
        request.setAttribute("wOptionList", dto.getWaitingOptionDTOs());
        request.setAttribute("isAdmin", isAdmin);
        return "seller/waitingProductDetail";
    }

}
