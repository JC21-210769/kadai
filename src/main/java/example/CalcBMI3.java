package example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BmiDataBean;

@WebServlet("/bmi3")
public class CalcBMI3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalcBMI3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String strHeight = (String) request.getParameter("height");
		String strWeight = (String) request.getParameter("weight");
		double bmi = 0.0;
		String himando = "";
		
		try {
			double height = Double.parseDouble(strHeight) / 100.0;
			double weight = Double.parseDouble(strWeight);
			bmi = weight / (height * height);
			if (bmi < 18.5) {
				himando = "低体重";
			} else if (bmi < 25.0) {
				himando = "普通体重";
			} else if (bmi < 30.0) {
				himando = "肥満";
			} else {
				himando = "高度肥満";
			}
		} catch (Exception e) {
			e.printStackTrace();
			himando = "計算できませんでした。";
		}
		
		BmiDataBean data = new BmiDataBean();
		data.setStrHeight(strHeight);
		data.setStrWeight(strWeight);
		data.setBmi(bmi);
		data.setHimando(himando);
		request.setAttribute("DATA", data);
		request.getRequestDispatcher("bmi3.jsp").forward(request, response);
	}
}

