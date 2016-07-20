package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Posting;
import vo.Reply;
import vo.SubPage;
import vo.Users;
import dbutil.DBHelp;

public class ReplyDao {

	private DBHelp hp;
	public List<Reply> searchSomeOnesOwnReply(String pid){
		hp=new DBHelp();
		String sql="select rid,reply.uid,uimage,utext,pid,rcontent,rtime from reply join users on users.uid=reply.uid where pid="+pid;
		List<Reply> list = new ArrayList<Reply>();
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Reply(rs.getInt("rid"), new Users(rs.getString("uid"),rs.getString("uimage"),rs.getString("utext")), new Posting(rs.getInt("pid")), rs.getString("rcontent"), rs.getString("rtime")));
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
	public int replyCount(int pid){
		hp=new DBHelp();
		String sql="select count(*) from reply where pid=?";
		int temp=0;
		try {
			ResultSet rs=hp.query(sql, pid);
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
	public int addReply(Reply reply){
		hp=new DBHelp();
		String sql="insert into reply(uid,pid,rcontent,rtime) values(?,?,?,?)";
		int temp=-1;
		try {
			temp=hp.update(sql,reply.getUser().getUid(),reply.getPost().getPid(),reply.getRcontent(),reply.getRtime());
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
	public int deleteReply(String pid){
		hp=new DBHelp();
		int temp=-1;
		String sql="delete from reply where pid=?";
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
	public List<Reply> searchSomeOnesOwnReply(String pid,SubPage page){
		hp=new DBHelp();
		String sql="select rid,reply.uid,uimage,utext,pid,rcontent,rtime from reply join users on users.uid=reply.uid where pid="+pid+" limit ?,?";
		List<Reply> list = new ArrayList<Reply>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Reply(rs.getInt("rid"), new Users(rs.getString("uid"),rs.getString("uimage"),rs.getString("utext")), new Posting(rs.getInt("pid")), rs.getString("rcontent"), rs.getString("rtime")));
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
}
