package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Menu;
import vo.Users;
import dbutil.DBHelp;

public class MenuDao {
	private DBHelp dh;
	public List<Menu> selectMenu(Users user){
		dh=new DBHelp();
		String sql="select * from menu";
		if("0".equals(user.getUpower())){
			sql+=" where mid in(11,8,9,10,12,14,17)";
		}else if("10".equals(user.getUpower())){
			sql+=" where mid in(1,2,3,13,12,6,7)";
		}else if("1".equals(user.getUpower())){
			sql+=" where mid in(1,2,3,4,5,6,7)";
		}
		List<Menu> list=new ArrayList<Menu>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql);
			while(rs.next()){
				list.add(new Menu(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
