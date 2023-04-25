package week8.day2;

import java.util.Objects;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LottoController {

    @GetMapping("/lotto")
    public String getLotto(HttpSession session, Model model, @RequestParam("lottoNum") Integer lottoNum) {
        LottoDTO lottoDTO = new LottoDTO();
        lottoDTO.setLottoNum(lottoNum);
        Object sessionCount = session.getAttribute("count");
        // 응모 횟수를 1 늘린다.
        // 로또 당첨번호 생성
        if (Objects.isNull(session.getAttribute("winNum"))) {
            Random random = new Random();
            Integer winNum = random.nextInt(6) + 1;
            session.setAttribute("winNum", winNum);
        }
        // 응모 횟수 객체 세션에 추가
        if (Objects.isNull(sessionCount)) {
            session.setAttribute("count", 0);
        }
        // 응모 횟수 3회 초과일 경우
        if ((Integer) session.getAttribute("count") > 3) {
            lottoDTO.setResult("로또 응모는 낙첨된 경우에 한하여 3번 까지만 가능합니다.<br> 브라우저를 재기동한 후에 응모해 주세요.");
            lottoDTO.setImgName("images/cloud.png");
            model.addAttribute("result", lottoDTO);
            return "lottoView";
        }
        // 당첨에 실패했을 경우
        Integer winNum = (Integer) session.getAttribute("winNum");
        System.out.println(winNum);
        System.out.println(lottoNum);
        if (winNum != lottoNum) {
            lottoDTO.setResult("아쉽네요 .. 다음기회를!!");
            lottoDTO.setImgName("images/rain.png");
            session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
        } else {
            lottoDTO.setResult("추카추카!!");
            lottoDTO.setImgName("images/sun.png");
            session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
        }
        model.addAttribute("result", lottoDTO);
        return "lottoView";
    }

}
