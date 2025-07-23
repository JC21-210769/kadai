package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form1")
public class Test1 extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
 public Test1() {
 super();
 }
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		 										throws ServletException, IOException {
 request.setCharacterEncoding("utf-8");
 response.setContentType("text/html; charset=utf-8");
 
 // 出力用のオブジェクト
 PrintWriter out = response.getWriter();
 
 // 送られたデータを取得する
 String name = request.getParameter("name");
 String address = request.getParameter("address");
 String phone = request.getParameter("phone");
 
 // 結果の表示
 out.println("<p>名前：" + name + "</p>");
 out.println("<p>住所：" + address + "</p>");
 out.println("<p>電話：" + phone + "</p>");
 }
 
}
