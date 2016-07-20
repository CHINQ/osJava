package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.TestDetail;
import dbutil.DBHelp;

public class TestDetailDao {
	private DBHelp dh;
	public int addTestDetail(int tpid,String tid,String tppitch){
		dh=new DBHelp();
		String sql="insert into testdetail(tpid,tid,tppitch) values(?,?,?)";
		int temp=-1;
		try {
			temp=dh.insert(sql,tpid,tid,tppitch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	public List<TestDetail> selectTid(String tpid){
		dh=new DBHelp();
		String sql="SELECT testdetail.tid,testdetail.tppitch FROM testpaper INNER JOIN testdetail ON testdetail.tpid = testpaper.tpid WHERE testpaper.tpid=?";
		List<TestDetail> list=new ArrayList<TestDetail>();
		ResultSet rs=null;
		try {
			rs=dh.query(sql, tpid);
			while(rs.next()){
				list.add(new TestDetail(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dh.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
}
