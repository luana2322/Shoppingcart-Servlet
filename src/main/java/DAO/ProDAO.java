package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Items;
import model.Product;

public class ProDAO extends DBContext {

	List<Product> list;
	Product pro;
//	this.proID = proID;
//	this.cateID = cateID;
//	this.proName = proName;
//	this.image = image;
//	this.proInfor = proInfor;
//	this.promanufacturer = promanufacturer;
	// price
	
	public List<Product> getall(){
		list=new ArrayList<>();
		String sql="select * from product;";
		try {
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()) {
				int proID=rs.getInt("ma_san_pham");
				int cateID=rs.getInt("ma_the_loai");
				String proName=rs.getString("ten_san_pham");
				String image=rs.getString("hinh_anh");
				String infor=rs.getString("thong_tin");
				String manu=rs.getString("hang_san_xuat");
				double price=rs.getDouble("gia_ban");
				Product pro=new Product(proID, cateID, proName, image, infor, manu, price);
						list.add(pro);
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
		
	}
	
	public Product getpro(int id) {
		
		String sql="select * from product where product.ma_san_pham="+id+";";
		try {
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			if(rs.next()) {
				int proID=rs.getInt("ma_san_pham");
				int cateID=rs.getInt("ma_the_loai");
				String proName=rs.getString("ten_san_pham");
				String image=rs.getString("hinh_anh");
				String infor=rs.getString("thong_tin");
				String manu=rs.getString("hang_san_xuat");
				double price=rs.getDouble("gia_ban");
				 pro=new Product(proID, cateID, proName, image, infor, manu, price);
					
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			return pro;
	}
	
	
	public List<Items> getlistpro(String id) {
		
		List<Items> listitem=new ArrayList<>();
		String[] com=id.split("\\.");
		
		for(int i=0;i<com.length;i++) {
			
			String[] com1=com[i].split("-");
			
			Product pro=getpro(Integer.parseInt(com1[0]));
			
			Items item=new Items(pro, Integer.parseInt(com1[1]), Integer.parseInt(com1[1])*pro.getPrice());
			listitem.add(item);
				
		}
		
			return listitem;
	}
	
	
	
	
	public static void main(String[] args) {
		List<Product> list=new ArrayList<>();
		List<Items> listitem=new ArrayList<>();
		ProDAO dao=new ProDAO();
		listitem=dao.getlistpro("1:1.2:1.3:1.");
		
		for (Items items : listitem) {
			System.out.println(items.getQuantity());
		}
		
	}
	
	
	
}
