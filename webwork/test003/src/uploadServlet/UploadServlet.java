package uploadServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
@MultipartConfig(location="C:/webwork/test001/WebContent/tmp", maxFileSize=1048576)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // partインスタンス化データ付与
    	Part part = request.getPart("file");
    	// nameにファイル名を格納
        String name = this.getFileName(part);
        // 画像のurl保存用の変数
        String imageUrl = null;
        // path設定
        part.write("C:/webwork/test003/WebContent/tmp/" + name);
        // 変数にurl格納
        imageUrl = "http://192.168.32.111:8080/test003/tmp/" + name;

        // アレイリストに詰めなおしたデータを名前を付けてセッションに登録
     	request.setAttribute("imageUrl", imageUrl);

     	// コンテキストのインスタンス化
 		ServletContext context = getServletContext();

 		// リクエストディスパッチャーのインスタンス化
 		// 引数にフォワード先のパスを設定
 		RequestDispatcher rd = context.getRequestDispatcher("/jsp/addComent.jsp");


 		try{
 			Thread.sleep(10000);
 		}catch(InterruptedException e){}
 		// 転送する、(実行しているのはコントローラ)
 		rd.forward(request, response);

    }


    // ファイルネームだけ取り出すメソッド
    private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }
}

