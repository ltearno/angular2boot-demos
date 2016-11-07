package fr.lteconsulting.client.directives;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "directives",
		directives = HighlightDirective.class,
		template = "<h1>My First Attribute Directive</h1>"
				+ "<h4>Pick a highlight color</h4>"
				+ "<div>"
				+ "<label><input type='radio' name='colors' (click)='color=\\\"lightgreen\\\"'>Green</label>"
				+ "<label><input type='radio' name='colors' (click)='color=\\\"yellow\\\"'>Yellow</label>"
				+ "<label><input type='radio' name='colors' (click)='color=\\\"cyan\\\"'>Cyan</label>"
				+ "</div>"
				+ "Highlight color is {{color}}"
				+ "<p [myHighlight]='color' [defaultColor]='\\\"violet\\\"'>Highlight me!</p>" )
@JsType
public class DirectivesComponent
{
	public String color = null;
}
