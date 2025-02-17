package org.example.servletsearchbook.controller;


import org.example.servletsearchbook.service.BookService;
import org.example.servletsearchbook.vo.BookVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/myServlet")
public class MyServlet extends HttpServlet {
    public MyServlet() {
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String keyword = req.getParameter("keyword");
        String price = req.getParameter("price");

        resp.setContentType("text/html; charset=utf-8");

        BookService service = new BookService();
        List<BookVO> bookList = service.getBooks(keyword, Integer.parseInt(price));

        // 2. 결과를 돌려주기 위한 데이터 통로를 하나 열어야 한다. 이 데이터 통로는 일반적으로 PrintWriter를 이용
        PrintWriter out = resp.getWriter();
        // 3. 이렇게 열린 통로로 데이터를 전송하면 된다
        out.println("<html>");
        out.println("<head></head>");
        out.println("<body>");
        out.println("<h1>검색결과 입니다.</h1>");
        out.println("<h3>검색키워드: " + keyword + "</h3>");
        out.println("<h3>검색가격: " + price + "</h3>");
        for (BookVO book : bookList) {
            out.println("<li><a href='bookDetail?bookIsbn=" + book.getBisbn() + "'>" + book.getBtitle() + ", " + book.getBprice() + "</li>");
            out.println("</br>");
        }
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

}
