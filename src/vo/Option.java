package vo;

public class Option {
	private String oid;
	private Test test;
	private String ocontent;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public String getOcontent() {
		return ocontent;
	}
	public void setOcontent(String ocontent) {
		this.ocontent = ocontent;
	}

	public Option(String oid, Test test, String ocontent) {
		super();
		this.oid = oid;
		this.test = test;
		this.ocontent = ocontent;
	}
	public Option() {
		super();
	}
	

}
