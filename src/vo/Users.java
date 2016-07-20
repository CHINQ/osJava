package vo;

public class Users {

	private String uid;
	private String upass;
	private String upower;
	private String uname;
	private int uage;
	private String usex;
	private String uimage;
	private String utext;
	private int ustate;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUpower() {
		return upower;
	}
	public void setUpower(String upower) {
		this.upower = upower;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUimage() {
		return uimage;
	}
	public void setUimage(String uimage) {
		this.uimage = uimage;
	}
	public String getUtext() {
		return utext;
	}
	public void setUtext(String utext) {
		this.utext = utext;
	}
	public int getUstate() {
		return ustate;
	}
	public void setUstate(int ustate) {
		this.ustate = ustate;
	}
	public Users() {
		super();
	}
	public Users(String uid, String upass, String upower, String uname,
			int uage, String usex, String uimage, String utext, int ustate) {
		super();
		this.uid = uid;
		this.upass = upass;
		this.upower = upower;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.uimage = uimage;
		this.utext = utext;
		this.ustate = ustate;
	}
	public Users(String uname) {
		super();
		this.uname = uname;
	}
	public Users(String uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
	}
	public Users(String uid, String uname, int uage, String usex,
			String uimage, String utext) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.uimage = uimage;
		this.utext = utext;
	}
	public Users(String uid, String upass, String uname, int uage, String usex,
			String uimage, String utext, int ustate) {
		super();
		this.uid = uid;
		this.upass = upass;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.uimage = uimage;
		this.utext = utext;
		this.ustate = ustate;
	}
	public Users(String uid, String uimage, String utext) {
		super();
		this.uid = uid;
		this.uimage = uimage;
		this.utext = utext;
	}
	public Users(String uid, String uname, String uimage, String utext) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uimage = uimage;
		this.utext = utext;
	}

	

	
	
}
