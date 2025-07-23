package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form2")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public Test2() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
													throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 出力用のオブジェクト
		PrintWriter out = response.getWriter();
		// 送られたデータを取得する
		String strData1 = request.getParameter("data1");
		String strData2 = request.getParameter("data2");
		
		try {
			// データの変換
			int data1 = Integer.parseInt(strData1);
			int data2 = Integer.parseInt(strData2);
			// 計算いろいろ
			int sum = data1 + data2;
			int sub = data1 - data2;
			int mul = data1 * data2;
			int div = data1 / data2;
			int rem = data1 & data2;
			// 結果の表示
			out.println("<p>" + data1 + " + " + data2 + " = " + sum + "</p>");
			out.println("<p>" + data1 + " - " + data2 + " = " + sub + "</p>");
			out.println("<p>" + data1 + " * " + data2 + " = " + mul + "</p>");
			out.println("<p>" + data1 + " / " + data2 + " = " + div);
			out.println(" ・・・ " + rem + "</p>");
		} catch(Exception e) {
			// エラーがあった場合のトレースをコンソールに表示、メッセージをＷｅｂ画面に表示
			e.printStackTrace();
			out.println(e.getMessage());
		}
	}
}