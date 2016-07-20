package biz;

import java.util.List;

import vo.Lector;
import vo.SubPage;
import dao.LectorDao;

public class LectorBiz {
	private LectorDao dao;

	public LectorBiz() {
		dao=new LectorDao();
	}
	public List<Lector> selectLector(){
		return dao.selectLector();
	}
	public List<Lector> getAllLcourse(){
		return dao.search();
	}
	public List<Lector> selectLector(SubPage subPage){
		return dao.selectLector(subPage);
	}
	public int searchCount(String uid){
		return dao.searchCount(uid);
	}
	public Lector searchOneLector(String lid){
		return dao.searchOneLector(lid);
	}
	public int lectorCount(){
		return dao.lectorCount();
	}
}
