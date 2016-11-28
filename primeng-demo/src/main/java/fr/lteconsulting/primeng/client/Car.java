package fr.lteconsulting.primeng.client;

import jsinterop.annotations.JsType;

@JsType
public class Car
{
	public String vin;
	public int year;
	public String brand;
	public String color;

	public Car( String vin, int year, String brand, String color )
	{
		this.vin = vin;
		this.year = year;
		this.brand = brand;
		this.color = color;
	}
}
