package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client;

import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.lteconsulting.angular2gwt.client.interop.ng.core.AfterViewInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.ElementRef;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnDestroy;
import fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.widgets.ProductForm;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import fr.lteconsulting.angular2gwt.ng.core.ViewChild;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "product",
		template = "<h2 *ngIf='product'>{{product.name | uppercase}}'s details:</h2>"
				+ "<div #panel></div>" )
@JsType
public class ProductComponent implements AfterViewInit, OnDestroy
{
	private Product product = null;

	private ProductForm form = new ProductForm();
	private Button updateButton = new Button( "Update name" );

	@ViewChild( selector = "panel" )
	@JsProperty
	private ElementRef panelElement;
	private WidgetAdapterPanel adapterPanel = null;

	@Override
	public void ngAfterViewInit()
	{
		updateButton.addClickHandler( event -> form.getProduct( product ) );

		VerticalPanel vp = new VerticalPanel();
		vp.add( form );
		vp.add( updateButton );

		adapterPanel = new WidgetAdapterPanel( panelElement );
		adapterPanel.setWidget( vp );
	}

	@Input
	public void setProduct( Product product )
	{
		this.product = product;

		if( form != null )
			form.setProduct( product );
	}

	public Product getProduct()
	{
		return product;
	}

	@Override
	public void ngOnDestroy()
	{
		adapterPanel.remove();
		adapterPanel = null;
	}
}

class WidgetAdapterPanel extends SimplePanel
{
	public WidgetAdapterPanel( ElementRef elementRef )
	{
		super( (Element) (Object) elementRef.nativeElement() );

		onAttach();
		maybeRegisterDetach();
	}

	public void remove()
	{
		RootPanel.detachNow( this );
	}

	private void maybeRegisterDetach()
	{
		if( !isElementChildOfWidget( getElement() ) )
			RootPanel.detachOnWindowClose( this );
	}

	private static boolean isElementChildOfWidget( Element element )
	{
		// from GWT's RootPanel source

		element = element.getParentElement();

		BodyElement body = Document.get().getBody();

		while( (element != null) && (body != element) )
		{
			if( Event.getEventListener( element ) != null )
				return true;

			element = element.getParentElement().cast();
		}

		return false;
	}
}