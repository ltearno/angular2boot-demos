package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.AngularIntegration;

/**
 * This is the regular GWT application entry point.
 */
public class Application implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		AngularIntegration.get().init( ApplicationModule_AngularModule.getNgModulePrototype(), false );

		HTML headerText = new HTML( "<h1>Angular 2 and GWT Widgets integration</h1>"
				+ "GWT Widgets are inserted into Angular 2 components.<br/>"
				+ "The 'List of products' view is a normal Angular 2 component, "
				+ "and the detailed view is implemented with legacy GWT widgets.<br/>"
				+ "After having selected a product, when you click on the button, "
				+ "the 'Product' object (shared between "
				+ "javascript and java) is updated and the Angular change detection"
				+ "algorithm updates portions of the UI which use this value (like the "
				+ "name of the product in the list for instance).<br/><br/>" );

		Button button = new Button( "Create an angular component and insert it into a DisclosurePanel" );
		CheckBox overide = new CheckBox( "Override component's data" );

		VerticalPanel panel = new VerticalPanel();
		panel.add( headerText );
		panel.add( overide );
		panel.add( button );

		RootPanel.get().add( panel );

		JsArray<Product> products = JsArray.of( new Product( 3, "OHOHO", "pink" ) );

		button.addClickHandler( e -> {
			DisclosurePanel disclosure = new DisclosurePanel( "An Angular 2 component, click to open" );

			AngularComponentContainerWidget<ProductsComponent> angularComponentContainerWidget = AngularIntegration.get().createAngularComponent( ProductsComponent_AngularComponent.getComponentPrototype() );

			disclosure.setContent( angularComponentContainerWidget );

			panel.add( disclosure );

			if( overide.getValue() )
			{
				angularComponentContainerWidget.getComponentInstance().products = products;
				angularComponentContainerWidget.detectChanges();
			}
		} );
	}
}