package vo;

public class Lector {
	private int lid;
	private Users user;
	private String lcourse;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getLcourse() {
		return lcourse;
	}
	public void setLcourse(String lcourse) {
		this.lcourse = lcourse;
	}
	public Lector(int lid, Users user, String lcourse) {
		super();
		this.lid = lid;
		this.user = user;
		this.lcourse = lcourse;
	}
	public Lector() {
		super();
	}
	public Lector(String lcourse) {
		super();
		this.lcourse = lcourse;
	}
	public Lector(int lid, String lcourse) {
		super();
		this.lid = lid;
		this.lcourse = lcourse;
	}
	public Lector(String lcourse,Users user) {
		super();
		this.user = user;
		this.lcourse = lcourse;
	}
	public Lector(int lid) {
		super();
		this.lid = lid;
	}
	
	

}
