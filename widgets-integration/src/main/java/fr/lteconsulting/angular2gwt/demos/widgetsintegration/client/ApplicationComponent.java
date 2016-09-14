package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

/**
 * Main angular component for the application.
 * 
 * <p>
 * It simply binds to the <my-app> tag.
 */
@Component(
		selector = "my-app",
		template = "<h1>Angular 2 and GWT Widgets integration</h1>"
				+ "GWT Widgets are inserted into Angular 2 components.<br/>"
				+ "The 'List of products' view is a normal Angular 2 component, "
				+ "and the detailed view is implemented with legacy GWT widgets.<br/>"
				+ "After having selected a product, when you click on the button, "
				+ "the 'Product' object (shared between "
				+ "javascript and java) is updated and the Angular change detection"
				+ "algorithm updates portions of the UI which use this value (like the "
				+ "name of the product in the list for instance).<br/><br/>"

				+ "<products></products>" )
@JsType
public class ApplicationComponent
{
}