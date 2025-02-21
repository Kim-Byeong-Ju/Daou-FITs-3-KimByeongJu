<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  HttpSession sessionObj = request.getSession(false);
  if (sessionObj != null) {
    session.invalidate(); // 세션 무효화
  }

  // 로그인 페이지로 리다이렉트
  response.sendRedirect("index.jsp");
%>
