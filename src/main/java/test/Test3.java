package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form3")
public class Test3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Test3() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
													throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 出力用のオブジェクト
		PrintWriter out = response.getWriter();
		
		// 送られたデータを取得する
		String gender = request.getParameter("gender");
		String[] hobys = request.getParameterValues("hoby");
		
		// 性別の設定（未入力の場合を考慮)
		String strGender = "";
		if (gender == null) {
			strGender = "指定されていません";
		} else {
			strGender = gender;
		}
		// 趣味の設定（未入力の場合を考慮）
		String strHobys = "";
		if (hobys == null) {
			strHobys = "指定されていません";
		} else {
			for(String hoby : hobys) {
				strHobys = strHobys + "<p>" + hoby + "</p>";
			}
		}
		// 結果の出力
		out.println("<p>性別：" + strGender + "</p>");
		out.println("<p>趣味：" + strHobys + "</p>");
	}
}