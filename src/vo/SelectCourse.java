package vo;

public class SelectCourse {
	private int sid;
	private String uid;
	private int cid;
	private Course course;
	private Lector lector;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}
	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public SelectCourse() {
		super();
	}

	public SelectCourse(int sid, String uid, int cid, Course course,
			Lector lector) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.cid = cid;
		this.course = course;
		this.lector = lector;
	}

	

	public SelectCourse(int sid, String uid, int cid) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.cid = cid;
	}

	

	
	
	


}
