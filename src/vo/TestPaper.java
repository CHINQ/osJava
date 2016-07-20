package vo;

public class TestPaper {
	private int tpid;
	private Users user;
	private float tpfull;
	private float tpscore;
	private ExamManage em;
	private String tpdate;
	public int getTpid() {
		return tpid;
	}
	public void setTpid(int tpid) {
		this.tpid = tpid;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public float getTpfull() {
		return tpfull;
	}
	public void setTpfull(float tpfull) {
		this.tpfull = tpfull;
	}
	public float getTpscore() {
		return tpscore;
	}
	public void setTpscore(float tpscore) {
		this.tpscore = tpscore;
	}
	public ExamManage getEm() {
		return em;
	}
	public void setEm(ExamManage em) {
		this.em = em;
	}
	
	public String getTpdate() {
		return tpdate;
	}
	public void setTpdate(String tpdate) {
		this.tpdate = tpdate;
	}
	public TestPaper(int tpid, Users user, float tpfull, float tpscore,
			ExamManage em) {
		super();
		this.tpid = tpid;
		this.user = user;
		this.tpfull = tpfull;
		this.tpscore = tpscore;
		this.em = em;
	}
	public TestPaper() {
		super();
	}
	public TestPaper(float tpfull, float tpscore, ExamManage em) {
		super();
		this.tpfull = tpfull;
		this.tpscore = tpscore;
		this.em = em;
	}
	public TestPaper(int tpid) {
		super();
		this.tpid = tpid;
	}

	

}
