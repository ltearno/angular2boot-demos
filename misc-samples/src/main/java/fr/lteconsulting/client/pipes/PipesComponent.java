package fr.lteconsulting.client.pipes;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "pipes",
		template = "<input type='text' [(ngModel)]='text'/><br/>"
				+ "Raw text : {{text}}<br/>"
				+ "Text codepoints in decimal : {{ text | codepoints }}<br/>"
				+ "Text codepoints in hexa : {{ text | codepoints:'hex' }}<br/>" )
@JsType
public class PipesComponent
{
	public String text;
}
