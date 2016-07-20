package biz;

import java.util.List;

import vo.SubPage;
import vo.TestPaper;
import dao.TestPaperDao;

public class TestPaperBiz {
	private TestPaperDao dao;

	public TestPaperBiz() {
		dao=new TestPaperDao();
	}
	public boolean addTestPaper(String uid,float fullScore,float score,String emid,String tpdate){
		int temp=dao.addTestPaper(uid, fullScore, score, emid,tpdate);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public List<TestPaper> selectTestPaper(String tpdate){
		return dao.selectTestPaper(tpdate);
	}
	public List<TestPaper> selectTestPaper2(String uid){
		return dao.selectTestPaper2(uid);
	}
	public List<TestPaper> selectTestPaper2(String uid,SubPage page){
		return dao.selectTestPaper2(uid, page);
	}
	public int searchCount(String uid){
		return dao.searchCount(uid);
	}
	public List<TestPaper> selectTestPaper3(String tpid){
		return dao.selectTestPaper3(tpid);
	}
	public List<TestPaper> selectScore(String emid,SubPage page){
		return dao.selectScore(emid, page);
	}
	public int searchScoreCount(String emid){
		return dao.searchScoreCount(emid);
	}
	
}
