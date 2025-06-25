package kadai1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Kadai1Bean;


@WebServlet("/keisan")
public class Kadai1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Kadai1() {
        super();
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String strMoney = request.getParameter("money");
        String strRate = request.getParameter("rate");

        if (strMoney == null || strMoney.trim().isEmpty() ||
            strRate == null || strRate.trim().isEmpty()) {
            request.setAttribute("error", "金額または消費税率が未入力です。");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        try {
            int money = Integer.parseInt(strMoney);
            
            double rate;
            if ("1".equals(strRate)) {
                rate = 0.08;
            } else if ("2".equals(strRate)) {
                rate = 0.10;
            } else {
                request.setAttribute("error", "消費税率が不正な値です。");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }

            int tax = (int)(money * rate);
            int withTax = money + tax;

            Kadai1Bean data = new Kadai1Bean();
            data.setMoney(money);
            data.setRate(rate);
            data.setTax(tax);
            data.setWithTax(withTax);

            request.setAttribute("DATA", data);
            request.getRequestDispatcher("kadai1.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "金額は整数で入力してください。");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
		