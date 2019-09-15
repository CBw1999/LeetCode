
package CBw.connect;
 
import java.sql.*;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.*;

public class connect {
	//连接数据库
	private Connection connect() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "123456";
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//插入学生的数据
	public boolean insertInfo(String id,String name, String course1, String course1_score, String course2,String course2_score) throws SQLException {
		Connection conn = connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		System.out.println(id+" "+name);
		
		String sql = "select id from stu_score where id = ?;";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(id));
		
		rs = ps.executeQuery();
		if(rs.next()) {
			return false;
		}
		int t_score1=Integer.parseInt(course1_score);
		int t_score2=Integer.parseInt(course2_score);
		int t_score=t_score1+t_score2;
		
		sql = "insert into stu_score values(?, ?,"+
				" '{\""+ course1+"\":"+course1_score+
				",\""+ course2+"\":"+course2_score+
				",\"total\":"+t_score+
				"}' "+
				 ");";
		
		ps = conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(id));
		ps.setString(2,name);
		int flag = ps.executeUpdate();
		if(flag != 0) {
			return true;
		}
		return false;
	}
	
	public Map<String,String> getStuScore(String Id) throws SQLException {
		Connection conn = connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,String> map = new HashMap<String, String>();
			String sql = "select * from jsonb_each_text( (select score from stu_score where id=?) ); ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(Id));
			rs = ps.executeQuery();
			String key = null;
			String value = null;
			while(rs.next()) {
				key = rs.getString(1);
				value = rs.getString(2);
				map.put(key, value);
			}
			System.out.println(map);

			return map;
		}
}

