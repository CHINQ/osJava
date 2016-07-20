package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Message;
import vo.SubPage;
import vo.Users;
import dbutil.DBHelp;

public class MessageDao {

	private DBHelp hp;
	public List<Message> searchAllMessage(SubPage page){
		List<Message> list=new ArrayList<Message>();
		hp=new DBHelp();
		String sql="(select mid,message.uid,mtitle,mcontent,mtime,uname from message join users on message.uid=users.uid order by mid limit ?,? )order by mtime desc";
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Message(rs.getInt("mid"), new Users(rs.getString("uid"),rs.getString("uname")), rs.getString("mtitle"), rs.getString("mcontent"), rs.getString("mtime")));
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
	public List<Message> searchAllMessage(){
		List<Message> list=new ArrayList<Message>();
		hp=new DBHelp();
		String sql="select mid,message.uid,mtitle,mcontent,mtime,uname from message join users on message.uid=users.uid order by mtime desc";
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Message(rs.getInt("mid"), new Users(rs.getString("uid"),rs.getString("uname")), rs.getString("mtitle"), rs.getString("mcontent"), rs.getString("mtime")));
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
	public Message searchOneMessage(String mid){
		Message oneMessage=null;
		hp=new DBHelp();
		String sql="select mid,message.uid,mtitle,mcontent,mtime,uname from message join users on message.uid=users.uid where mid=?";
		try {
			ResultSet rs=hp.query(sql,mid);
			if(rs.next()){
				oneMessage=new Message(rs.getInt("mid"), new Users(rs.getString("uid"),rs.getString("uname")), rs.getString("mtitle"), rs.getString("mcontent"), rs.getString("mtime"));
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
		return oneMessage;
	}
	public int changeMessage(Message mes){
		int temp=-1;
		hp=new DBHelp();
		String sql="update message set mtitle=?,mcontent=?,mtime=? where mid=?";
		try {
			temp=hp.update(sql, mes.getMtitle(),mes.getMcontent(),mes.getMtime(),mes.getMid());
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
	public int deleteMessage(String mid){
		int temp=-1;
		hp=new DBHelp();
		String sql="delete from message where mid=?";
		try {
			temp=hp.update(sql,mid);
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
	public int addNewMessage(Message mes){
		int temp=-1;
		hp=new DBHelp();
		String sql="insert into message(uid, mtitle, mcontent,mtime) values(?,?,?,?)";
		try {
			temp=hp.update(sql,mes.getUser().getUid(),mes.getMtitle(),mes.getMcontent(),mes.getMtime());
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
	public int searchMessageCount(){
		int temp=0;
		hp=new DBHelp();
		String sql="select count(*) from message";
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
