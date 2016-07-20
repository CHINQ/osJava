package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelp {

	private final String DRIVER="com.mysql.jdbc.Driver";
	private final String URL="jdbc:mysql://127.0.0.1:3306/learn";
	private final String USER="root";
	private final String PASS="123456789";
	private Connection conn;
	private Statement stmt;
	private PreparedStatement prep;

	public DBHelp() {
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int insert(String sql,Object ...arr) throws SQLException{
		prep=conn.prepareStatement(sql);
		for(int i=1;i<=arr.length;i++){
			prep.setObject(i,arr[i-1]);
		}
		int temp=prep.executeUpdate();
		return temp;
	}

	public ResultSet query(String sql) throws SQLException{
		stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		return rs;

	}
	public ResultSet query(String sql,Object ... arr) throws SQLException{
		prep=conn.prepareStatement(sql);
		for(int i=0;i<arr.length;i++){
			prep.setObject(i+1, arr[i]);
		}
		return prep.executeQuery();
	}
	public void close() throws SQLException{
		if(prep!=null && !prep.isClosed())prep.close();
		if(stmt!=null && !stmt.isClosed())stmt.close();
		if(conn!=null && !conn.isClosed())conn.close();
	}
	public int update(String sql,Object ... arr) throws SQLException{
		prep=conn.prepareStatement(sql);
		for(int i=0;i<arr.length;i++){
			prep.setObject(i+1, arr[i]);
		}
		int temp = prep.executeUpdate();
		return temp;
	}

}
