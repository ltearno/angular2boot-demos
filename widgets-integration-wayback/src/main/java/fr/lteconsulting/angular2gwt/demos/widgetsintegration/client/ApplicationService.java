package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class ApplicationService
{
	private JsArray<Product> products = JsArray.of(
			new Product( 1, "Table", "red" ),
			new Product( 2, "Chair", "blue" ),
			new Product( 3, "Arm", "green" ),
			new Product( 4, "Wood", "yellow" ),
			new Product( 5, "Light", "brown" ),
			new Product( 6, "Food", "black" ),
			new Product( 7, "Box", "orange" ) );

	public JsArray<Product> getProducts()
	{
		return products;
	}
}
