package example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bmidata.BmiData;


@WebServlet("/bmi2")
public class CalcBMI2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalcBMI2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String strHeight = request.getParameter("height");
		String strWeight = request.getParameter("weight");
		String himando = "";
		double bmi = 0.0;
		
		try {
			double height = Double.parseDouble(strHeight) / 100.0;
			double weight = Double.parseDouble(strWeight);
			bmi = weight / (height * height);
			if(bmi < 18.5) {
				himando = "低体重";
			} else if (bmi < 25.0) {
				himando = "普通体重";
			} else if (bmi < 30.0) {
				himando = "高度肥満";
			}
		} catch(Exception e) {
			e.printStackTrace();
			himando = "計算できませんでした。";
		}
		
		BmiData data = new BmiData();
		data.strHeight = strHeight;
		data.strWeight = strWeight;
		data.bmi = bmi;
		data.himando = himando;
		
		request.setAttribute("DATA",data);
		request.getRequestDispatcher("bmi2.jsp").forward(request, response);
	}
}
