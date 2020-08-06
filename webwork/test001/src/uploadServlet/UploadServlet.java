package uploadServlet;

import java.io.IOException;

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
        // path設定
        part.write("C:/webwork/test001/WebContent/tmp" + "/" + name);
        
        
        response.sendRedirect("jsp/upload.jsp");
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

