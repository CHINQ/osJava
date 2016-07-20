package vo;

public class Words {

	private int wid;
	private Users user;
	private String wcontent;
	private String wtime;
	private Users toUser;
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getWcontent() {
		return wcontent;
	}
	public void setWcontent(String wcontent) {
		this.wcontent = wcontent;
	}
	public String getWtime() {
		return wtime;
	}
	public void setWtime(String wtime) {
		this.wtime = wtime;
	}
	public Users getToUser() {
		return toUser;
	}
	public void setToUser(Users toUser) {
		this.toUser = toUser;
	}
	/*public Words(int wid, Users user, String wcontent, String wtime) {
		super();
		this.wid = wid;
		this.user = user;
		this.wcontent = wcontent;
		this.wtime = wtime;
	}*/
	public Words() {
		super();
	}
	public Words(int wid) {
		super();
		this.wid = wid;
	}
	public Words(int wid, Users user, String wcontent, String wtime,
			Users toUser) {
		super();
		this.wid = wid;
		this.user = user;
		this.wcontent = wcontent;
		this.wtime = wtime;
		this.toUser = toUser;
	}
	
	
}
