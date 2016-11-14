package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.gwtintegration.AngularComponentContainerWidget;
import fr.lteconsulting.angular2gwt.client.gwtintegration.AngularIntegration;

/**
 * This is the regular GWT application entry point.
 */
public class Application implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		/**
		 * This allow to use the given Angular 2 module's components inside a legacy GWT application.
		 * 
		 * An Angular application is created on the web page and components are added to it dynamically.
		 * Components can themselves integrate legacy GWT widgets !
		 */
		AngularIntegration.get().init( ApplicationModule_AngularModule.getNgModulePrototype(), false );

		HTML headerText = new HTML( "<h1>Angular 2 and GWT Widgets integration</h1>"
				+ "<h2>This is a legacy regular GWT application !</h2>"
				+ "Angular 2 components are inserted as normal GWT Widgets inside a legacy application.<br/><br/>"
				+ "When you click on this GWT button, an Angular 2 component will be inserted into a new Discolure Panel.<br/><br/>"
				+ "If the 'Override component's data' box is checked, the component's data injected by Angular DI mechanism will "
				+ "be overwritten by data coming from the GWT application." );

		Button button = new Button( "Create an angular component and insert it into a DisclosurePanel" );
		CheckBox overide = new CheckBox( "Override component's data" );
		Label selectedLabel = new Label( "selected: -" );

		VerticalPanel panel = new VerticalPanel();
		panel.add( headerText );
		panel.add( overide );
		panel.add( button );
		panel.add( selectedLabel );

		RootPanel.get().add( panel );

		/**
		 * Data given to the ProductsComponents when overriding default data
		 */
		JsArray<Product> products = JsArray.of(
				new Product( 3, "Hard coded data", "#eee" ),
				new Product( 3, "Soft layer", "#27e" ),
				new Product( 3, "Middle range", "#418" ) );

		button.addClickHandler( e -> {
			// create an Angular component wrapped into a GWT compatible widget
			AngularComponentContainerWidget<ProductsComponent> angularComponentContainerWidget = 
					AngularIntegration.get().createAngularComponent( ProductsComponent_AngularComponent.getComponentPrototype() );

			// insert the component in the Widget tree
			DisclosurePanel disclosure = new DisclosurePanel( "An Angular 2 component inside a GWT Widget, click to open" );
			disclosure.setContent( angularComponentContainerWidget );
			panel.add( disclosure );

			// get the component instanciated by the Angular 2 runtime
			ProductsComponent productsComponent = angularComponentContainerWidget.getComponentInstance();

			if( overide.getValue() )
			{
				// directly affect the component instance's products list
				productsComponent.products = products;

				// manually trigger angular 2 detection change because he won't catch this one !
				angularComponentContainerWidget.detectChanges();
			}

			productsComponent.selection.subscribe( selected -> selectedLabel.setText( "selected: " + selected ) );
		} );
	}
}