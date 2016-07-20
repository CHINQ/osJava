package biz;

import java.util.List;

import vo.ExamManage;
import vo.SubPage;
import dao.ExamManageDao;

public class ExamManageBiz {
	private ExamManageDao dao;

	public ExamManageBiz(){
		dao=new ExamManageDao();
	}
	public List<ExamManage> selectExamManage(){
		return dao.selectExamManage();
	}
	public List<ExamManage> selectExamManage(String emid){
		return dao.selectExamManage(emid);
	}
	public List<ExamManage> selectExamManage(SubPage page){
		return dao.selectExamManage(page);
	}
	public List<ExamManage> selectExamManage2(SubPage page){
		return dao.selectExamManage2(page);
	}
	public boolean addExamManage(String lid,String emtime,String emduration,float emfull,int emstate){
		int temp=dao.addExamManage(lid, emtime, emduration,emfull,emstate);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateExamManage(String emid){
		int temp=dao.updateExamManage(emid);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateExamManage(String lid,String emtime,String emduration,String emid){
		int temp=dao.updateExamManage(lid, emtime, emduration, emid);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public int searchCount(){
		return dao.searchCount();
	}
	public int searchCount2(){
		return dao.searchCount2();
	}
	public List<ExamManage> selectALLExam(){
		return dao.selectALLExam();
	}
	public boolean updateExamManage(int emoverdue,int emid){
		int temp=dao.updateExamManage(emoverdue, emid);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public List<ExamManage> selectCourse(String uid,SubPage page){
		return dao.selectCourse(uid, page);
	}
	
}




