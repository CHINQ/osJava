package vo;

public class Menu {
	private int mid;
	private String mname;
	private String mpath;
	private int isdirect;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public String getMpath() {
		return mpath;
	}
	public void setMpath(String mpath) {
		this.mpath = mpath;
	}

	public int getIsdirect() {
		return isdirect;
	}
	public void setIsdirect(int isdirect) {
		this.isdirect = isdirect;
	}

	public Menu(int mid, String mname, String mpath, int isdirect) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mpath = mpath;
		this.isdirect = isdirect;
	}
	public Menu() {
		super();
	}
	

}
