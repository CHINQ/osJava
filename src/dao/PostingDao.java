package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Posting;
import vo.Users;
import dbutil.DBHelp;

public class PostingDao {

	private DBHelp hp;
	public int searchPostingCount(){
		hp=new DBHelp();
		String sql="select count(*) from posting";
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
	public int searchPostingCount(String uid){
		hp=new DBHelp();
		String sql="select count(*) from posting where uid=?";
		int temp=0;
		try {
			ResultSet rs=hp.query(sql,uid);
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
	public List<Posting> searchAllPosting(){
		List<Posting> list=new ArrayList<Posting>();
		hp=new DBHelp();
		String sql2="select count(*) from reply where pid=?";
		String sql="select * from posting order by ptime DESC";
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Posting(rs.getInt(1),new Users(rs.getString(2)),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Posting searchOnePosting(String pid){
		Posting post=new Posting();
		hp=new DBHelp();
		String sql="select * from posting where pid="+pid;
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				post=new Posting(rs.getInt(1),new Users(rs.getString(2)),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}
	public List<Posting> searchAllPosting(String uid){
		List<Posting> list=new ArrayList<Posting>();
		hp=new DBHelp();
		String sql="select * from posting where uid=?";
		try {
			ResultSet rs=hp.query(sql,uid);
			while(rs.next()){
				list.add(new Posting(rs.getInt(1),new Users(rs.getString(2)),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int addNewPosting(Posting post){
		hp=new DBHelp();
		int temp=-1;
		String sql="insert into posting(uid,ptitle,pcontent,ptime,pimage) values(?,?,?,?,?)";
		try {
			temp=hp.update(sql,post.getUser().getUid(),post.getPtitle(),post.getPcontent(),post.getPtime(),post.getPimage());
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
	public int changePosting(Posting post){
		hp=new DBHelp();
		int temp=-1;
		String sql="update posting set pcount=?,prcount=? where pid=?";
		try {
			temp=hp.update(sql,post.getPcount(),post.getPrcount(),post.getPid());
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
	public int delteMyPosting(String pid){
		hp=new DBHelp();
		int temp=-1;
		String sql="delete from posting where pid=?";
		try {
			temp=hp.update(sql,pid);
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
