package vo;

public class Test {
	private int tid;
	private String title;
	private String truekey;
	private String tanalyze;
	private String ttime;
	private Lector lect;
	private Course cour;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTruekey() {
		return truekey;
	}
	public void setTruekey(String truekey) {
		this.truekey = truekey;
	}
	public String getTanalyze() {
		return tanalyze;
	}
	public void setTanalyze(String tanalyze) {
		this.tanalyze = tanalyze;
	}
	public String getTtime() {
		return ttime;
	}
	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	public Lector getLect() {
		return lect;
	}
	public void setLect(Lector lect) {
		this.lect = lect;
	}
	public Course getCour() {
		return cour;
	}
	public void setCour(Course cour) {
		this.cour = cour;
	}
	public Test(int tid, String title, String truekey, String tanalyze,
			String ttime, Lector lect, Course cour) {
		super();
		this.tid = tid;
		this.title = title;
		this.truekey = truekey;
		this.tanalyze = tanalyze;
		this.ttime = ttime;
		this.lect = lect;
		this.cour = cour;
	}
	public Test() {
		super();
	}
	public Test(int tid, String title, String truekey, String tanalyze) {
		super();
		this.tid = tid;
		this.title = title;
		this.truekey = truekey;
		this.tanalyze = tanalyze;
	}
	public Test(int tid) {
		super();
		this.tid = tid;
	}
	

}
