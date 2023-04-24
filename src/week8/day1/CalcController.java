package week8.day1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

    @PostMapping("/calccontroller")
    public ModelAndView postCalc(@RequestParam(value = "firstNum") Integer firstNum,
        @RequestParam(value = "secondNum") Integer secondNum,
        @RequestParam(value = "operator") String operator) {
        ModelAndView mav = new ModelAndView();
        int result;
        if (operator.equals("plus")) {
            result = firstNum + secondNum;
            mav.addObject("result", result);
        } else if (operator.equals("minus")) {
            result = firstNum - secondNum;
            mav.addObject("result", result);
        } else if (operator.equals("multiply")) {
            result = firstNum * secondNum;
            mav.addObject("result", result);
        } else if (operator.equals("divide")) {
            if (secondNum == 0) {
                mav.addObject("result", "나눗셈 연산 시 두 번째 숫자는 0일 수 없습니다!!");
                mav.setViewName("errorResult");
                return mav;
            }
            result = firstNum / secondNum;
            mav.addObject("result", result);
        }
        mav.setViewName("calcResult");
        return mav;
    }
}
