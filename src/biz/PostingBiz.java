package biz;

import java.util.List;

import vo.Posting;
import dao.PostingDao;
import dao.ReplyDao;

public class PostingBiz {

	private PostingDao dao;
	private ReplyDao rdao;
	public PostingBiz(){
		dao=new PostingDao();
		rdao=new ReplyDao();
	}
	public int searchPostingCount(){
		return dao.searchPostingCount();
	}
	public int searchPostingCount(String uid){
		return dao.searchPostingCount(uid);
	}
	public List<Posting> searchAllPosting(){
		List<Posting> list=dao.searchAllPosting();
		for(int i=0;i<list.size();i++){
			Posting po=list.get(i);
			po.setPrcount(rdao.replyCount(po.getPid()));
			list.set(i,po);			
		}
		return list;
	}
	public Posting searchOnePosting(String pid){
		return dao.searchOnePosting(pid);
	}
	public List<Posting> searchAllPosting(String uid){
		return dao.searchAllPosting(uid);
	}
	
	public boolean addNewPosting(Posting post){
		boolean flag=false;
		if(dao.addNewPosting(post)>0){
			flag=true;
		}
		return flag;
	}
	public boolean changePosting(Posting post){
		boolean flag=false;
		if(dao.changePosting(post)>0){
			flag=true;
		}
		return flag;
	}
	public boolean deleteMyPosting(String pid){
		boolean flag=false;
		if(rdao.deleteReply(pid)>0){
			if(dao.delteMyPosting(pid)>0){
				flag=true;
			}
		}
		return flag;
	}
}
