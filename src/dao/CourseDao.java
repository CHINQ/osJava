package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Course;
import vo.Lector;
import vo.SubPage;
import vo.Users;
import dbutil.DBHelp;

public class CourseDao {
	private DBHelp hp;
	public List<Course> selectCourse(){
		hp=new DBHelp();
		String sql="SELECT course.cid,lector.lcourse FROM course INNER JOIN lector ON course.lid = lector.lid";
		List<Course> list=new ArrayList<Course>();
		ResultSet rs=null;
		try {
			rs=hp.query(sql);
			while(rs.next()){
				list.add(new Course(rs.getInt(1),new Lector(rs.getString(2))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Course> searchCourse(){
		hp=new DBHelp();
		String sql="SELECT course.cid,lector.lcourse,users.uname,course.ctime,course.cplace FROM course INNER JOIN lector ON course.lid = lector.lid INNER JOIN users ON lector.uid = users.uid;";
		List<Course> list=new ArrayList<Course>();
		ResultSet rs=null;
		try {
			rs=hp.query(sql);
			while(rs.next()){
				list.add(new Course(rs.getInt(1),new Lector(rs.getString(2),new Users(rs.getString(3))),rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Course> searchCourse(SubPage page){
		String sql="SELECT course.cid,lector.lcourse,users.uname,course.ctime,course.cplace FROM course INNER JOIN lector ON course.lid = lector.lid INNER JOIN users ON lector.uid = users.uid limit ?,?";
		hp=new DBHelp();
		List<Course> list=new ArrayList<Course>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Course(rs.getInt(1),new Lector(rs.getString(2),new Users(rs.getString(3))),rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Course> searchByBname(SubPage page,String bnm){
		String sql="SELECT course.cid,lector.lcourse,users.uname,course.ctime,course.cplace FROM course INNER JOIN lector ON course.lid = lector.lid INNER JOIN users ON lector.uid = users.uid  where users.uname like '%"+bnm+"%' limit ?,?";
		hp=new DBHelp();
		List<Course> list=new ArrayList<Course>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Course(rs.getInt(1),new Lector(rs.getString(2),new Users(rs.getString(3))),rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Course> searchByBtext(SubPage page,String btxt){
		String sql="SELECT course.cid,lector.lcourse,users.uname,course.ctime,course.cplace FROM course INNER JOIN lector ON course.lid = lector.lid INNER JOIN users ON lector.uid = users.uid  where lector.lcourse like '%"+btxt+"%' limit ?,?";
		hp=new DBHelp();
		List<Course> list=new ArrayList<Course>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Course(rs.getInt(1),new Lector(rs.getString(2),new Users(rs.getString(3))),rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Course> searchByBnameAndBtext(SubPage page,String bnm,String btxt){
		String sql="SELECT course.cid,lector.lcourse,users.uname,course.ctime,course.cplace FROM course INNER JOIN lector ON course.lid = lector.lid INNER JOIN users ON lector.uid = users.uid  where lector.lcourse like '%"+btxt+"%' and users.uname like '%"+bnm+"%' limit ?,?";
		hp=new DBHelp();
		List<Course> list=new ArrayList<Course>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Course(rs.getInt(1),new Lector(rs.getString(2),new Users(rs.getString(3))),rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public int searchCount(String bnm,String btxt){	
		String sql="select count(*) from course join lector on course.lid=lector.lid join users on users.uid=lector.uid where cid!=0 ";
		if(bnm!=null&& !"".equals(bnm)){
			sql+=" and users.uname like '%"+bnm+"%'";
		}
		if(btxt!=null && !"".equals(btxt)){
			sql+=" and lector.lcourse like '%"+btxt+"%'";
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
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return temp;
	}
	public Course searchCourse(String cid){
		String sql="SELECT course.cid,lector.lcourse,users.uname,course.ctime,course.cplace FROM course INNER JOIN lector ON course.lid = lector.lid INNER JOIN users ON lector.uid = users.uid  where cid="+cid;
		hp=new DBHelp();
		Course course=null;
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				course=new Course(rs.getInt(1),new Lector(rs.getString(2),new Users(rs.getString(3))),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return course;
	}
		public int updateCourse(Course course){
			String sql="update course set ctime=?,cplace=? where cid=?";
			int temp=-1;
			hp=new DBHelp();
		    try {
				temp=hp.update(sql,course.getCtime(),course.getCplace(),course.getCid());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					hp.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return temp;
		}
	public int deleteCourse(String cid){
		hp=new DBHelp();
		int temp=-1;
		String sql="delete from course where cid="+cid;
		try {
			temp = hp.update(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return temp;		
	}
	public int addCourse(Course course){
		String sql="insert into course(lid,ctime,cplace) values(?,?,?)";
		hp=new DBHelp();
		int temp=-1;
		try {
			temp=hp.update(sql,course.getLect().getLid(),course.getCtime(),course.getCplace());
			hp.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return temp;		
	}		
}
