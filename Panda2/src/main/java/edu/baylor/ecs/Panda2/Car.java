package edu.baylor.ecs.Panda2;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class Car {
	private String make;
	private String model;
	private String year;
	private String Color;
	private String Price;
	 
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
