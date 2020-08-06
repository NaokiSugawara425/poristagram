package rensyu03;

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
 * Servlet implementation class Rensyu03Controller
 */
@WebServlet("/Rensyu03Controller")
public class Rensyu03Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		// 例外処理
		try
		{
			// セッションオブジェクトを宣言
			HttpSession session = request.getSession();

			// アレイリストを宣言、格納するのはOrderg型
			ArrayList<Order> orderList = new ArrayList<Order>();

			// 渡されてきたninzu、seminarデータをいったん格納
			String[] number = request.getParameterValues("number");
			String[] syohin = request.getParameterValues("syohin");

			// 繰り返し文
			for (int i = 0; i < number.length; i++)
			{
				// 条件分岐
				if (Integer.parseInt(number[i]) != 0)
				{
					// 参加人数が0人でなければ処理
					// Orderクラスのインスタンス化
					Order order = new Order();

					// オブジェクトにセミナー名をセット
					order.setSyohin(syohin[i]);

					// オブジェクトに参加人数をセット
					order.setNumber(Integer.parseInt(number[i]));

					// アレイリストに追加
					orderList.add(order);
				}
			}

			// アレイリストに詰めなおしたデータを名前を付けてセッションに登録
			session.setAttribute("orderList", orderList);
		}
		catch(Exception ex)
		{
			// エラー表示
			ex.printStackTrace();
		}

		// コンテキストのインスタンス化
		ServletContext context = getServletContext();

		// リクエストディスパッチャーのインスタンス化
		// 引数にフォワード先のパスを設定
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/page2.jsp");

		// 転送する、(実行しているのはコントローラ)
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
