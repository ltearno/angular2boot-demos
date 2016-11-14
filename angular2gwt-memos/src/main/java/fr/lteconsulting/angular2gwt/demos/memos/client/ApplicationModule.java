package fr.lteconsulting.angular2gwt.demos.memos.client;

import fr.lteconsulting.angular2gwt.client.interop.ng.forms.FormsModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.HttpModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowser.BrowserModule;
import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import jsinterop.annotations.JsType;

@NgModule(
		imports = {
				BrowserModule.class,
				HttpModule.class,
				FormsModule.class,
				Routes.class
		},
		declarations = {
				ApplicationComponent.class,
				FlipComponent.class,
				MemosComponent.class,
				MemoComponent.class
		},
		entryComponents = {
				MemosComponent.class,
				MemoComponent.class
		},
		providers = {
				MemosService.class
		},
		bootstrap = ApplicationComponent.class )
@JsType
public class ApplicationModule
{
}
