package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import jsinterop.annotations.JsType;

@JsType
public class Product
{
	public int id;
	public String name;
	public String color;

	public Product( int id, String name, String color )
	{
		this.id = id;
		this.name = name;
		this.color = color;
	}
}
