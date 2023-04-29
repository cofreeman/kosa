package week8.day5;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookMybatisDAO {

    @Autowired
    SqlSession session;

    public List<BookDTO> getList() {
        String statement = "lab1.exam1";
        return session.selectList(statement);
    }

    public List<BookDTO> getListOrderByPrice() {
        String statement = "lab1.exam2";
        return session.selectList(statement);
    }

    public List<BookDTO> getListPriceOver20000() {
        String statement = "lab1.exam3";
        return session.selectList(statement);
    }

    public List<BookDTO> getListWebProgramming() {
        String statement = "lab1.exam4";
        return session.selectList(statement);
    }

    public List<BookDTO> getListDataBaseOrInfra() {
        String statement = "lab1.exam5";
        return session.selectList(statement);
    }

    public List<BookDTO> getListByWithinName(String name) {
        String statement = "lab1.exam6";
        return session.selectList(statement,name);
    }

    public List<Double> averagePriceByKind() {
        String statement = "lab1.exam7";
        return session.selectList(statement);
    }

    public boolean insertBook(BookDTO bookDTO) {
        boolean result = true;
        String statement = "lab1.exam8";
        if(session.insert(statement, bookDTO) != 1)
            result = false;
        return result;
    }
}
