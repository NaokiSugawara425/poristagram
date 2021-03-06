package poristagram;

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
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");

		//LoginBeanのクラス変数を宣言
		LoginBean loginbean=null;

		// アレイリストを宣言
		loginbean = new LoginBean();
		ArrayList<LoginBean> list = new ArrayList<LoginBean>();

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
				url="/jsp/fail.jsp";
			}
			else
			{

				/*ユーザー名とパスワード認証LoginBeanクラスのalluserメソッドの呼び出し*/
				list = LoginBean.alluser();


				//listに取り出したデータすべてに対し認証確認
				for(int i = 0; i < list.size(); i++)
				{
					//listからオブジェクトを取り出す
					loginbean = (LoginBean)list.get(i);

				/*認証成功の場合は「ログイン成功場面（success.jsp）」へ遷移。
				   認証失敗の場合は「ログイン失敗画面（fail.jsp）」へ遷移。*/
				if(loginbean.getu_name().equals(u_name) && loginbean.getu_pass().equals(u_pass))
				{
					//urlをセット
					url="/jsp/success.jsp";

					LoginBean  loginuser = new LoginBean();
					loginuser =  loginuser.login(u_name);

					ArrayList<PostBean> postArray = new ArrayList<PostBean>();

					postArray = PostBean.getPostAll();


					PostBean pb = new PostBean();
					int num = pb.countData(u_name);
					String toukousu = String.valueOf(num);

					//セッションスコープをインスタンス化
					HttpSession session=request.getSession();

					session.setAttribute("postArray", postArray);
					session.setAttribute("toukousu", toukousu);
					// セッションの"alluser"というデータをtrueに
					session.setAttribute("alluser", true);

					// セッションにデータを付与
					session.setAttribute("loginuser", loginuser);

					//session.setAttribute("u_pass", u_pass);
				}
			}
			// 認証確認でurlがセットされなかった場合は、認証失敗ページをセット
			if(url == null)
			{
				//urlをセット
				url="/jsp/fail.jsp";
			}
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
