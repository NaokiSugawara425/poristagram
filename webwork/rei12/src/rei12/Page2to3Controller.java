package rei12;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Page2to3Controller
 */
@WebServlet("/Page2to3Controller")
public class Page2to3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// セッションオブジェクトを宣言
		HttpSession session = request.getSession();

		// ArrayListの宣言
		// セッションに保存されているArrayListを取り出している
		// 警告無視してokのアノテーション
		@SuppressWarnings("unchecked")
		ArrayList<Order> orderList = (ArrayList<Order>)session.getAttribute("orderList");

		// オーダークラスのメソッド呼び出し
		// 引数には確定したデータ
		// データをデータベースに保存するメソッド
		Order.insertData(orderList);

		// コンテキストのインスタンス化
		ServletContext context = getServletContext();

		// リクエストディスパッチャーのインスタンス化
		// 引数に転送先のパスを設定
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/page3.jsp");

		// 転送する
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
