package biz;

import java.util.List;

import vo.SubPage;
import vo.Test;
import dao.TestDao;

public class TestBiz {
	private TestDao dao;
	public TestBiz(){
		dao=new TestDao();
	}
	public List<Test> selectTest(String tid){
		return dao.selectTest(tid);
	}
	public List<Test> selectOneTest(String tid){
		return dao.selectOneTest(tid);
	}
	public List<Test> selectTest(SubPage page){
		return dao.selectTest(page);
	}
	public int searchCount(){
		return dao.searchCount();
	}
	public boolean updateTruekey(String title,String truekey,String tid){
		int temp=dao.updateTruekey(title, truekey, tid);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean addTest(String title,String truekey,String ttime){
		int temp=dao.addTest(title, truekey, ttime);
		if(temp>0){
			return true;
		}else{
			return false;
		} 
	}
	public int searchOneTid(String ttime){
		return dao.searchOneTid(ttime);
	}

}
