package fr.lteconsulting.primeng.client.primeng;

import fr.lteconsulting.UseBuilderGenerator;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
public class Column
{
	public String field;
	public String header;
	public String footer;
	public boolean sortable;
	public boolean editable;
	public boolean filter;

	@UseBuilderGenerator( builderName = "ColumnBuilder" )
	@JsOverlay
	public static Column create( String field, String header, String footer, boolean sortable, boolean editable, boolean filter )
	{
		Column column = new Column();

		column.field = field;
		column.header = header;
		column.footer = footer;
		column.sortable = sortable;
		column.editable = editable;
		column.filter = filter;

		return column;
	}
}
