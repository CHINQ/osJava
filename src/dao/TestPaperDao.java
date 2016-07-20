package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.ExamManage;
import vo.Lector;
import vo.SubPage;
import vo.TestPaper;
import vo.Users;
import dbutil.DBHelp;

public class TestPaperDao {
	private DBHelp dh;
	public int addTestPaper(String uid,float fullScore,float score,String emid,String tpdate){
		dh=new DBHelp();
		String sql="insert into TestPaper(uid,tpfull,tpscore,emid,tpdate) values(?,?,?,?,?)";
		int temp=-1;
		try {
			temp=dh.insert(sql,uid,fullScore,score,emid,tpdate);
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
	public List<TestPaper> selectTestPaper(String tpdate){
		dh=new DBHelp();
		String sql="SELECT tpid from testpaper where tpdate=?";
		List<TestPaper> list=new ArrayList<TestPaper>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql, tpdate);
			while(rs.next()){
				list.add(new TestPaper(rs.getInt(1)));
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
	public List<TestPaper> selectTestPaper2(String uid){
		dh=new DBHelp();
		String sql="SELECT tpid,users.uname,tpfull,tpscore,lector.lcourse,exammanage.emtime,exammanage.emduration FROM testpaper INNER JOIN users ON testpaper.uid = users.uid INNER JOIN exammanage ON testpaper.emid = exammanage.emid INNER JOIN lector ON lector.lid = exammanage.lid where users.uid =?";
		List<TestPaper> list=new ArrayList<TestPaper>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql,uid);
			while(rs.next()){
				list.add(new TestPaper(rs.getInt(1), new Users(rs.getString(2)), rs.getFloat(3), rs.getFloat(4), new ExamManage(new Lector(rs.getString(5)),rs.getString(6),rs.getInt(7))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public List<TestPaper> selectTestPaper2(String uid,SubPage page){
		dh=new DBHelp();
		String sql="SELECT tpid,users.uname,tpfull,tpscore,lector.lcourse,exammanage.emtime,exammanage.emduration FROM testpaper INNER JOIN users ON testpaper.uid = users.uid INNER JOIN exammanage ON testpaper.emid = exammanage.emid INNER JOIN lector ON lector.lid = exammanage.lid where users.uid =? limit ?,?";
		List<TestPaper> list=new ArrayList<TestPaper>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql,uid,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new TestPaper(rs.getInt(1), new Users(rs.getString(2)), rs.getFloat(3), rs.getFloat(4), new ExamManage(new Lector(rs.getString(5)),rs.getString(6),rs.getInt(7))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public int searchCount(String uid){			
		String sql="select count(*) from testpaper where uid=?";						
		int temp=0;
		dh=new DBHelp();
		try {
			ResultSet rs=dh.query(sql,uid);
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
	public List<TestPaper> selectTestPaper3(String tpid){
		dh=new DBHelp();
		String sql="SELECT testpaper.tpfull,testpaper.tpscore,lector.lcourse,exammanage.emtime,exammanage.emduration FROM testpaper INNER JOIN exammanage ON testpaper.emid = exammanage.emid INNER JOIN lector ON exammanage.lid=lector.lid where tpid=?";
		List<TestPaper> list=new ArrayList<TestPaper>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql,tpid);
			while(rs.next()){
				list.add(new TestPaper(rs.getFloat(1),rs.getFloat(2),new ExamManage(new Lector(rs.getString(3)),rs.getString(4),rs.getInt(5))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public List<TestPaper> selectScore(String emid,SubPage page){
		dh=new DBHelp();
		String sql="SELECT testpaper.tpid,users.uname,testpaper.tpfull,testpaper.tpscore,exammanage.emid,lector.lcourse,exammanage.emtime,exammanage.emduration FROM testpaper INNER JOIN users ON testpaper.uid = users.uid INNER JOIN exammanage ON testpaper.emid = exammanage.emid INNER JOIN lector ON exammanage.lid = lector.lid WHERE exammanage.emid=? limit ?,?";
		List<TestPaper> list=new ArrayList<TestPaper>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql, emid, page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new TestPaper(rs.getInt(1),new Users(rs.getString(2)), rs.getFloat(3), rs.getFloat(4), new ExamManage(rs.getInt(5),new Lector(rs.getString(6)),rs.getString(7),rs.getInt(8))));
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
	public int searchScoreCount(String emid){			
		String sql="select count(*) from testpaper where emid=?";						
		int temp=0;
		dh=new DBHelp();
		try {
			ResultSet rs=dh.query(sql,emid);
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

}
