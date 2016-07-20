package biz;

import java.util.List;

import vo.SelectCourse;
import vo.SubPage;
import dao.SelectCourseDao;

public class SelectCourseBiz {
	
	private SelectCourseDao dao;
	public SelectCourseBiz(){
		dao=new SelectCourseDao();
	}
	
	public List<SelectCourse> searchSelectCourse(){
		return dao.search();
	}
	public List<SelectCourse>searchSelectCourse(SubPage page){
		return dao.search(page);
	}
	public List<SelectCourse>searchSelectCourse(SubPage page,String snm,String stxt){
		if((snm==null&&stxt==null)||("".equals(snm)&&"".equals(stxt))){
			return dao.search(page);
		}else if(snm==null||"".equals(snm)){
			return dao.searchByStext(page, stxt);
		}else if(stxt==null||"".equals(stxt)){
			return dao.searchBySname(page, snm);
		}else{
			return dao.searchBySnameAndStext(page, snm, stxt);
		}
	}
	public SelectCourse searchSelectCourse(String uid){
		return dao.search(uid);
	}
	public List<SelectCourse> searchSelectCourse2(String uid){
		return dao.search2(uid);
	}
	public int searchSelectCourseCount(String snm,String stxt){
		return dao.searchCount(snm,stxt);
	}
	public boolean searchSelectCourse(String cid,String uid){
		boolean flag=false;
		int temp=dao.searchSelectCourse(cid,uid);		
		if(temp>0){
			flag=true;
		}
		return flag;		
	}

}
