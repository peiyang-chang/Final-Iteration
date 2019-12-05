package DataBase;

/**
 * <h1>Car</h1> The Car class from DataBase Package implements to create a car
 * object
 * <p>
 *
 * A Car Object contains Make, Model, Year, Color, and Price
 *
 * @author Peiyang Chang
 * @version 1.7
 * @since 2019-9-25
 */

public class Car {
	private String make;
	private String model;
	private String year;
	private String Color;
	private String Price;

	/**
	 * This is the constructor to create a new Car Object with make, model, year,
	 * color, price
	 * 
	 * @param args make. This is Car Make - String
	 * @param args model. This is Car Model - String
	 * @param args year. This is Car Year - String
	 * @param args color. This is Car Color - String
	 * @param args price. This is Car Price - String
	 * @return Nothing.
	 */
	public Car(String make, String model, String year, String color, String price) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.Color = color;
		this.Price = price;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}
}
