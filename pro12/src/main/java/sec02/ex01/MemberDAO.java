package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	private PreparedStatement prstmt;
	private Connection conn;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx=new InitialContext();
			Context envContext=(Context) ctx.lookup("java:/comp/env");
			dataFactory =(DataSource) envContext.lookup("jdbc/oracle");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) {
		try {
		conn=dataFactory.getConnection();
		String query="delete from t_member where id='"+id+"'";
		prstmt=conn.prepareStatement(query);
		prstmt.executeUpdate();
		prstmt.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
		
}
	public void addMember(MemberVO memberVo) {
		try {
		conn=dataFactory.getConnection();
		String id=memberVo.getId();
		String pwd=memberVo.getPwd();
		String name=memberVo.getName();
		String email=memberVo.getEmail();
		String query="insert into t_member";
		query+="(id,pwd,name,email)";
		query+="values(?,?,?,?)";
		prstmt=conn.prepareStatement(query);
		prstmt.setString(1, id);
		prstmt.setString(2,pwd);
		prstmt.setString(3,name);
		prstmt.setString(4,email);
		prstmt.executeUpdate();
		prstmt.close();
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	public List listMembers(MemberVO memberVO){
		List list=new ArrayList();
		String _name=memberVO.getName();
		try {
			conn=dataFactory.getConnection();
			String query="select * from t_member";
			if((_name!=null && _name.length()!=0)) {
				query+=" where name=?";
				prstmt=conn.prepareStatement(query);
				prstmt.setString(1, _name);
			}else {
				prstmt=conn.prepareStatement(query);
			}
			System.out.println(query);
			ResultSet rs=prstmt.executeQuery();
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
			prstmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public boolean isExisted(MemberVO memberVO) {
		boolean result=false;
		String id=memberVO.getId();
		String pwd=memberVO.getPwd();
		try {
			conn=dataFactory.getConnection();
			String query="select decode(count(*),1,'true','false') as result from t_member";
					query +=" where id=? and pwd=?";
			prstmt=conn.prepareStatement(query);
			prstmt.setString(1, id);
			prstmt.setString(2, pwd);
			ResultSet rs=prstmt.executeQuery();
			System.out.println("sdadsasd");
			rs.next();
			result=Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result="+result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
