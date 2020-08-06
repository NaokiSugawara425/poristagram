package toi06_2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Toi06_2Controller
 */

// アノテーションで名前解決
@WebServlet("/toi06_2Controller")
public class Toi06_2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Toi06_2Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// Beanファイルの利用
		// 円に関するクラスを呼び出す
		Circle cir = new Circle();

		// リクエストから受け取ったデータの
		//　text01という名前のデータを文字列型変数に格納
		String str =request.getParameter("text01");

		// 実数の宣言
		double r = 0;

		// 受け取ったデータを実数型に変換
		r = Double.parseDouble(str);

		// 円クラスのオブジェクトに受け取ったデータをセット
		// ここでは半径の値をセットしている
		cir.setCir(r);

		// リクエストのデータに円クラスのオブジェクトの
		// データをcirという名前で記憶させる
		request.setAttribute("cir", cir);

		// コンテキストのインスタンス化
		ServletContext context = getServletContext();

		// リクエストディスパッチャーのインスタンス化
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/toi06_2response.jsp");

		// リクエストの内容をレスポンスに転送
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
