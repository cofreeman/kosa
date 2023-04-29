package week8.day4;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    BookMybatisDAO dao;

    @GetMapping("/book")
    public String getForm() {
        return "bookPage";
    }

    @GetMapping("/bookinfo/{b}")
    public String get(Model model, @PathVariable("b") String b,@RequestParam(value = "name", required = false) String name ) {
        List<BookDTO> list = null;
        if (Objects.equals(b, "b1")) {
            list = dao.getList();
        } else if (Objects.equals(b, "b2")) {
            list = dao.getListOrderByPrice();
        } else if (Objects.equals(b, "b3")) {
            list = dao.getListPriceOver20000();
        } else if (Objects.equals(b, "b4")) {
            list = dao.getListWebProgramming();
        } else if (Objects.equals(b, "b5")) {
            list = dao.getListDataBaseOrInfra();
        } else if (Objects.equals(b, "b6")) {
            list = dao.getListByWithinName(name);
        } else if (Objects.equals(b, "b7")) {
            List<Double> list2 = dao.averagePriceByKind();
            if (Objects.isNull(list2) || list2.size() == 0) {
                model.addAttribute("list", "<h3>추출된 데이터가 없네용<h3>");
            } else {
                model.addAttribute("list", list2);
            }
            return "bookPage";
        } else {
            return "bookPage";
        }
        if (Objects.isNull(list) || list.size() == 0) {
            model.addAttribute("list", "<h3>추출된 데이터가 없네용<h3>");
        } else {
            model.addAttribute("list", list);
        }
        return "bookPage";
    }
}
