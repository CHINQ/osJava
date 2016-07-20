package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Option;
import vo.Test;
import dbutil.DBHelp;

public class OptionDao {
	private DBHelp dh;
	public List<Option> selectOption(String tid){
		dh=new DBHelp();
		String sql="select * from options where tid in("+tid+")";
		List<Option> list=new ArrayList<Option>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql);
			while(rs.next()){
				list.add(new Option(rs.getString(1),new Test(rs.getInt(2)),rs.getString(3)));
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
	public List<Option> selectOneOption(String tid){
		dh=new DBHelp();
		String sql="select * from options where tid=?";
		List<Option> list=new ArrayList<Option>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql,tid);
			while(rs.next()){
				list.add(new Option(rs.getString(1),new Test(rs.getInt(2)),rs.getString(3)));
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
	public List<Option> selectOption(){
		dh=new DBHelp();
		String sql="select * from options";
		List<Option> list=new ArrayList<Option>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql);
			while(rs.next()){
				list.add(new Option(rs.getString(1),new Test(rs.getInt(2)),rs.getString(3)));
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
	public int updateA(String A,String tid){
		dh=new DBHelp();
		String sql="update `options` SET ocontent=? where oid='A' and tid=?";
		int temp=-1;
		try {
			temp=dh.insert(sql, A,tid);
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
	public int updateB(String B,String tid){
		dh=new DBHelp();
		String sql="update `options` SET ocontent=? where oid='B' and tid=?";
		int temp=-1;
		try {
			temp=dh.insert(sql, B,tid);
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
	public int updateC(String C,String tid){
		dh=new DBHelp();
		String sql="update `options` SET ocontent=? where oid='C' and tid=?";
		int temp=-1;
		try {
			temp=dh.insert(sql, C,tid);
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
	public int updateD(String D,String tid){
		dh=new DBHelp();
		String sql="update `options` SET ocontent=? where oid='D' and tid=?";
		int temp=-1;
		try {
			temp=dh.insert(sql, D,tid);
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
	public int addA(String oidA,String tid,String A){
		dh=new DBHelp();
		String sql="insert into `options`(oid,tid,ocontent) values(?,?,?)";
		int temp=-1;
		try {
			temp=dh.insert(sql, oidA,tid, A);
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
	public int addB(String oidB,String tid,String B){
		dh=new DBHelp();
		String sql="insert into `options`(oid,tid,ocontent) values(?,?,?)";
		int temp=-1;
		try {
			temp=dh.insert(sql, oidB,tid, B);
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
	public int addC(String oidC,String tid,String C){
		dh=new DBHelp();
		String sql="insert into `options`(oid,tid,ocontent) values(?,?,?)";
		int temp=-1;
		try {
			temp=dh.insert(sql, oidC,tid, C);
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
	public int addD(String oidD,String tid,String D){
		dh=new DBHelp();
		String sql="insert into `options`(oid,tid,ocontent) values(?,?,?)";
		int temp=-1;
		try {
			temp=dh.insert(sql, oidD,tid, D);
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







