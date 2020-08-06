package rensyu01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Rensyu01Controller
 */
@WebServlet("/Rensyu01Controller")
public class Rensyu01Controller extends HttpServlet {
	//無視していいやつ
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	//無視していいコンストラクタ
    public Rensyu01Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//同じパッケージのTasiクラスのインスタンスを作成
		Tasi tasi = new Tasi();
		//requestのformから送られてくるデータをそれぞれ格納
		String str1 =request.getParameter("text01");
		String str2 =request.getParameter("text02");
		//double型にしたいので変数を用意
		double r1 = 0;
		double r2 = 0;
		try{
			//データをdouble型に変換（DoubleクラスのparseDoubleメソッドを使う）
		 r1 = Double.parseDouble(str1);
		 r2 = Double.parseDouble(str2);
		 //インスタンス化したtaのsetメソッドを呼び出し、
		 //フィールドに値をセット
		 tasi.setT1(r1);
		 tasi.setT2(r2);
		 //requestの中に"Tasi"という名前をつけてインスタンス化したtaの値を格納
			request.setAttribute("Tasi", tasi);
			//コンテキストの設定
			ServletContext context = getServletContext();
			//ディスパッチャーに送り先を指定
			RequestDispatcher rd = context.getRequestDispatcher("/jsp/rensyu01_response.jsp");
			rd.forward(request, response);
			//下記は変な奴が入力された場合エラーページにとぶよ。ってやつ。
		}catch(NumberFormatException e){
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/jsp/rensyu01_exception.jsp");
			rd.forward(request, response);
		}
	}
}
