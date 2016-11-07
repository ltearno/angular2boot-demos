package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.ApplicationRef;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.ComponentFactory;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular.ComponentRef;

public class AngularComponentContainerWidget extends Widget
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

	@Override
	protected void onAttach()
	{
		super.onAttach();

		if( componentRef != null )
			return;

		try
		{
			componentRef = factory.create( applicationRef.getInjector(), new Object[0], getElement() );

			// componentRef.changeDetectorRef.detectChanges();

			applicationRef._loadComponent( componentRef );
		}
		catch( Exception e )
		{
			GWT.log( "erreur", e );

		}
		// GWT.debugger();
	}
}