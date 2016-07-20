package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.ExamManage;
import vo.Lector;
import vo.SubPage;
import dbutil.DBHelp;

public class ExamManageDao {
	private DBHelp dh;
	public List<ExamManage> selectExamManage(){
		dh=new DBHelp();
		String sql="select emid,(SELECT lcourse from lector WHERE exammanage.lid=lector.lid),emtime,emduration,emfull,emstate FROM exammanage";
		List<ExamManage> list=new ArrayList<ExamManage>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql);
			while(rs.next()){
				list.add(new ExamManage(rs.getInt(1),new Lector(rs.getString(2)),rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getInt(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<ExamManage> selectExamManage(SubPage page){
		dh=new DBHelp();
		String sql="select emid,(SELECT lcourse from lector WHERE exammanage.lid=lector.lid),emtime,emduration,emfull,emstate,emoverdue FROM exammanage where emstate=1 and emoverdue=1 limit ?,?";
		List<ExamManage> list=new ArrayList<ExamManage>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new ExamManage(rs.getInt(1),new Lector(rs.getString(2)),rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getInt(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<ExamManage> selectExamManage2(SubPage page){
		dh=new DBHelp();
		String sql="select emid,(SELECT lcourse from lector WHERE exammanage.lid=lector.lid),emtime,emduration,emfull,emstate,emoverdue FROM exammanage limit ?,?";
		List<ExamManage> list=new ArrayList<ExamManage>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new ExamManage(rs.getInt(1),new Lector(rs.getString(2)),rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getInt(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<ExamManage> selectExamManage(String emid){
		dh=new DBHelp();
		String sql="SELECT exammanage.emid,lector.lid,lector.lcourse,exammanage.emtime,exammanage.emduration,exammanage.emfull,exammanage.emstate FROM exammanage INNER JOIN lector ON exammanage.lid = lector.lid WHERE emid=?";
		List<ExamManage> list=new ArrayList<ExamManage>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql, emid);
			while(rs.next()){
				list.add(new ExamManage(rs.getInt(1),new Lector(rs.getInt(2),rs.getString(3)),rs.getString(4),rs.getInt(5),rs.getFloat(6),rs.getInt(7)));					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public int searchCount(){			
		String sql="select count(*) from exammanage where emstate=1 and emoverdue=1";				
		int temp=0;
		dh=new DBHelp();
		try {
			ResultSet rs=dh.query(sql);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return temp;
	}
	public int searchCount2(){			
		String sql="select count(*) from exammanage";				
		int temp=0;
		dh=new DBHelp();
		try {
			ResultSet rs=dh.query(sql);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return temp;
	}
	public int addExamManage(String lid,String emtime,String emduration,float emfull,int emstate){
		dh=new DBHelp();
		String sql="insert into exammanage(lid,emtime,emduration,emfull,emstate) values(?,?,?,?,?)";
		int temp=-1;
		try {
			temp=dh.insert(sql,lid,emtime,emduration,emfull,emstate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	public int updateExamManage(String emid){
		dh=new DBHelp();
		String sql="update exammanage set emstate=0 where emid=?";
		int temp=-1;
		try {
			temp=dh.insert(sql, emid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	public int updateExamManage(String lid,String emtime,String emduration,String emid){
		dh=new DBHelp();
		String sql="update exammanage set lid=?,emtime=?,emduration=? where emid=?";
		int temp=-1;
		try {
			temp=dh.insert(sql,lid,emtime,emduration, emid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	public List<ExamManage> selectALLExam(){
		dh=new DBHelp();
		String sql="SELECT exammanage.emid,exammanage.emtime from exammanage";
		List<ExamManage> list=new ArrayList<ExamManage>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql);
			while(rs.next()){
				list.add(new ExamManage(rs.getInt(1),rs.getString(2)));					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public int updateExamManage(int emoverdue,int emid){
		dh=new DBHelp();
		String sql="update exammanage set emoverdue=? where emid=?";
		int temp=-1;
		try {
			temp=dh.insert(sql,emoverdue, emid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	public List<ExamManage> selectCourse(String uid,SubPage page){
		dh=new DBHelp();
		String sql="SELECT exammanage.emid,lector.lcourse,exammanage.emtime,exammanage.emduration,exammanage.emfull FROM exammanage INNER JOIN lector ON exammanage.lid = lector.lid WHERE lector.uid=? limit ?,?";
		List<ExamManage> list=new ArrayList<ExamManage>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql,uid,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new ExamManage(rs.getInt(1),new Lector(rs.getString(2)),rs.getString(3),rs.getInt(4),rs.getFloat(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}





