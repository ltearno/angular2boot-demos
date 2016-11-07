package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import com.google.gwt.core.shared.GWT;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.AfterViewInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.NgZone;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.ChangeDetectorRef;
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
public class ProductsComponent implements OnInit, AfterViewInit
{
	public JsArray<Product> products = JsArray.of(
			new Product( 1, "Table", "red" ),
			new Product( 2, "Chair", "blue" ),
			new Product( 3, "Arm", "green" ),
			new Product( 4, "Wood", "yellow" ),
			new Product( 5, "Light", "brown" ),
			new Product( 6, "Food", "black" ),
			new Product( 7, "Box", "orange" ) );

	public Product selectedProduct = products.get( 0 );
	
	private ChangeDetectorRef changeDetectorRef;

	public ProductsComponent( NgZone zone, ChangeDetectorRef changeDetectorRef )
	{
		GWT.log( "HELLO FROM COMPONENT " + zone );
		this.changeDetectorRef = changeDetectorRef;
	}
	
	@Override
	public void ngAfterViewInit()
	{
		GWT.log( "ngAfterViewInit" );
	}

	@Override
	public void ngOnInit()
	{
		GWT.log( "on init " + products );
	}

	public void select( Product product )
	{
		GWT.log( product.name );
		selectedProduct = product;
		changeDetectorRef.detectChanges();
	}
}
