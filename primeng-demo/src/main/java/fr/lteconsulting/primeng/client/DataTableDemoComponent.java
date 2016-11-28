package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.primeng.client.primeng.Column;
import fr.lteconsulting.primeng.client.primeng.ColumnBuilder;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-datatable-demo",
		templateUrl = "DataTableDemoComponent.html" )
@JsType
public class DataTableDemoComponent
{
	public JsArray<Car> cars = JsArray.of(
			new Car( "dsad231ff", 2012, "VW", "Orange" ),
			new Car( "gwregre345", 2011, "Audi", "Black" ),
			new Car( "h354htr", 2005, "Renault", "Gray" ),
			new Car( "j6w54qgh", 2003, "BMW", "Blue" ),
			new Car( "hrtwy34", 1995, "Mercedes", "Orange" ),
			new Car( "jejtyj", 2005, "Volvo", "Orange" ),
			new Car( "g43gr", 2012, "Honda", "Yellow" ),
			new Car( "greg34", 2013, "Jaguar", "Orange" ),
			new Car( "h54hw5", 2000, "Ford", "Black" ),
			new Car( "245t2s", 2013, "Fiat", "Red" ) );

	public JsArray<Column> cols = JsArray.of(
			ColumnBuilder.prepare().withField( "vin" ).withHeader( "Vin" ).withEditable( true ).withFooter( "Vin" ).withSortable( true ).call(),
			ColumnBuilder.prepare().withField( "year" ).withHeader( "Year" ).call(),
			ColumnBuilder.prepare().withField( "brand" ).withHeader( "Brand" ).call(),
			ColumnBuilder.prepare().withField( "color" ).withHeader( "Color" ).call() );

	public DataTableDemoComponent()
	{
	}
}
