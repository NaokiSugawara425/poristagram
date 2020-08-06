package poristagram;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");

		//LoginBeanのクラス変数を宣言
		LoginBean profile=null;

		//ArrayList<LoginBean> list = new ArrayList<LoginBean>();

		//文字列クラスの変数を宣言
		//String url=null;

		try{
			//渡されたデータをloginnameとpassword変数び格納

			HttpSession session=request.getSession();

		profile = (LoginBean)session.getAttribute("loginuser");


		}
		catch(Exception e){
			e.printStackTrace();
		}

		// コンテキストのインスタンス化
		ServletContext context=getServletContext();

		// リクエストディスパッチャーのインスタンス化
		// 引数にフォワード先のパスを設定
		RequestDispatcher rd=context.getRequestDispatcher("/jsp/home.jsp");
		// 転送する、(実行しているのはコントローラ)
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
