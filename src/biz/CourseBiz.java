package biz;

import java.util.List;

import vo.Course;
import vo.SubPage;
import dao.CourseDao;

public class CourseBiz {
	private CourseDao dao;

	public CourseBiz() {
		dao=new CourseDao();
	}
	public List<Course> selectCourse(){
		return dao.selectCourse();
	}
			public List<Course> searchCourse(){
				return dao.searchCourse();
			}
			public List<Course> searchCourse(SubPage page){
				return dao.searchCourse(page);
			}
			public List<Course> searchCourse(SubPage page,String bnm,String btxt){
				if((bnm==null&&btxt==null)|| ("".equals(bnm)&&"".equals(btxt)) ){
					return dao.searchCourse(page);
				}else if(bnm==null || "".equals(bnm)){
					return dao.searchByBtext(page,btxt);
				}else if(btxt==null || "".equals(btxt)){
					return dao.searchByBname(page,bnm);				
				}else{
					return dao.searchByBnameAndBtext(page,bnm,btxt);
				}
				
			}
			public int searchCourseCount(String bnm,String btxt){
				return dao.searchCount(bnm,btxt);
			}
			public Course oneCourse(String cid){
				return dao.searchCourse(cid);
			}
			public boolean updateCourse(Course course){
				boolean flag=false;
				 int temp=dao.updateCourse(course);
				 if(temp>0){
					 return true;
				 }else{
					 return flag;
				 }
				 
			 }
			 public boolean deleteCourse(String cid){
				 boolean flag=false;
				 int temp=dao.deleteCourse(cid);
				 if(temp>0){
					 return true;
				 }else{
					 return flag;
				 }
			 }
			 public boolean addCourse(Course course){
					boolean flag=false;
					int temp=dao.addCourse(course);
					if(temp>0){
						flag=true;
					}
					return flag;		
				}
}
