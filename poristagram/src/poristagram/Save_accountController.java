package poristagram;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Save_accountController
 */
@WebServlet("/Save_accountController")
public class Save_accountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		//LoginBeanのクラス変数を宣言
		LoginBean loginbean=null;

		// アレイリストを宣言
		loginbean = new LoginBean();

		//文字列クラスの変数を宣言
		String url=null;
		String u_name = null;
		try{
			//渡されたデータをloginnameとpassword変数び格納
			u_name = request.getParameter("u_name");
			String u_pass = request.getParameter("u_pass");

			//条件分岐
			if(u_name=="" || u_pass=="")
			{
				//変数の中身のどちらか空だったら失敗ページへ
				url="/jsp/new_account.jsp";
			}
			else
			{
				//SQLに登録
				loginbean.saveAccount(u_name, u_pass);

				//登録完了画面へとばす
				url="/jsp/save_account.jsp";
			}
		}

		catch(Exception e){
			e.printStackTrace();
		}

		// コンテキストのインスタンス化
		ServletContext context=getServletContext();

		// リクエストディスパッチャーのインスタンス化
		// 引数にフォワード先のパスを設定
		RequestDispatcher rd=context.getRequestDispatcher(url);
		// 転送する、(実行しているのはコントローラ)
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
