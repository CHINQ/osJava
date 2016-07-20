package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.SubPage;
import vo.Users;
import vo.Words;
import dbutil.DBHelp;

public class WordsDao {

	private DBHelp hp;
	public List<Words> searchNowUserWords(String uid){
		List<Words> list=new ArrayList<Words>();
		hp=new DBHelp();
		String sql="select * from words where uid=?";
		try {
			ResultSet rs=hp.query(sql,uid);
			while(rs.next()){
				list.add(new Words(rs.getInt("wid"), new Users(rs.getString("uid")), rs.getString("wcontent"), rs.getString("wtime"), new Users(rs.getString("wtouid"))));
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
	public List<Words> searchNowUserWords(Users user,SubPage page){
		List<Words> list=new ArrayList<Words>();
		hp=new DBHelp();
		String sql="(select * from words";
		if("1".equals(user.getUpower())){
			sql+=" where uid=? order by wtime limit ?,?)ORDER BY wtime DESC";
		}else{
			sql+=" where wtouid=? order by wtime limit ?,?)ORDER BY wtime DESC";
		}
		try {
			ResultSet rs=hp.query(sql,user.getUid(),page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Words(rs.getInt("wid"), new Users(rs.getString("uid"),rs.getString("uid")), rs.getString("wcontent"), rs.getString("wtime"), new Users(rs.getString("wtouid"),rs.getString("wtouid"))));
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
	public int searchWordsCount(String uid){
		int temp=-1;
		hp=new DBHelp();
		String sql="select count(*) from words where wtouid=?";

		try {
			ResultSet rs=hp.query(sql, uid);
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
	public int addWords(Words wor){
		int temp=-1;
		hp=new DBHelp();
		String sql="insert into words(uid,wcontent,wtouid,wtime) values(?,?,?,?)";
		try {
			temp=hp.update(sql, wor.getUser().getUid(),wor.getWcontent(),wor.getToUser().getUid(),wor.getWtime());
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
	public int searchWordsCount(){
		hp=new DBHelp();
		String sql="select count(*) from words";
		int temp=0;
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
}
