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

@WebServlet(value = "/bookDetail")
public class BookDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIsbn = req.getParameter("bookIsbn");

        BookService service = new BookService();
        BookVO book = service.getBook(bookIsbn);
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head></head>");
        out.println("<body>");
        out.println("<h1>책 세부정보</h1>");
        out.println("<h3>제목: " + book.getBtitle() + "</h3>");
        out.println("<h3>가격: " + book.getBprice() + "</h3>");
        out.println("<h3>저자: " + book.getBauthor() + "</h3>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();

    }
}
