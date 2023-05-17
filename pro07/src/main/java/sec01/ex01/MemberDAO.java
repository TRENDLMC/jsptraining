package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String dirver="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user="hr";
	private static final String pwd="12345";
	
	private Statement stmt;
	private Connection conn;
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list=new ArrayList<MemberVO>();
		try {
			connDB();
			String query="select * from t_member";
			System.out.println(query);
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				String id=rs.getString("id");
				String pwd=rs.getString("pwd");
				String name=rs.getString("name");
				String email=rs.getString("email");
				Date joinDate=rs.getDate("joinDate");
				MemberVO vo= new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setEmail(email);
				vo.setName(name);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void connDB() {
		try {
	Class.forName(dirver);
	System.out.println("오라클 드라이버 로딩성공");
	conn=DriverManager.getConnection(url,user,pwd);
	System.out.println("커넥션 생성 성공");
	stmt=conn.createStatement();
	System.out.println("statement 생성성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
