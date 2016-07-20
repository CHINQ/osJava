package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Course;
import vo.Lector;
import vo.SelectCourse;
import vo.SubPage;
import dbutil.DBHelp;

public class SelectCourseDao {
	
	private DBHelp hp;
	public List<SelectCourse> search(){
		String sql="SELECT selectcourse.sid,selectcourse.uid,selectcourse.cid,course.ctime,course.cplace,course.cstate,lector.lcourse FROM selectcourse INNER JOIN course ON selectcourse.cid = course.cid INNER JOIN lector ON course.lid = lector.lid";
		hp=new DBHelp();
		List<SelectCourse>list=new ArrayList<SelectCourse>();
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new SelectCourse(rs.getInt(1),rs.getString(2),rs.getInt(3),new Course(rs.getString(4),rs.getString(5),rs.getInt(6)),new Lector(rs.getString(7))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<SelectCourse>search(SubPage page){
		String sql="SELECT selectcourse.sid,selectcourse.uid,selectcourse.cid,course.ctime,course.cplace,course.cstate,lector.lcourse FROM selectcourse INNER JOIN course ON selectcourse.cid = course.cid INNER JOIN lector ON course.lid = lector.lid  limit ?,?";
		hp=new DBHelp();
		List<SelectCourse>list=new ArrayList<SelectCourse>();
		ResultSet rs;
		try {
			rs = hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new SelectCourse(rs.getInt(1),rs.getString(2),rs.getInt(3),new Course(rs.getString(4),rs.getString(5),rs.getInt(6)),new Lector(rs.getString(7))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<SelectCourse>searchBySname(SubPage page,String snm){
		String sql="SELECT selectcourse.sid,selectcourse.uid,selectcourse.cid,course.ctime,course.cplace,course.cstate,lector.lcourse FROM selectcourse INNER JOIN course ON selectcourse.cid = course.cid INNER JOIN lector ON course.lid = lector.lid  where lector.lcourse like '%"+snm+"%' limit ?,?";
		hp=new DBHelp();
		List<SelectCourse>list=new ArrayList<SelectCourse>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new SelectCourse(rs.getInt(1),rs.getString(2),rs.getInt(3),new Course(rs.getString(4),rs.getString(5),rs.getInt(6)),new Lector(rs.getString(7))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<SelectCourse> searchByStext(SubPage page,String stxt){
		String sql="SELECT selectcourse.sid,selectcourse.uid,selectcourse.cid,course.ctime,course.cplace,course.cstate,lector.lcourse FROM selectcourse INNER JOIN course ON selectcourse.cid = course.cid INNER JOIN lector ON course.lid = lector.lid  where selectcourse.cid like '%"+stxt+"%' limit ?,?";
		hp=new DBHelp();
		List<SelectCourse>list=new ArrayList<SelectCourse>();
		ResultSet rs;
		try {
			rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new SelectCourse(rs.getInt(1),rs.getString(2),rs.getInt(3),new Course(rs.getString(4),rs.getString(5),rs.getInt(6)),new Lector(rs.getString(7))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<SelectCourse> searchBySnameAndStext(SubPage page,String snm,String stxt){
		String sql="SELECT selectcourse.sid,selectcourse.uid,selectcourse.cid,course.ctime,course.cplace,course.cstate,lector.lcourse FROM selectcourse INNER JOIN course ON selectcourse.cid = course.cid INNER JOIN lector ON course.lid = lector.lid  where lector.lcourse like '%"+snm+"%' and selectcourse.cid like '%"+stxt+"%' limit ?,? ";
		hp=new DBHelp();
		List<SelectCourse>list=new ArrayList<SelectCourse>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new SelectCourse(rs.getInt(1),rs.getString(2),rs.getInt(3),new Course(rs.getString(4),rs.getString(5),rs.getInt(6)),new Lector(rs.getString(7))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public SelectCourse search(String uid){
		String sql="SELECT selectcourse.sid,selectcourse.uid,selectcourse.cid,course.ctime,course.cplace,course.cstate,lector.lcourse FROM selectcourse INNER JOIN course ON selectcourse.cid = course.cid INNER JOIN lector ON course.lid = lector.lid  where selectcourse.uid=?";
		hp=new DBHelp();
		SelectCourse shop=null;
		try {
			ResultSet rs=hp.query(sql,uid);
			if(rs.next()){
				shop=new SelectCourse(rs.getInt(1),rs.getString(2),rs.getInt(3),new Course(rs.getString(4),rs.getString(5),rs.getInt(6)),new Lector(rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return shop;
	}
	public List<SelectCourse> search2(String uid){
		String sql="SELECT selectcourse.sid,selectcourse.uid,selectcourse.cid,course.ctime,course.cplace,course.cstate,lector.lcourse FROM selectcourse INNER JOIN course ON selectcourse.cid = course.cid INNER JOIN lector ON course.lid = lector.lid  where selectcourse.uid=?";
		hp=new DBHelp();
		List<SelectCourse> list=new ArrayList<SelectCourse>();
		try {
			ResultSet rs=hp.query(sql,uid);
			while(rs.next()){
				list.add(new SelectCourse(rs.getInt(1),rs.getString(2),rs.getInt(3),new Course(rs.getString(4),rs.getString(5),rs.getInt(6)),new Lector(rs.getString(7))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public int searchCount(String snm,String stxt){
		String sql="select count(*) from selectcourse where sid!=0";
		if(snm!=null&&!"".equals(snm)){
			sql+="and sname like '"+snm+"'";
		}
		if(stxt!=null&&!"".equals(stxt)){
			sql+="and stext like '"+stxt+"'";
		}
		int temp=0;
		hp=new DBHelp();
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	
	public int searchSelectCourse(String cid,String uid){
		String sql="insert into selectcourse(cid,uid) values("+cid+",'"+uid+"')";
         int temp=-1;
     	hp=new DBHelp();
		try {
			temp=hp.insert(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}

}
