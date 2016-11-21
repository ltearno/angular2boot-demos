package fr.lteconsulting.angular.demos.canvas.client;

import fr.lteconsulting.angular2gwt.client.interop.ng.forms.FormsModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowser.BrowserModule;
import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import jsinterop.annotations.JsType;

@NgModule(
		imports = { BrowserModule.class, FormsModule.class },
		declarations = {
				ApplicationComponent.class,
				CanvasComponent.class,
				CircleComponent.class
		},
		providers = {
				CirclesService.class,
				ApplicationConfiguration.class
		},
		bootstrap = ApplicationComponent.class )
@JsType
public class ApplicationModule
{
}
