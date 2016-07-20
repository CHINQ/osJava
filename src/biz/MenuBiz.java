package biz;

import java.util.List;

import vo.Menu;
import vo.Users;
import dao.MenuDao;

public class MenuBiz {
	private MenuDao dao;

	public MenuBiz() {
		dao=new MenuDao();
	}
	public List<Menu> selectMenu(Users user){
		return dao.selectMenu(user);
	}

}
