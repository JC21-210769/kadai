package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form4")
public class Test4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Test4() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
													throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 出力用のオブジェクト
		PrintWriter out = response.getWriter();
		
		// 送られたデータを取得する
		String target = request.getParameter("target");
		String feedback = request.getParameter("feedback");
		
		// 結果の出力
		out.println("<p>対象：" + target + "</p>");
		out.println("<p>ご意見：" + feedback + "</p>");
	}
}
