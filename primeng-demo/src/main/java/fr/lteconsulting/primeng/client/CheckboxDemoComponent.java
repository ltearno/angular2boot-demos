package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-checkbox-demo",
		templateUrl = "CheckboxDemoComponent.html" )
@JsType
public class CheckboxDemoComponent
{
	public String[] selectedCities = new String[] {};

	public String[] selectedCategories = new String[] { "Technology", "Sports" };

	public boolean checked;
}
