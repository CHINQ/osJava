package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Books;
import vo.SubPage;
import dbutil.DBHelp;

public class BooksDao {
	private DBHelp hp;
	public List<Books> search(){
		String sql="select * from books";
		hp=new DBHelp();
		List<Books>list=new ArrayList<Books>();
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Books(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<Books> search(SubPage page){
		String sql="select * from books  limit ?,?";
		hp=new DBHelp();
		List<Books> list=new ArrayList<Books>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Books(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Books> searchByBname(SubPage page,String bnm){
		String sql="select * from books where bname like '%"+bnm+"%' limit ?,?";
		hp=new DBHelp();
		List<Books> list=new ArrayList<Books>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Books(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Books> searchByBtext(SubPage page,String btxt){
		String sql="select * from books where btext like '%"+btxt+"%' limit ?,?";
		hp=new DBHelp();
		List<Books> list=new ArrayList<Books>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Books(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Books> searchByBnameAndBtext(SubPage page,String bnm,String btxt){
		String sql="select * from books where btext like '%"+btxt+"%' and bname like '%"+bnm+"%' limit ?,?";
		hp=new DBHelp();
		List<Books> list=new ArrayList<Books>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Books(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public Books search(String bid){
		String sql="select * from books  where bid="+bid;
		hp=new DBHelp();
		Books book=null;
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				book=new Books(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return book;
	}
	public int searchCount(String bnm,String btxt){
		String sql="select count(*) from books where bid!=0 ";
		if(bnm!=null&& !"".equals(bnm)){
			sql+=" and bname like '%"+bnm+"%'";
		}
		if(btxt!=null && !"".equals(btxt)){
			sql+=" and btext like '%"+btxt+"%'";
		}
		int temp=0;
		hp=new DBHelp();
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	public int insert(Books books){
		int temp=-1;
		String sql="insert into books(bname,btext,btime,bimage,baddress,uid) values(?,?,?,?,?,?)";
		hp=new DBHelp();
		try {
			temp=hp.insert(sql,books.getBname(),books.getBtext(),books.getBtime(),books.getBimage(),books.getBaddress(),books.getUid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	public int delete(String bid){
		String sql="delete from books where bid="+bid;
		hp=new DBHelp();
		int temp=-1;
		try {
			temp=hp.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	public int update(Books books){
		String sql="UPDATE books set bname=?,btext=?,bimage=?,baddress=?where bid="+books.getBid();
		int temp=-1;
		hp=new DBHelp();
		try {
			temp=hp.insert(sql,books.getBname(),books.getBtext(),books.getBimage(),books.getBaddress());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}

}
