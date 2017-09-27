package fr.lteconsulting.angular2gwt.demos.orchard.client;

import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import fr.lteconsulting.jsinterop.ng.platformBrowser.BrowserModule;
import jsinterop.annotations.JsType;

@NgModule(
		imports = BrowserModule.class,
		declarations = {
				ApplicationComponent.class,
				TreesComponent.class,
				TreeComponent.class,
				CrowComponent.class,
				DiceComponent.class
		},
		bootstrap = ApplicationComponent.class )
@JsType
public class ApplicationModule
{
}
