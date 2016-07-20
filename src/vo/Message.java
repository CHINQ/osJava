package vo;

public class Message {

	private int mid;
	private Users user;
	private String mtitle;
	private String mcontent;
	private String mtime;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	public Message(int mid, Users user, String mtitle, String mcontent,
			String mtime) {
		super();
		this.mid = mid;
		this.user = user;
		this.mtitle = mtitle;
		this.mcontent = mcontent;
		this.mtime = mtime;
	}
	public Message() {
		super();
	}
	public Message(int mid) {
		super();
		this.mid = mid;
	}
	public Message(Users user, String mtitle, String mcontent, String mtime) {
		super();
		this.user = user;
		this.mtitle = mtitle;
		this.mcontent = mcontent;
		this.mtime = mtime;
	}
		
}
