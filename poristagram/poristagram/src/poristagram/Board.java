package poristagram;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Board implements Serializable {
    private int id;
    private int toid;
    private int cid;
    private String name;
    private String toname;
    private String comment;
    private Timestamp time;
    private boolean rireki;

    public boolean getRireki() {
		return rireki;
	}
	public void setRireki(boolean rireki) {
		this.rireki = rireki;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getToid() {
        return toid;
    }
    public void setToid(int toid) {
        this.toid = toid;
    }
    public int getCid() {

        return cid;
    }
    public void setCid(int cid) {
    	this.cid = cid;
    	}
    public void setCid(int m, int y) {
    	int total = 0;
    	if(m < y){
    		total = y * 1000 + m;
    	}else{
    		total = m * 1000 + y;
    	}

    	this.cid = total;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getToname() {
        return toname;
    }
    public void setToname(String toname) {
        this.toname = toname;
    }
    public Timestamp getTime() {
        return time;
    }
    public void setTime(Timestamp time) {
        this.time = time;
    }


    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public int countData(String u_name, String yourname) throws SQLException{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		int toukou = 0;

		try {
			//DB接続
			conn = new ResourceFinder().getConnection();
			//stにSQL文を準備・実行
			st = conn.prepareStatement("SELECT COUNT(c_id) FROM chat WHERE c_myname = '" + u_name + "' and c_yourname  = '" + yourname + "';");
			//rsに実行結果を格納
			rs = st.executeQuery();
			//一行ずらす
			rs.next();
			//toukousuへ結果を格納
			toukou = (rs.getInt(1));
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try{
				//クローズ処理
				rs.close();
				st.close();
				conn.close();
			}catch(SQLException e){
				throw e;
			}
		}
		return toukou;

	}
}