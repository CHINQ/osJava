package vo;

public class TestDetail {
	private int tdid;
	private TestPaper tp;
	private String tid;
	private String tppitch;
	public int getTdid() {
		return tdid;
	}
	public void setTdid(int tdid) {
		this.tdid = tdid;
	}
	public TestPaper getTp() {
		return tp;
	}
	public void setTp(TestPaper tp) {
		this.tp = tp;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTppitch() {
		return tppitch;
	}
	public void setTppitch(String tppitch) {
		this.tppitch = tppitch;
	}
	public TestDetail(int tdid, TestPaper tp, String tid, String tppitch) {
		super();
		this.tdid = tdid;
		this.tp = tp;
		this.tid = tid;
		this.tppitch = tppitch;
	}
	public TestDetail() {
		super();
	}
	public TestDetail(String tid, String tppitch) {
		super();
		this.tid = tid;
		this.tppitch = tppitch;
	}



	

}
