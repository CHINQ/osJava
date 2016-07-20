package vo;

public class Reply {

	private int rid;
	private Users user;
	private Posting post;
	private String rcontent;
//	private String rimage;
	private String rtime;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Posting getPost() {
		return post;
	}
	public void setPost(Posting post) {
		this.post = post;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
//	public String getRimage() {
//		return rimage;
//	}
//	public void setRimage(String rimage) {
//		this.rimage = rimage;
//	}
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	public Reply(int rid, Users user, Posting post, String rcontent,
			 String rtime) {
		super();
		this.rid = rid;
		this.user = user;
		this.post = post;
		this.rcontent = rcontent;
//		this.rimage = rimage;
		this.rtime = rtime;
	}
	public Reply() {
		super();
	}
	
	
}
