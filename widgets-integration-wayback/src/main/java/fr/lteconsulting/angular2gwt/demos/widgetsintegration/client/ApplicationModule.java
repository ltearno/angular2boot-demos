package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import fr.lteconsulting.angular2gwt.client.interop.ng.forms.FormsModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowser.BrowserModule;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.AngularIntegrationModule;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.AngularIntegrationShellComponent;
import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import jsinterop.annotations.JsType;

@NgModule(
		imports = {
				BrowserModule.class,
				FormsModule.class,
				AngularIntegrationModule.class
		},
		declarations = {
				ProductsComponent.class,
				ProductComponent.class
		},
		entryComponents = {
				ProductsComponent.class,
				ProductComponent.class
		},
		providers = ApplicationService.class,
		bootstrap = AngularIntegrationShellComponent.class )
@JsType
public class ApplicationModule
{
}
