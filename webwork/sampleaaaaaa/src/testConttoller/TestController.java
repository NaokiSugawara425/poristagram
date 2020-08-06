package testConttoller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class TestController extends HttpServlet {
    public void doPost(HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {

        //(1)アップロードファイルを格納するPATHを取得
        String path = getServletContext().getRealPath("files");

        //(2)ServletFileUploadオブジェクトを生成
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        //(3)アップロードする際の基準値を設定
        factory.setSizeThreshold(1024);
        upload.setSizeMax(-1);
        upload.setHeaderEncoding("Windows-31J");

        try {
            //(4)ファイルデータ(FileItemオブジェクト)を取得し、
            //   Listオブジェクトとして返す
            List<FileItem> list = upload.parseRequest(req);

            //(5)ファイルデータ(FileItemオブジェクト)を順に処理
            Iterator<FileItem> iterator = list.iterator();
            while(iterator.hasNext()){
                FileItem fItem = (FileItem)iterator.next();

                //(6)ファイルデータの場合、if内を実行
                if(!(fItem.isFormField())){
                    //(7)ファイルデータのファイル名(PATH名含む)を取得
                    String fileName = fItem.getName();
                    if((fileName != null) && (!fileName.equals(""))){
                        //(8)PATH名を除くファイル名のみを取得
                        fileName=(new File(fileName)).getName();
                        //(9)ファイルデータを指定されたファイルに書き出し
                        fItem.write(new File(path + "/" + fileName));
                    }
                }
            }
        }catch (FileUploadException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        //(10)upFile.htmlページに戻る
        res.sendRedirect("upFile.html");
    }
}