package poristagram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FindCommentDAO {

    public List<Board> findcomment() {

        // id,name,commentを格納するリスト
        List<Board> list = new ArrayList<>();

        final String jdbcId = "root";
        final String jdbcPass = "rootpass";
        final String jdbcUrl = "jdbc:mysql://localhost:3306/testagram?useSSL=false";

        Connection con = null;

        try {

            con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);

            System.out.println("Connected....");

            try {
                Statement st = con.createStatement();
                String sql = "select * from chat";

                try {
                    // sqlを送信
                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {
                        // DBから取り出したid,name,commentをJavaBeansにset
                        Board bo = new Board();
                        bo.setId(rs.getInt("c_myid"));
                        bo.setToid(rs.getInt("c_yourid"));
                        bo.setCid(rs.getInt("c_id"));
                        bo.setName(rs.getString("c_myname"));
                        bo.setComment(rs.getString("c_comment"));
                        bo.setTime(rs.getTimestamp("c_time"));

                        // リストに1個ずつ格納。末尾に要素が追加されていく。
                        if(bo.getCid()==2001) {
                        list.add(bo);
                        }
                    }

                    rs.close();
                    st.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
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
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed.");
            return null;
        }
        return list;

    }

}