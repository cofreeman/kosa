package week8.day3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudyPathController {

    @GetMapping("/study/{study}/thymeleaf")
    public String redirect(Model model, @PathVariable("study") int study){
        if (study == 1){
            return "redirect:https://abbo.tistory.com/56";
        } else if(study == 2){
            return "redirect:https://abbo.tistory.com/57";
        }else if(study == 3){
            return "redirect:https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html";
        }else if(study == 4){
            return "redirect:https://www.baeldung.com/dates-in-thymeleaf";
        }
        return "redirect:https://www.naver.com";
    }

}
