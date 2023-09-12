package DAO;

import java.sql.ResultSet;
import java.sql.Statement;

import model.User;

public class UserDAO extends DBContext  {
	static int y;
	
	public  boolean login(User user) {
		
		String sql="select * from user where user.username='"+user.getUsername()+"' and pass='"+user.getPass()+"';";
		
		try {
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			if(rs.next()) {
				
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
	public  void register(User user) {
		
		String sql="insert into user(username,email,pass) values ('"+user.getUsername()+"','"+user.getEmail()+"','"+user.getPass()+"');";
		
		try {
			Statement st=c.createStatement();
			int rs=st.executeUpdate(sql);
		if(rs>0) {
			System.out.println("register success");
		}
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}
	public  boolean checkuser(String username) {
		
		String sql="select * from user where user.username='"+username+"';";
		
		try {
			Statement st=c.createStatement();
			
	ResultSet rs=st.executeQuery(sql);
			
			if(rs.next()) {
				
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}
	
	public  int getiduser(String username) {
		
		String sql="select * from user where user.username='"+username+"';";
	
		try {
			Statement st=c.createStatement();
			
	ResultSet rs=st.executeQuery(sql);
			
			if(rs.next()) {
				y=rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return y;
	}
	
	
	
	
	
	public static void main(String[] args) {
		UserDAO dao=new UserDAO();
	//	User user=new User("a", "", "1");
int e=dao.getiduser("a");
System.out.println(e);
		
	}
}
