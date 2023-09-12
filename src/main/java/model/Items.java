package model;


public class Items {
	private Product pro;
	private int quantity;
	private double total;

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
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

	public Items(Product pro, int quantity, double total) {
		this.pro = pro;
		this.quantity = quantity;
		this.total = total;
	}

	public Items() {

	}

	

}
