package poristagram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCommentDAO {

    // DBにid,name,commentを加えるメソッド
    public AddCommentDAO(Board bo) {



        final String jdbcId = "root";
        final String jdbcPass = "rootpass";
        final String jdbcUrl = "jdbc:mysql://localhost:3306/testagram?useSSL=false";

        Connection con = null;

        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);

            System.out.println("Connected....");

            try {

                PreparedStatement ps = con.prepareStatement("INSERT INTO chat (c_myid,c_yourid,c_id,c_myname,c_yourname, c_comment,c_time) VALUES (?,?,?,?,?,?,now())");
                System.out.println(bo.getId());
                ps.setInt(1, bo.getId());
                ps.setInt(2, bo.getToid());
                ps.setInt(3, bo.getCid());
                ps.setString(4, bo.getName());
                System.out.println(bo.getName());
                ps.setString(5, bo.getToname());
                ps.setString(6, bo.getComment());

                // ひな形を送信
                int r = ps.executeUpdate();

                if (r != 0) {
                    System.out.println(r + "件の書き込みを追加しました。");
                } else {
                    System.out.println("書き込みできませんでした。");
                }

                ps.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // データベース接続の切断
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Connection Failed.");

        }

    }

}

