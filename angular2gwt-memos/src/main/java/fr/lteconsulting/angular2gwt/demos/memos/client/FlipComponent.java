package fr.lteconsulting.angular2gwt.demos.memos.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-flip",
		styleUrls = "FlipComponent.css",
		templateUrl = "FlipComponent.html" )
@JsType
public class FlipComponent
{
	@Input
	public boolean flipped;
}
