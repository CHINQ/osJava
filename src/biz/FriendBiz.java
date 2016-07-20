package biz;

import java.util.List;

import vo.Friend;
import dao.FriendDao;

public class FriendBiz {

	private FriendDao dao;
	public FriendBiz(){
		dao=new FriendDao();
	}
     public List<Friend> searchFriendAsOneUser(String uid_ben){
		return dao.searchFriendAsOneUser(uid_ben);
	}
	public List<Friend> searchAllFriend(){
		return dao.searchAllFriend();
	}
	public boolean addFriend(Friend fri){
		boolean flag=false;
		if(dao.addFriend(fri)>0){
			flag=true;
		}
		return flag;
	}
	public boolean deleteFriend(String uid){
		boolean flag=false;
		if(dao.deleteFriend(uid)>0){
			flag=true;
		}
		return flag;
	}
}
