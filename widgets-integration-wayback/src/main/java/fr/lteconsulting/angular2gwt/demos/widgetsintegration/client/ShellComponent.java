package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.lteconsulting.angular2gwt.client.WidgetAdapterPanel;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.AfterViewInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.ElementRef;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.ApplicationRef;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.ComponentFactory;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.ComponentFactoryResolver;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.ViewChild;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-shell",
		template = "<div #panel></div>" )
@JsType
public class ShellComponent implements AfterViewInit
{
	@ViewChild( selector = "panel" )
	@JsProperty
	private ElementRef panelElement;

	private WidgetAdapterPanel adapterPanel;

	private ApplicationRef applicationRef;
	private ComponentFactoryResolver componentFactoryResolver;

	public ShellComponent( ApplicationRef applicationRef, ComponentFactoryResolver componentFactoryResolver )
	{
		this.applicationRef = applicationRef;
		this.componentFactoryResolver = componentFactoryResolver;
	}

	@Override
	public void ngAfterViewInit()
	{
		Button button = new Button( "Create an angular component and insert it into a DisclosurePanel" );
		DisclosurePanel disclosure = new DisclosurePanel( "An Angular 2 component, click to open" );

		button.addClickHandler( e -> {
			ComponentFactory factory = componentFactoryResolver.resolveComponentFactory( ProductsComponent_AngularComponent.getComponentPrototype() );
			disclosure.setContent( new AngularComponentContainerWidget( factory, applicationRef ) );
		} );

		VerticalPanel panel = new VerticalPanel();
		panel.add( button );
		panel.add( disclosure );

		adapterPanel = new WidgetAdapterPanel( panelElement );
		adapterPanel.setWidget( panel );
	}
}
