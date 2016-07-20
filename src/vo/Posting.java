package vo;

public class Posting {

	private int pid;
	private Users user;
	private String ptitle;
	private String pcontent;
	private String ptime;
	private String pimage;
	private int pcount;
	private int prcount;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public int getPcount() {
		return pcount;
	}
	public void setPcount(int pcount) {
		this.pcount = pcount;
	}
	public int getPrcount() {
		return prcount;
	}
	public void setPrcount(int prcount) {
		this.prcount = prcount;
	}
	public Posting(int pid, Users user, String ptitle, String pcontent,
			String ptime, String pimage, int pcount) {
		super();
		this.pid = pid;
		this.user = user;
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.ptime = ptime;
		this.pimage = pimage;
		this.pcount=pcount;
	}
	public Posting() {
		super();
	}
	public Posting(int pid) {
		super();
		this.pid = pid;
	}
	public int addCount(int pcount){
		pcount=pcount+1;
		return pcount;
	}
	public int addPrCount(int prcount){
		prcount=prcount+1;
		return prcount;
	}
	
}
