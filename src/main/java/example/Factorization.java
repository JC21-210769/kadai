package example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/fact")
public class Factorization extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Factorization() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		// 送信されたデータを受け取る　（必ずString　型,　存在しなければnuLLが入る)
		String strValue = request.getParameter("value");
		
		// 素因数を格納する配列を準備
		//　※　後でStringクラスのjoinメソッドを使うためにString型にしている
		List<String> nums = new ArrayList<String>();
		
		// 結果格納用の変数
		String result = "";
		
		try {
			int n = Integer.parseInt(strValue);
			// nが2未満ならばNumberFormatException 例外をスローして計算できないメッセージ送る
			if(n<2) {
				throw new NumberFormatException();
			}
			
			for(int k=2; k<=Math.sqrt(n); k++) {
				while(n % k == 0) { //nがkで割り切れなくなるまで繰り返す
					nums.add(String.valueOf(k));
					n = n / k;
				}
			}
			
			//繰り返すを終えた時点でnが1でなければnを配列へ格納 (この時のnは素数)
			if(n != 1) {
				nums.add(String.valueOf(n));
			}
			//　配列に格納された結果を結合してresult に格納する。
			result = String.join(" x ", nums);
			
			//配列に1県しか格納されていなければ素数であることを設定する。
			if(nums.size() == 1) {
				result = "素数です";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "計算できませんでした";
		}
		// JSPへ送るデータを設定
		request.setAttribute("VALUE", strValue);
		request.setAttribute("RESULT", result);
		// JSPへ遷移
		request.getRequestDispatcher("fact.jsp").forward(request, response);
	}
}
				
	
