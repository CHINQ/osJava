package vo;

public class Books {
	private int bid;
	private String bname;
	private String btext;
	private String btime;
	private String bimage;
	private String baddress;
	private String uid;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtext() {
		return btext;
	}
	public void setBtext(String btext) {
		this.btext = btext;
	}
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public String getBimage() {
		return bimage;
	}
	public void setBimage(String bimage) {
		this.bimage = bimage;
	}
	public String getBaddress() {
		return baddress;
	}
	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Books(int bid, String bname, String btext, String btime,
			String bimage, String baddress, String uid) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.btext = btext;
		this.btime = btime;
		this.bimage = bimage;
		this.baddress = baddress;
		this.uid = uid;
	}
	public Books() {
		super();
	}
	

}
