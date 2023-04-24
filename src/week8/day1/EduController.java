package week8.day1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EduController {

    @PostMapping("/educontroller")
    public ModelAndView getAvg(@RequestParam(value = "name", defaultValue = "없음") String name
        , @RequestParam(value = "avgScore", defaultValue = "없음") Integer avgScore) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", name);
        if (avgScore >= 90) {
            mav.setViewName("gradeA");
        } else if (avgScore >= 80) {
            mav.setViewName("gradeB");
        } else if (avgScore >= 70) {
            mav.setViewName("gradeC");
        } else {
            mav.setViewName("gradeD");
        }
        return mav;
    }
}
