package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "angular2-gwt-shell",
		template = "<div></div>" )
@JsType
public class AngularIntegrationShellComponent
{
	public AngularIntegrationShellComponent( ApplicationRef applicationRef, ComponentFactoryResolver componentFactoryResolver )
	{
		AngularIntegration.get().initAngularReferences( applicationRef, componentFactoryResolver );
	}
}
