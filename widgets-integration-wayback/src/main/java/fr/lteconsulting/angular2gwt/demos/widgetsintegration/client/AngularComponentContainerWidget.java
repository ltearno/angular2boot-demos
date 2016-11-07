package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.ApplicationRef;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.ComponentFactory;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.ComponentRef;

public class AngularComponentContainerWidget<T> extends Widget
{
	private ComponentFactory factory;
	private ApplicationRef applicationRef;
	private ComponentRef componentRef;

	// TODO : how to get a reference pointer to the created Angular component ?
	// maybe by adding the angular/gwt object ref in the dom node...
	public AngularComponentContainerWidget( ComponentFactory factory, ApplicationRef applicationRef )
	{
		this.factory = factory;
		this.applicationRef = applicationRef;

		setElement( Document.get().createDivElement() );
	}

	@SuppressWarnings( "unchecked" )
	public T getComponentInstance()
	{
		return (T) componentRef.instance();
	}

	public void detectChanges()
	{
		componentRef.changeDetectorRef.detectChanges();
	}

	public ComponentRef getComponentRef()
	{
		return componentRef;
	}

	@Override
	protected void onAttach()
	{
		super.onAttach();

		if( componentRef != null )
			return;

		componentRef = factory.create( applicationRef.getInjector(), new Object[0], getElement() );

		applicationRef._loadComponent( componentRef );
	}
}