package jp.co.aforce.bean;

public class CartInfo implements java.io.Serializable {
	
	private ProductInfo product_info;
	private int item_count;
	
	//get
	public ProductInfo getProductInfo() {
		return product_info;
	}
	
	public int getItemCount() {
		return item_count;
	}
	
	//set
	public void setProductInfo(ProductInfo product_info) {
		this.product_info = product_info;
	}
	
	public void setItemCount(int item_count) {
		this.item_count = item_count;
	}
	
}
