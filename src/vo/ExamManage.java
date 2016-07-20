package vo;

public class ExamManage {
	private int emid;
	private Lector lect;
	private String emtime;
	private int emduration;
	private float emfull;
	private int emstate; 
	private int emoverdue;
	public int getEmid() {
		return emid;
	}
	public void setEmid(int emid) {
		this.emid = emid;
	}
	public Lector getLect() {
		return lect;
	}
	public void setLect(Lector lect) {
		this.lect = lect;
	}
	public String getEmtime() {
		return emtime;
	}
	public void setEmtime(String emtime) {
		this.emtime = emtime;
	}
	public int getEmduration() {
		return emduration;
	}
	public void setEmduration(int emduration) {
		this.emduration = emduration;
	}
	
	public float getEmfull() {
		return emfull;
	}
	public void setEmfull(float emfull) {
		this.emfull = emfull;
	}
	public int getEmstate() {
		return emstate;
	}
	public void setEmstate(int emstate) {
		this.emstate = emstate;
	}

	public int getEmoverdue() {
		return emoverdue;
	}
	public void setEmoverdue(int emoverdue) {
		this.emoverdue = emoverdue;
	}
	public ExamManage(int emid, Lector lect, String emtime, int emduration,
			float emfull, int emstate) {
		super();
		this.emid = emid;
		this.lect = lect;
		this.emtime = emtime;
		this.emduration = emduration;
		this.emfull = emfull;
		this.emstate = emstate;
	}
	public ExamManage() {
		super();
	}
	public ExamManage(Lector lect, String emtime, int emduration) {
		super();
		this.lect = lect;
		this.emtime = emtime;
		this.emduration = emduration;
	}
	public ExamManage(String emtime, int emduration) {
		super();
		this.emtime = emtime;
		this.emduration = emduration;
	}
	public ExamManage(Lector lect) {
		super();
		this.lect = lect;
	}
	public ExamManage(int emid, String emtime) {
		super();
		this.emid = emid;
		this.emtime = emtime;
	}
	public ExamManage(int emid, Lector lect, String emtime, int emduration,
			float emfull, int emstate, int emoverdue) {
		super();
		this.emid = emid;
		this.lect = lect;
		this.emtime = emtime;
		this.emduration = emduration;
		this.emfull = emfull;
		this.emstate = emstate;
		this.emoverdue = emoverdue;
	}

	public ExamManage(int emid, Lector lect, String emtime, int emduration,
			float emfull) {
		super();
		this.emid = emid;
		this.lect = lect;
		this.emtime = emtime;
		this.emduration = emduration;
		this.emfull = emfull;
	}
	public ExamManage(int emid, Lector lect, String emtime, int emduration) {
		super();
		this.emid = emid;
		this.lect = lect;
		this.emtime = emtime;
		this.emduration = emduration;
	}
	

}
