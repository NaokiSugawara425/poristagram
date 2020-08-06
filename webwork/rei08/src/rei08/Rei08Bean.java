package rei08;

import java.io.Serializable;

public class Rei08Bean implements Serializable {
	private String text01;
	public void setText01(String text01){
		this.text01 = text01;
	}
	public String getText01(){
		return this.text01;
	}
}
