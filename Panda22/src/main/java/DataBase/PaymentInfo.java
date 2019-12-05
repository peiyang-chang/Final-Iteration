package DataBase;

/**
 * <h1>Car</h1> The PyamentInfo class from DataBase Package implements to create
 * a PaymentInfo object
 * <p>
 *
 * A PaymentInfo Object contains CarName, CarPrice, BuyerName, BuyerPhone, and
 * AppTime
 *
 * @author Peiyang Chang
 * @version 1.7
 * @since 2019-11-18
 */
public class PaymentInfo {
	private String CarName;
	private String CarPrice;
	private String BuyerName;
	private String BuyerPhone;
	private String AppTime;

	/**
	 * This is the constructor to create a new PaymentInfo Object with carName,
	 * carPrice, buyerName, buyerPhone, appTime
	 * 
	 * @param args carName. This is car Name - String
	 * @param args carPrice. This is car Price - String
	 * @param args buyerName. This is buyer Name - String
	 * @param args buyerPhone. This is buyer Phone - String
	 * @param args appTime. This is appointment time - String
	 * @return Nothing.
	 */
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
