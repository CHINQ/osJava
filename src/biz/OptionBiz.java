package biz;

import java.util.List;

import vo.Option;
import dao.OptionDao;

public class OptionBiz {
	private OptionDao dao;

	public OptionBiz() {
		dao=new OptionDao();
	}
	public List<Option> selectOption(String tid){
		return dao.selectOption(tid);
	}
	public List<Option> selectOneOption(String tid){
		return dao.selectOneOption(tid);
	}
	public List<Option> selectOption(){
		return dao.selectOption();
	}
	public boolean updateA(String A,String tid){
		int temp=dao.updateA(A, tid);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateB(String B,String tid){
		int temp=dao.updateB(B, tid);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateC(String C,String tid){
		int temp=dao.updateC(C, tid);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean updateD(String D,String tid){
		int temp=dao.updateD(D, tid);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean addA(String oidA,String tid,String A){
		int temp=dao.addA(oidA, tid, A);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean addB(String oidB,String tid,String B){
		int temp=dao.addB(oidB, tid, B);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean addC(String oidC,String tid,String C){
		int temp=dao.addC(oidC, tid, C);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	public boolean addD(String oidD,String tid,String D){
		int temp=dao.addD(oidD, tid, D);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}

}
