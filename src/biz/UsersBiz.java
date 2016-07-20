package biz;

import java.io.File;
import java.util.List;

import vo.SubPage;
import vo.Users;
import dao.UsersDao;

public class UsersBiz {
	public UsersDao dao;
	public UsersBiz(){
		dao=new UsersDao();
	}
	public Users login(String name,String pass){
		Users users=dao.search(name,pass);
		return users;
	}

	public boolean addUsers(Users users){
		int temp=dao.insert(users);
		if(temp>0){
			return true;
		}else {
			return false;
		}
	}
	public boolean addUsers1(Users users){
		int temp=dao.insert1(users);
		if(temp>0){
			return true;
		}else {
			return false;
		}
	}
	public List<Users> searchUsers1(String uid) {
		return  dao.searchUsers1(uid);
	}
	public List<Users> searchUsers() {
		return  dao.searchUsers();
	}
	public List<Users> searchUsers(String uid) {
		return  dao.searchUsers();
	}
	public List<Users>  getAllUname() {

		return  dao.searchUsers();
	}
	public boolean updateUsers(Users users,String path){

		Users oldUsers=dao.searchUsers(users.getUid()+"");
		int temp=-1;
		if(users.getUimage()==null){
			users.setUimage(oldUsers.getUimage());
			temp=dao.updateUsers(users);

		}else{
			temp=dao.updateUsers(users);

			if(temp>0){
				String filePath=path+oldUsers.getUimage();
				File file=new File(filePath);
				if(file.exists()){
					file.delete();
				}
			}
		}
		if(temp>0){
			return true;
		}else{
			return false;
		}

	}
	public boolean updateUpass(String pass,String uid){
		int temp=dao.updateUpass(pass,uid);
		if(temp>0){
			return true;
		}else {
			return false;
		}

	}
	public boolean updanewUsers(String uid){
		int temp=dao.updanewUsers(uid);
		if(temp>0){
			return true;
		}else {
			return false;
		}

	}
	public Users searchOneUser(String uid){
		return dao.searchUsers(uid);
	}
	public int searchUsersCount(String bnm,String btxt){
		return dao.searchCount(bnm,btxt);
	}

	public List<Users> searchUsers1() {
		return  dao.searchUsers1();
	}

	public List<Users> searchUser(SubPage page,String bnm,String btxt){
		if((bnm==null&&btxt==null)|| ("".equals(bnm)&&"".equals(btxt)) ){
			return dao.search(page);
		}else if(bnm==null || "".equals(bnm)){
			return dao.searchByBtext(page,btxt);
		}else if(btxt==null || "".equals(btxt)){
			return dao.searchByBname(page,bnm);

		}else{
			return dao.searchByBnameAndBtext(page,bnm,btxt);
		}

	}
	public boolean delUsers(String uid,String path){
		Users  users=dao.search(uid);  
		String addresss=users.getUimage();
		int temp=dao.delete(uid);	
							if(temp>0){
								if("".equals(users.getUimage())){//users.getUimage().equals(null)
									return false;
								}else{
								String filePath=path+addresss;
								File file=new File(filePath);
								if(file.exists()){
									file.delete();
								}											
								return true;								
							}}else{
								return false;
							}
	}
}
