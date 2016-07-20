package vo;

public class Course {
private int cid;
private Lector lect;
private String ctime;
private String cplace;
private int cstate;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public Lector getLect() {
	return lect;
}
public void setLect(Lector lect) {
	this.lect = lect;
}
public String getCtime() {
	return ctime;
}
public void setCtime(String ctime) {
	this.ctime = ctime;
}
public String getCplace() {
	return cplace;
}
public void setCplace(String cplace) {
	this.cplace = cplace;
}
public int getCstate() {
	return cstate;
}
public void setCstate(int cstate) {
	this.cstate = cstate;
}
public Course(int cid, Lector lect, String ctime, String cplace, int cstate) {
	super();
	this.cid = cid;
	this.lect = lect;
	this.ctime = ctime;
	this.cplace = cplace;
	this.cstate = cstate;
}
public Course() {
	super();
}
public Course(int cid, Lector lect) {
	super();
	this.cid = cid;
	this.lect = lect;
}
public Course(String ctime, String cplace, int cstate) {
	super();
	this.ctime = ctime;
	this.cplace = cplace;
	this.cstate = cstate;
}
public Course(int cid, Lector lect, String ctime, String cplace) {
	super();
	this.cid = cid;
	this.lect = lect;
	this.ctime = ctime;
	this.cplace = cplace;
}
public Course(Lector lect, String ctime, String cplace) {
	super();
	this.lect = lect;
	this.ctime = ctime;
	this.cplace = cplace;
}
public Course(int cid, String ctime, String cplace) {
	super();
	this.cid = cid;
	this.ctime = ctime;
	this.cplace = cplace;
}


}
