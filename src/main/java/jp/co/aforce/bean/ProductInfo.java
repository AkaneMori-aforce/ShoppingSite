package jp.co.aforce.bean;

public class ProductInfo implements java.io.Serializable {
	
	private String product_id;
	private String product_name;
	private String category;
	private String price;
	private int stock;
	private String description;
	private String img_name;
	
	//get
	public String getProductId() {
		return product_id;
	}
	
	public String getProductName() {
		return product_name;
	}

	public String getCategory() {
		return category;
	}
	
	public String getPrice() {
		return price;
	}
	
	public int getStock() {
		return stock;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getImgName() {
		return img_name;
	}
	
	//set
	public void setProductId(String product_id) {
		this.product_id = product_id;
	}
	
	public void setProductName(String product_name) {
		this.product_name = product_name;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setImgName(String img_name) {
		this.img_name = img_name;
	}
	
}
