package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.SubPage;
import vo.Test;
import dbutil.DBHelp;

public class TestDao {
	private DBHelp dh;
	public List<Test> selectTest(String tid){
		dh=new DBHelp();
		String sql="select tid,title,truekey,tanalyze from test where tid in("+tid+")";
		List<Test> list=new ArrayList<Test>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql);
			while(rs.next()){
				list.add(new Test(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
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
	public List<Test> selectOneTest(String tid){
		dh=new DBHelp();
		String sql="select tid,title,truekey,tanalyze from test where tid=?";
		List<Test> list=new ArrayList<Test>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql,tid);
			while(rs.next()){
				list.add(new Test(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
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
	public List<Test> selectTest(SubPage page){
		dh=new DBHelp();
		String sql="select tid,title,truekey,tanalyze from test limit ?,?";
		List<Test> list=new ArrayList<Test>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Test(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
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
		String sql="select count(*) from test";						
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
	public int updateTruekey(String title,String truekey,String tid){
		dh=new DBHelp();
		String sql="update test SET title=?,truekey=? where tid=?";
		int temp=-1;
		try {
			temp=dh.insert(sql, title,truekey,tid);
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
	public int addTest(String title,String truekey,String ttime){
		dh=new DBHelp();
		String sql="insert into test(title,truekey,ttime) values(?,?,?)";
		int temp=-1;
		try {
			temp=dh.insert(sql, title,truekey, ttime);
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
	public int searchOneTid(String ttime){			
		String sql="select tid from test where ttime=?";						
		int temp=0;
		dh=new DBHelp();
		try {
			ResultSet rs=dh.query(sql,ttime);
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



