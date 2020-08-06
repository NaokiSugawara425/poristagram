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
 * Servlet implementation class UploadOkController
 */
@WebServlet("/UploadOkController")
public class UploadOkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadOkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// 例外処理
		try
		{
			// セッションオブジェクトを宣言
			HttpSession session = request.getSession();

			ArrayList<String> list = new ArrayList<String>();

			LoginBean loginbean = new LoginBean();

			loginbean = (LoginBean)session.getAttribute("loginuser");

			list.add(loginbean.getu_name());
			list.add((String)session.getAttribute("path"));
			list.add(request.getParameter("kome"));
			list.add(request.getParameter("tag1"));
			list.add(request.getParameter("tag2"));
			list.add(request.getParameter("tag3"));
			list.add(request.getParameter("tag4"));

			PostBean post = new PostBean();

			post.saveComment(list);

			post = post.makePost(list);

			ArrayList<PostBean> postArray = PostBean.getPostAll();

			session.removeAttribute("postArray");
			session.setAttribute("postArray", postArray);

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
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/kanryou.jsp");

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