package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;

import fr.lteconsulting.angular2gwt.client.interop.ng.core.Core;
import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowserDynamic.PlatformBrowserDynamic;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.AngularComponentContainerWidget;

public class AngularIntegration
{
	private static AngularIntegration INSTANCE = new AngularIntegration();

	private boolean initialized = false;

	ApplicationRef applicationRef;
	ComponentFactoryResolver componentFactoryResolver;

	public static AngularIntegration get()
	{
		return INSTANCE;
	}

	public void init( Object ngModule, boolean productionMode )
	{
		if( initialized )
			return;

		if( Document.get().getElementsByTagName( "angular2-gwt-shell" ).getLength() == 0 )
		{
			Element shellElement = Document.get().createElement( "angular2-gwt-shell" );
			shellElement.getStyle().setDisplay( Display.NONE );
			Document.get().getBody().appendChild( shellElement );
		}

		if( productionMode )
			Core.enableProdMode();

		PlatformBrowserDynamic.platformBrowserDynamic().bootstrapModule( ngModule );

		initialized = true;
	}

	public AngularComponentContainerWidget createAngularComponent( Object componentPrototype )
	{
		ComponentFactory factory = componentFactoryResolver.resolveComponentFactory( componentPrototype );

		AngularComponentContainerWidget angularComponentContainerWidget = new AngularComponentContainerWidget( factory, applicationRef );

		return angularComponentContainerWidget;
	}

	void initAngularReferences( ApplicationRef applicationRef, ComponentFactoryResolver componentFactoryResolver )
	{
		this.applicationRef = applicationRef;
		this.componentFactoryResolver = componentFactoryResolver;
	}
}
