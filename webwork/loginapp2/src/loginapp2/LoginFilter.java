package loginapp2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class LoginFilter implements Filter {

    public LoginFilter() {}
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// リクエスト、レスポンスを型変換
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;

		// セッションスコープをリクエストの情報でインスタンス化
		HttpSession session = httpRequest.getSession();

		if (session.getAttribute("login") == null)
		{
			// セッションスコープのloginというデータのbooleanが設定されていなければ
			// 初期値をfalesに設定
			session.setAttribute("login", false);
		}

		// リダイレクトが無限ループすることへの対策
		if (httpRequest.getRequestURI().equals("/loginapp2/jsp/login.jsp"))
		{
			// ログイン処理要求の場合はスルーし次のフィルターへ
			// ログインページの判定
			chain.doFilter(httpRequest, httpResponse);
		}
		else if (httpRequest.getRequestURI().equals("/loginapp2/LoginController"))
		{
			// ログイン処理要求の場合はスルーし次のフィルターへ
			// ログイン時のコントローラの判定
			chain.doFilter(httpRequest, httpResponse);
		}
		else if ((Boolean)session.getAttribute("login"))
		{
			// ログイン処理後はスルーしてよい
			chain.doFilter(httpRequest, httpResponse);
		}
		else
		{
			httpResponse.sendRedirect("http://localhost:8080/loginapp2/jsp/login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
