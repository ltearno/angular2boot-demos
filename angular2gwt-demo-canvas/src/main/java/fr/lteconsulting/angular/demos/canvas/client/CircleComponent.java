package fr.lteconsulting.angular.demos.canvas.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "[mb-circle]",
		template = "<svg:circle [attr.cx]='circle.x' [attr.cy]='circle.y' [attr.r]='circle.radius' />",
		styleUrls = "circle.component.css" )
@JsType
public class CircleComponent
{
	@Input
	@JsProperty
	private Circle circle;
}