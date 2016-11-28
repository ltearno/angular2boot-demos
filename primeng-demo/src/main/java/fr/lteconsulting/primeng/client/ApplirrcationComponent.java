package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
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
		templateUrl = "ApplicationComponent.html",
		providers = {
				CountryService.class,
				NodeService.class
		} )
@JsType
public class ApplirrcationComponent
{
	public JsArray<JsObject> cities;
	public JsArray<String> selectedCity;

	public boolean checked1;
	public boolean checked2 = true;

	public String val1;
	public String val2;
	public String val3;
	public String val4;
	public String val5;
	public String val6;

	public boolean display;

	public void showDialog()
	{
		display = true;
	}

	public ApplirrcationComponent()
	{
		cities = new JsArray<>();

		cities.push( new JsObject().set( "label", "New York" ).set( "value", "New York" ) );
		cities.push( new JsObject().set( "label", "FEFEZF" ).set( "value", "Porieppp" ) );
		cities.push( new JsObject().set( "label", "AZERR" ).set( "value", "Mchgdjhg" ) );
	}
}
