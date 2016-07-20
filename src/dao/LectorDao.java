package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Lector;
import vo.SubPage;
import vo.Users;
import dbutil.DBHelp;

public class LectorDao {
	private DBHelp dh;
	public List<Lector> selectLector(){
		dh=new DBHelp();
		String sql="select lid,lector.uid,lcourse,uname,utext,uimage from lector join users on users.uid=lector.uid";
		List<Lector> list=new ArrayList<Lector>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql);
			while(rs.next()){
				list.add(new Lector(rs.getInt(1),new Users(rs.getString(2),rs.getString("uname"),rs.getString("uimage"),rs.getString("utext")),rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Lector> selectLector(SubPage subPage){
		dh=new DBHelp();
		String sql="select lid,lector.uid,lcourse,uname,utext,uimage from lector join users on users.uid=lector.uid limit ?,?";
		List<Lector> list=new ArrayList<Lector>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql,subPage.getStartIndex(),subPage.getShowNumber());
			while(rs.next()){
				list.add(new Lector(rs.getInt(1),new Users(rs.getString(2),rs.getString("uname"),rs.getString("uimage"),rs.getString("utext")),rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Lector> search(){
		String sql="select lid,lcourse from lector";
		dh=new DBHelp();
		List<Lector> list=new ArrayList<Lector>();
		try {
			ResultSet rs=dh.query(sql);
			while(rs.next()){
				list.add(new Lector(rs.getInt(1),rs.getString(2)));
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
	public int searchCount(String uid){			
		String sql="SELECT COUNT(*) from lector WHERE lector.uid=?";				
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
	public Lector searchOneLector(String lid){
		String sql="select lid,users.uid,users.uname,lcourse from lector join users on users.uid=lector.uid";
		dh=new DBHelp();
		Lector lector=null;
		try {
			ResultSet rs=dh.query(sql);
			while(rs.next()){
				lector=new Lector(rs.getInt(1),new Users(rs.getString(2), rs.getString(3)),rs.getString(4));
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

		return lector;
	}
	public int lectorCount(){
		String sql="SELECT COUNT(*) from lector";				
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

}
