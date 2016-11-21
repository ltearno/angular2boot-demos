package fr.lteconsulting.angular.demos.canvas.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Main angular component for the application.
 * 
 * <p>
 * It simply binds to the <my-app> tag.
 */
@Component(
		selector = "my-app",
		template = "<mb-canvas></mb-canvas>" )
@JsType
public class ApplicationComponent
{
	@JsProperty
	private String title = "Your application is working !";
}
