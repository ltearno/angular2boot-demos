package fr.lteconsulting.angular2gwt.demos.orchard.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-crow",
		template = "<div [class.alert]='position<=2'>"
				+ "  Crow position: {{position}}</div>"
				+ "<div"
				+ "  *ngFor='let index of [0,1,2,3,4]'"
				+ "  class='cell'>{{position==index?'CROW':'&nbsp;'}}</div>",
		styles = ".alert { color: red; }"
				+ ".cell { display:inline-block;"
				+ "    border:1px solid black;"
				+ "    width:4em;"
				+ "    height:2em; }" )
@JsType
public class CrowComponent
{
	@Input
	public int position;
}