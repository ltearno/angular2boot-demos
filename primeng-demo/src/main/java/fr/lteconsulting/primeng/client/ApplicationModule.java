package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.client.interop.ng.forms.FormsModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.HttpModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowser.BrowserModule;
import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import fr.lteconsulting.primeng.client.primeng.AccordionModule;
import fr.lteconsulting.primeng.client.primeng.AutoCompleteModule;
import fr.lteconsulting.primeng.client.primeng.CheckboxModule;
import fr.lteconsulting.primeng.client.primeng.DataTableModule;
import fr.lteconsulting.primeng.client.primeng.DialogModule;
import fr.lteconsulting.primeng.client.primeng.EditorModule;
import fr.lteconsulting.primeng.client.primeng.GMapModule;
import fr.lteconsulting.primeng.client.primeng.GrowlModule;
import fr.lteconsulting.primeng.client.primeng.InputMaskModule;
import fr.lteconsulting.primeng.client.primeng.InputSwitchModule;
import fr.lteconsulting.primeng.client.primeng.InputTextModule;
import fr.lteconsulting.primeng.client.primeng.MultiSelectModule;
import fr.lteconsulting.primeng.client.primeng.PasswordModule;
import fr.lteconsulting.primeng.client.primeng.SharedModule;
import fr.lteconsulting.primeng.client.primeng.SplitButtonModule;
import fr.lteconsulting.primeng.client.primeng.TreeTableModule;
import jsinterop.annotations.JsType;

@NgModule(
		imports = {
				BrowserModule.class,
				FormsModule.class,
				HttpModule.class,
				Routes.class,

				AutoCompleteModule.class,
				CheckboxModule.class,
				EditorModule.class,
				SharedModule.class,
				AccordionModule.class,
				InputTextModule.class,
				InputSwitchModule.class,
				InputMaskModule.class,
				MultiSelectModule.class,
				PasswordModule.class,
				SplitButtonModule.class,
				GrowlModule.class,
				DataTableModule.class,
				TreeTableModule.class,
				GMapModule.class,
				DialogModule.class
		},
		declarations = {
				ApplirrcationComponent.class,
				CheckboxDemoComponent.class,
				EditorDemoComponent.class,
				AutoCompleteDemoComponent.class,
				RadioButtonDemoComponent.class,
				SplitButtonDemoComponent.class,
				DataTableDemoComponent.class,
				TreeTableDemoComponent.class,
				GMapDemoComponent.class
		},
		providers = {
				CountryService.class,
				NodeService.class
		},
		bootstrap = ApplirrcationComponent.class )
@JsType
public class ApplicationModule
{
}
