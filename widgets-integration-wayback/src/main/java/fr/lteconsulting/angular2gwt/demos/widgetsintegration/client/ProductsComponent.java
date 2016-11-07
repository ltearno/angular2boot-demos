package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.EventEmitter;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Output;
import jsinterop.annotations.JsType;

@Component(
		selector = "products",
		template = "<div>"
				+ "<h2>List of products (an Angular 2 component)</h2>"
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
	public JsArray<Product> products;

	public Product selectedProduct = null;

	@Output
	public EventEmitter<Product> selection = new EventEmitter<>();

	public ProductsComponent( ApplicationService service )
	{
		products = service.getProducts();
	}

	public void select( Product product )
	{
		selectedProduct = product;
		selection.emit( product );
	}
}
