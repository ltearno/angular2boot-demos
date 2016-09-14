package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "products",
		template = "<div>"
				+ "<h2>List of products</h2>"
				+ "Click on one of the products to select and edit it:"
				+ "<ul>"
				+ "<li *ngFor='let product of products'"
				+ " (click)='select(product)'"
				+ " [class.selected]='product===selectedProduct'>"
				+ "{{product.name}} (id:{{product.id}})"
				+ " <div style='display:inline-block;width:20px;height:20px;'"
				+ "  [style.backgroundColor]='product.color'></div>"
				+ "</li>"
				+ "</ul>"
				+ "<product *ngIf='selectedProduct' [product]='selectedProduct'></product>",
		styles = ".selected {"
				+ "background-color: #CFD8DC !important;"
				+ "color: white;"
				+ "}" )
@JsType
public class ProductsComponent
{
	public JsArray<Product> products = JsArray.of(
			new Product( 1, "Table", "red" ),
			new Product( 2, "Chair", "blue" ),
			new Product( 3, "Arm", "green" ),
			new Product( 4, "Wood", "yellow" ),
			new Product( 5, "Light", "brown" ),
			new Product( 6, "Food", "black" ),
			new Product( 7, "Box", "orange" ) );

	public Product selectedProduct = null;

	public void select( Product product )
	{
		selectedProduct = product;
	}
}
