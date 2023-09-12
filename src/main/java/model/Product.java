package model;



public class Product {
	private int proID, cateID;
	private String proName, image, proInfor, promanufacturer;
	private double price;

	public int getProID() {
		return proID;
	}

	public void setProID(int proID) {
		this.proID = proID;
	}

	public int getCateID() {
		return cateID;
	}

	public void setCateID(int cateID) {
		this.cateID = cateID;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProInfor() {
		return proInfor;
	}

	public void setProInfor(String proInfor) {
		this.proInfor = proInfor;
	}

	public String getPromanufacturer() {
		return promanufacturer;
	}

	public void setPromanufacturer(String promanufacturer) {
		this.promanufacturer = promanufacturer;
	}

	public Product(int proID, int cateID, String proName, String image, String proInfor, String promanufacturer,
			double price) {

		this.proID = proID;
		this.cateID = cateID;
		this.proName = proName;
		this.image = image;
		this.proInfor = proInfor;
		this.promanufacturer = promanufacturer;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product() {
	}

}
