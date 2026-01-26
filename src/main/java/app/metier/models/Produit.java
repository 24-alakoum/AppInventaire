package app.metier.models;

public class Produit {
	private int idProduct;
	private String productName;
	private int productQuantity;
	private double productPrice;
	public Produit() {
		// TODO Auto-generated constructor stub
	}
	
	//Getters et setters
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	

}
/*idProduct
productName
productQuantity
productPrice*/