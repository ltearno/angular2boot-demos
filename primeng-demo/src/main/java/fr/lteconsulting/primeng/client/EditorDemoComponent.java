package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-editor-demo",
		templateUrl = "EditorDemoComponent.html" )
@JsType
public class EditorDemoComponent
{
	public String text1 = "<div>Hello World!</div><div>PrimeNG <b>Editor</b> Rocks</div><div><br></div>";

	public String text2;
}
