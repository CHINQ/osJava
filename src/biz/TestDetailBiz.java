package biz;

import java.util.List;

import vo.TestDetail;
import dao.TestDetailDao;

public class TestDetailBiz {
	private TestDetailDao dao;

	public TestDetailBiz() {
		dao=new TestDetailDao();
	}
	public boolean addTestDetail(int tpid,String tid,String tppitch){
		int temp=dao.addTestDetail(tpid, tid, tppitch);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public List<TestDetail> selectTid(String tpid){
		return dao.selectTid(tpid);
	}

}
