package example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bmi")
public class CalcBMI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalcBMI() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//送信されたデータを受け取る(必ずString型、存在しなければnuLLが入る）
		String strHeight = request.getParameter("height");
		String strWeight = request.getParameter("weight");
		//計算結果格納用変数の初期化
		String judge = "";
		double bmi = 0.0;
		try {
			double height = Double.parseDouble(strHeight) / 100.0;
			double weight = Double.parseDouble(strWeight);
			bmi = weight / (height * height);
			if(bmi < 18.5) {
				judge = "低体重";
			} else if (bmi < 25.0) {
				judge = "普通体重";
			} else if (bmi < 30.0) {
				judge = "高度肥満";
			}
		} catch(Exception e) {
			e.printStackTrace();
			judge = "計算できませんでした。";
		}
		request.setAttribute("HEIGHT",strHeight);
		request.setAttribute("WEIGHT",strWeight);
		request.setAttribute("BMI", bmi);
		request.setAttribute("JUDGE", judge);
		request.getRequestDispatcher("bmi.jsp").forward(request, response);
	}
}
