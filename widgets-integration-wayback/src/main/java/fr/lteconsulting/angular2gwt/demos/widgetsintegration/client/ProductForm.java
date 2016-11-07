package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;

public class ProductForm extends Composite
{
	private TextBox nameTextBox = new TextBox();
	private TextBox colorTextBox = new TextBox();

	public ProductForm()
	{
		FlexTable table = new FlexTable();

		table.setText( 0, 0, "A GWT Widget inserted into an Angular 2 component" );
		table.getFlexCellFormatter().setColSpan( 0, 0, 2 );

		table.setText( 1, 0, "Name" );
		table.setWidget( 1, 1, nameTextBox );

		table.setText( 2, 0, "Color" );
		table.setWidget( 2, 1, colorTextBox );

		initWidget( table );
		
		getElement().getStyle().setBorderColor( "black" );
		getElement().getStyle().setBorderStyle( BorderStyle.SOLID );
		getElement().getStyle().setBorderWidth( 1, Unit.PX );
	}

	public void setProduct( Product product )
	{
		if( product != null )
		{
			nameTextBox.setValue( product.name );
			colorTextBox.setValue( product.color );
		}
		else
		{
			nameTextBox.setValue( "-" );
			colorTextBox.setValue( "black" );
		}
	}

	public void getProduct( Product product )
	{
		product.name = nameTextBox.getValue();
		product.color = colorTextBox.getValue();
	}
}
