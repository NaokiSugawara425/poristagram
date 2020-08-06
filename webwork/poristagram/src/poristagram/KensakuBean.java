package poristagram;

import java.io.Serializable;

public class KensakuBean implements Serializable{
	private String kensakuname;
	private int u_id;
	private String u_name;
	private String u_icon;


	public  String getKensakuname() {
        return kensakuname;
    }
	public void setKensakuname(String kensakuname) {
        this.kensakuname = kensakuname;
	}
	public int getU_id() {
        return u_id;
    }
	public void setU_id(int u_id) {
        this.u_id = u_id;
	}
	public String getU_name() {
        return u_name;
    }
	public void setU_name(String u_name) {
        this.u_name = u_name;
	}
	public String getU_icon() {
        return u_icon;
    }
	public void setU_icon(String u_icon) {
        this.u_icon = u_icon;
	}


}


