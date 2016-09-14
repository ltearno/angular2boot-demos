package fr.lteconsulting.client.directives;

import fr.lteconsulting.angular2gwt.client.interop.ng.core.ElementRef;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.Renderer;
import fr.lteconsulting.angular2gwt.ng.core.Directive;
import fr.lteconsulting.angular2gwt.ng.core.HostListener;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import jsinterop.annotations.JsType;

/**
 * Sample for https://angular.io/docs/ts/latest/guide/attribute-directives.html
 */
@Directive( selector = "[myHighlight]" )
@JsType
public class HighlightDirective
{
	private final ElementRef elementRef;
	private final Renderer renderer;

	private String defaultColor = "red";
	private String highlightColor = null;

	@Input( name = "myHighlight" )
	public void setHighlightColor( String color )
	{
		highlightColor = color;
	}

	public HighlightDirective( ElementRef elementRef, Renderer renderer )
	{
		this.elementRef = elementRef;
		this.renderer = renderer;
	}

	@Input
	public void setDefaultColor( String colorName )
	{
		defaultColor = colorName != null ? colorName : defaultColor;
	}

	@HostListener
	public void mouseenter()
	{
		highlight( highlightColor != null ? highlightColor : defaultColor );
	}

	@HostListener
	public void mouseleave()
	{
		highlight( null );
	}

	private void highlight( String color )
	{
		renderer.setElementStyle( elementRef.nativeElement(), "backgroundColor", color );
	}
}
