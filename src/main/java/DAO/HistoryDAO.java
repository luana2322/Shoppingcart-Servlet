package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


import model.History;

public class HistoryDAO extends DBContext {
	List<History> list;
	
	public void insert(List<History> list1) {
		for (History h : list1) {
			
		
		String sql="INSERT INTO history (id_user, ma_san_pham, quantity, total, ngay_mua) "
				+ "VALUES ("+h.getId_user()+", "+h.getMa_san_pham()+","+h.getQuantity()+ ","+h.getTotal()+" , '"+h.getDate()+"');";
		
		
		try {
			Statement st=c.createStatement();
			int rs=st.executeUpdate(sql);
			
			if(rs>0) {
				System.out.println("insert success!!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
		
	}
	
	public List<History> getlist(){
		String sql="select * from history;";
		list=new ArrayList<>();
		
		try {
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
		
			while(rs.next()) {
				History his=new History(rs.getInt("id_user"),rs.getInt("ma_san_pham") ,rs.getInt("quantity") ,rs.getDouble("total") ,rs.getString("ngay_mua"));
			
				list.add(his);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<History> getlist1(int username){
		String sql="select * from history where history.id_user="+username+";";
		list=new ArrayList<>();
		
		try {
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
		
			while(rs.next()) {
				History his=new History(rs.getInt("id_user"),rs.getInt("ma_san_pham") ,rs.getInt("quantity") ,rs.getDouble("total") ,rs.getString("ngay_mua"));
			
				list.add(his);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public String getdate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);

	}
	public static void main(String[] args) {
//		List<History> list=new ArrayList<>();
//		HistoryDAO dao=new   HistoryDAO();
//		list=dao.getlist();
//		
//		for (History history : list) {
//			System.out.println(history.getId_user());
//		}
	}

}
