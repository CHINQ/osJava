package biz;

import java.util.List;

import vo.Reply;
import vo.SubPage;
import dao.ReplyDao;

public class ReplyBiz {

	private ReplyDao dao;
	public ReplyBiz(){
		dao=new ReplyDao();
	}
	public List<Reply> searchSomeOnesOwnReply(String pid){

		return dao.searchSomeOnesOwnReply(pid);
	}
	public boolean addReply(Reply reply){
		boolean flag=false;
		if(dao.addReply(reply)>0){
			flag=true;
		}
		return flag;
	}
	public List<Reply> searchSomeOnesOwnReply(String pid,SubPage page){

		return dao.searchSomeOnesOwnReply(pid,page);
	}
	public int replyCount(int pid){
		return dao.replyCount(pid);
	}
}
