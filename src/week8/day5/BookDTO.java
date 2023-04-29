package week8.day5;

import com.example.springedu.util.BookUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    private String id;
    private String title;
    private Integer price;
    private String kind;

    @Override
    public String toString() {
        return "책 이름 =" + title + " 가격 = " + price + " 책 종류 = " + BookUtils.convertKind(kind);
    }
}
