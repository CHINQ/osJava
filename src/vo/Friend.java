package vo;

public class Friend {

	private int fid;
	private Users user;
	private Users user_ben;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Users getUser_ben() {
		return user_ben;
	}
	public void setUser_ben(Users user_ben) {
		this.user_ben = user_ben;
	}
	public Friend(int fid, Users user, Users user_ben) {
		super();
		this.fid = fid;
		this.user = user;
		this.user_ben = user_ben;
	}
	public Friend() {
		super();
	}
	public Friend(int fid) {
		super();
		this.fid = fid;
	}
	public Friend(Users user, Users user_ben) {
		super();
		this.user = user;
		this.user_ben = user_ben;
	}
	
	
}
