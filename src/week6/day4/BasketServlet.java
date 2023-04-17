//package week6.day4;
//
//import org.json.simple.JSONObject;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet("/basket")
//public class BasketServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 선택한 상품 ID를 가져옴
//        String productId = req.getParameter("product-id");
//
//        // Session 객체에서 선택한 상품 정보를 가져옴
//        HttpSession session = req.getSession();
//        if (productId == null){
//            session.removeAttribute("basket");
//            resp.setContentType("application/json");
//            resp.setCharacterEncoding("UTF-8");
//            PrintWriter out = resp.getWriter();
//            String noContentJSON = "{\"msg\": \"상품이 모두 삭제되었습니다.\"}";
//            out.print(noContentJSON);
//            out.flush();
//            out.close();
//            return;
//        }
//        int[] basket = (int[]) session.getAttribute("basket");
//        if (basket == null) {
//            basket = new int[10];
//            session.setAttribute("basket",basket);
//        }
//        // 선택한 상품 정보를 업데이트함
//        int index = Integer.parseInt(productId.substring(1)) - 1;
//        basket[index]++;
//
//        // JSON 형식으로 응답함
//        Map<String, Integer> data = new HashMap<>();
//        for (int i = 0; i < basket.length; i++) {
//            if (basket[i] > 0) {
//                String id = String.format("p%03d", i + 1);
//                data.put(id, basket[i]);
//            }
//        }
//        JSONObject jsonObject = new JSONObject(data);
//        String jsonString = jsonObject.toJSONString();
//
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        PrintWriter out = resp.getWriter();
//        out.print(jsonString);
//        out.flush();
//        out.close();
//
//    }
//}
