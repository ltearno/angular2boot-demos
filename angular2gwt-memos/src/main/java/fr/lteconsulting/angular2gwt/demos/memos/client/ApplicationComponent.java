package fr.lteconsulting.angular2gwt.demos.memos.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-app",
		template = "Memos demo<br/>"
				+ "<router-outlet></router-outlet>",
		styleUrls = "ApplicationComponent.css",
		providers = MemosService.class )
@JsType
public class ApplicationComponent
{
}
