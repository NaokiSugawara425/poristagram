package loginapp_2;

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


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// LoginBeanクラス変数を宣言
		LoginBean loginBean = null;

		// アレイリストを宣言
		ArrayList<LoginBean> list = new ArrayList<LoginBean>();

		// 文字列クラスの変数を宣言
		String url = null;

		try
		{
			//渡されたデータをloginNameとpassword変数に格納
			String loginName = request.getParameter("loginName");
			String password = request.getParameter("password");

			// 条件分岐
			if (loginName == "" || password == "")
			{
				// 変数の中身のどちらかが空だったら
				// ログイン失敗ページへ誘導
				url = "/jsp/fail.jsp";
			}
			else
			{
				// ユーザ名をパスワードの認証、
				// LoginBeanクラスのloginメソッドの呼び出し
				list = LoginBean.login();

				// listに取り出したデータすべてに対して認証確認
				for (int i = 0; i < list.size(); i++)
				{
					// listからオブジェクトを取り出す
					loginBean = (LoginBean)list.get(i);

					// 認証成功の場合はログイン成功画面へ遷移
					// 認証失敗の場合はログイン失敗画面へ遷移
					if (loginBean.getLoginName().equals(loginName)
						&& loginBean.getPassword().equals(password))
					{
						// urlをセット
						url = "/jsp/success.jsp";

						// セッションスコープをインスタンス化
						HttpSession session = request.getSession();

						// セッションの"login"というデータをtrueに
						session.setAttribute("login", true);

						// セッションにデータを付与
						session.setAttribute("loginName", loginName);
					}
				}

				// 認証確認でurlがセットされなかった場合は
				// 認証失敗ページをセット
				if (url == null)
				{
					// urlをセット
					url = "/jsp/fail.jsp";
				 }
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		// コンテキストのインスタンス化
		ServletContext context = getServletContext();


		// リクエストディスパッチャーのインスタンス化
		// 引数にフォワード先のパスを設定
		RequestDispatcher rd = context.getRequestDispatcher(url);

		// 転送する、(実行しているのはコントローラ)
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
