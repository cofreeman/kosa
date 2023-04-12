package core;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        if (Objects.equals(name, "")){
            RequestDispatcher rd =
                    req.getRequestDispatcher("/first.html");
            rd.forward(req,  resp);
        }
        String pwd = req.getParameter("pwd");
        if(Objects.equals(pwd, "")){
            resp.sendRedirect("https://www.daum.net/");
        }
        String room = req.getParameter("room");
        String[] options = req.getParameterValues("option");
        String option = "";
        if (options.length == 0) {
            option = "예약없음";
        } else {
            for (int i = 0; i < options.length; i++) {
                if (i == options.length - 1){
                    option = option + options[i];
                }else {
                    option = option + options[i] + ", ";
                }
            }
        }
        String datePicker = req.getParameter("datePicker");
        String[] date = datePicker.split("-");

        out.printf("<h1> %s님의 예약내용</h1><hr>", name);
        out.printf("<ul>");
        out.printf("<li>룸 : %s</li>", room);
        out.printf("<li>추가 요청사항 : %s</li>", option);
        out.printf("<li>예약날짜 : %s년 %s월 %s일</li>",date[0] ,date[1],date[2]);
        out.printf("</ul>");
        out.print("<a href='" + req.getHeader("referer") + "'>예약입력화면으로</a>");
        out.close();
    }
}
