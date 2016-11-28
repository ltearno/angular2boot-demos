package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-radiobutton-demo",
		templateUrl = "RadioButtonDemoComponent.html" )
@JsType
public class RadioButtonDemoComponent
{
	public String val1;
	public String val2 = "Option 2";
	
	public Object group1;
}
