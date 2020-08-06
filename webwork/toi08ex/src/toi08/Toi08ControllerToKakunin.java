package toi08;

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
 * Servlet implementation class Toi08ControllerToKakunin
 */
@WebServlet("/Toi08ControllerToKakunin")
public class Toi08ControllerToKakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// アレイリストを宣言、格納するのはOrderg型
	ArrayList<Order> orderListTotal = new ArrayList<Order>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		// 例外処理
		try
		{
			// セッションオブジェクトを宣言
			HttpSession session = request.getSession();

			// アレイリストを宣言、格納するのはOrderg型
			ArrayList<Order> orderListTmp = new ArrayList<Order>();

			// 渡されてきたデータをいったん格納
			String[] syohin = request.getParameterValues("syohin");
			String[] price = request.getParameterValues("price");
			String[] caseNum = request.getParameterValues("caseNum");

			// 繰り返し文
			for (int i = 0; i < caseNum.length; i++)
			{
				// 条件分岐
				if (Integer.parseInt(caseNum[i]) != 0)
				{
					// 購入ケース数が0人でなければ処理
					// Orderクラスのインスタンス化
					Order order = new Order();

					// オブジェクトに商品名をセット
					order.setSyohin(syohin[i]);

					// オブジェクトに価格をセット
					order.setPrice(Integer.parseInt(price[i]));

					// オブジェクトにケース数をセット
					order.setCaseNum(Integer.parseInt(caseNum[i]));

					// アレイリストに追加
					orderListTmp.add(order);
					orderListTotal.add(order);
				}
			}

			// アレイリストに詰めなおしたデータを名前を付けてセッションに登録
			request.setAttribute("orderListTmp", orderListTmp);
			session.setAttribute("orderListTotal", orderListTotal);
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
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/kakunin.jsp");

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
