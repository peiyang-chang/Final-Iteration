package edu.baylor.ecs.Panda2;

public class PaymentInfo { 
	private String CarName;
	private String CarPrice;
	private String BuyerName;
	private String BuyerPhone;
	private String AppTime;
	
	public PaymentInfo(String carName, String carPrice, String buyerName, String buyerPhone, String appTime) {
		super();
		CarName = carName;
		CarPrice = carPrice;
		BuyerName = buyerName;
		BuyerPhone = buyerPhone;
		AppTime = appTime;
	}
	public String getCarName() {
		return CarName;
	}
	public void setCarName(String carName) {
		CarName = carName;
	}
	public String getCarPrice() {
		return CarPrice;
	}
	public void setCarPrice(String carPrice) {
		CarPrice = carPrice;
	}
	public String getBuyerName() {
		return BuyerName;
	}
	public void setBuyerName(String buyerName) {
		BuyerName = buyerName;
	}
	public String getBuyerPhone() {
		return BuyerPhone;
	}
	public void setBuyerPhone(String buyerPhone) {
		BuyerPhone = buyerPhone;
	}
	public String getAppTime() {
		return AppTime;
	}
	public void setAppTime(String appTime) {
		AppTime = appTime;
	}
	
}
