package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;

import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.Product;

public class ProductForm extends Composite
{
	private TextBox nameTextBox = new TextBox();
	private TextBox colorTextBox = new TextBox();

	public ProductForm()
	{
		FlexTable table = new FlexTable();

		table.setText( 0, 0, "Name" );
		table.setWidget( 0, 1, nameTextBox );

		table.setText( 1, 0, "Color" );
		table.setWidget( 1, 1, colorTextBox );

		initWidget( table );
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
