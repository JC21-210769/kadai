package example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/zei")
public class ZeiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ZeiServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 	
													throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		// 送信されたデータを受け取る (必ずString型,存在しなければnuLLが入る)
		String strKingaku = request.getParameter("kingaku");
		String strZeiritsu = request.getParameter("zeiritsu");
		
		try {
			int kingaku = Integer.parseInt(strKingaku);
			int zeiritsu = Integer.parseInt(strZeiritsu);
			int zeikin = (int)(kingaku * (double)zeiritsu / 100.0);
			request.setAttribute("KINGAKU", kingaku);
			request.setAttribute("ZEIRITSU",zeiritsu);
			request.setAttribute("ZEIKIN", zeikin);
			request.setAttribute("ZEIKOMI", (kingaku+zeikin));
			request.getRequestDispatcher("zei.jsp").forward(request, response);
			return;
		} catch(Exception e) {
			e.printStackTrace();
			response.getWriter().println("error");
		}
	}
}
