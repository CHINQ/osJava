package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Friend;
import vo.Users;
import dbutil.DBHelp;

public class FriendDao {

	private DBHelp hp;
	public List<Friend> searchFriendAsOneUser(String uid_ben){
		List<Friend> list=new ArrayList<Friend>();
		hp=new DBHelp();
		String sql="select fid,friend.ubid,friend.uid,users.uname from friend join users on friend.ubid=users.uid where ubid=?";
		try {
			ResultSet rs=hp.query(sql, uid_ben);
			while(rs.next()){
				list.add(new Friend(rs.getInt("fid"), new Users(rs.getString("uid"),rs.getString("uid")), new Users(rs.getString("friend.ubid"),rs.getString("users.uname"))));
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
	public List<Friend> searchAllFriend(){
		List<Friend> list=new ArrayList<Friend>();
		hp=new DBHelp();
		String sql="select fid,friend.ubid,friend.uid,users.uname from friend join users on friend.ubid=users.uid";
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Friend(rs.getInt("fid"), new Users(rs.getString("uid"),rs.getString("uid")), new Users(rs.getString("friend.ubid"),rs.getString("users.uname"))));
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
	public int addFriend(Friend fri){
		int temp=-1;
		hp=new DBHelp();
		String sql="insert into friend(ubid,uid) values(?,?)";
		try {
			temp=hp.update(sql,fri.getUser_ben().getUid(),fri.getUser().getUid());
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
	public int deleteFriend(String uid){
		int temp=-1;
		hp=new DBHelp();
		String sql="delete from friend where uid=?";
		try {
			temp=hp.update(sql, uid);
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
