package model;

public class History {
private String date;
private int id_user,ma_san_pham,quantity;
private double total;
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
}
public int getMa_san_pham() {
	return ma_san_pham;
}
public void setMa_san_pham(int ma_san_pham) {
	this.ma_san_pham = ma_san_pham;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public History( int id_user, int ma_san_pham, int quantity, double total,String date) {
	this.date = date;
	this.id_user = id_user;
	this.ma_san_pham = ma_san_pham;
	this.quantity = quantity;
	this.total = total;
}
public History() {
}

}
