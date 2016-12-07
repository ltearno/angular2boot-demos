package fr.lteconsulting.client.sanitization;

import com.google.gwt.core.shared.GWT;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.client.interop.DomSanitizationService;
import fr.lteconsulting.client.interop.SecurityContext;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "sanitization",
		template = "<label>Type a text : <input [(ngModel)]='text' length=50/></label><br/>"
				+ "Here are the sanitized versions :<br/>"
				+ "bypassSecurityTrustUrl: {{bypassSecurityTrustUrl}}<br/>"
				+ "bypassSecurityTrustStyle: {{bypassSecurityTrustStyle}}<br/>"
				+ "bypassSecurityTrustScript: {{bypassSecurityTrustScript}}<br/>"
				+ "bypassSecurityTrustResourceUrl: {{bypassSecurityTrustResourceUrl}}<br/>"
				+ "bypassSecurityTrustHtml: <span [innerHTML]='bypassSecurityTrustHtml'></span><br/>"
				+ "test: <span [innerHTML]='test'></span><br/>"
				+ "test: {{test}}<br/>" )
@JsType
public class SanitizationServiceComponent
{
	private final DomSanitizationService service;

	public String text = "<b>Hey</b><script>alert('injected script...')</script>";

	public SanitizationServiceComponent( DomSanitizationService service )
	{
		this.service = service;
	}

	@JsProperty( name = "bypassSecurityTrustUrl" )
	public String bypassSecurityTrustUrl()
	{
		String value = service.sanitize( SecurityContext.URL(), service.bypassSecurityTrustUrl( text ) );
		GWT.log( "URL: " + value );
		return value;
	}

	@JsProperty( name = "bypassSecurityTrustStyle" )
	public String bypassSecurityTrustStyle()
	{
		String value = service.sanitize( SecurityContext.STYLE(), service.bypassSecurityTrustStyle( text ) );
		GWT.log( "STYLE: " + value );
		return value;
	}

	@JsProperty( name = "bypassSecurityTrustScript" )
	public String bypassSecurityTrustScript()
	{
		String value = service.sanitize( SecurityContext.SCRIPT(), service.bypassSecurityTrustScript( text ) );
		GWT.log( "SCRIPT: " + value );
		return value;
	}

	@JsProperty( name = "bypassSecurityTrustResourceUrl" )
	public String bypassSecurityTrustResourceUrl()
	{
		String value = service.sanitize(
				SecurityContext.RESOURCE_URL(),
				service.bypassSecurityTrustResourceUrl( text ) );
		GWT.log( "RESOURCE_URL: " + value );
		return value;
	}

	@JsProperty( name = "bypassSecurityTrustHtml" )
	public String bypassSecurityTrustHtml()
	{
		String value = service.sanitize( SecurityContext.HTML(), service.bypassSecurityTrustHtml( text ) );
		GWT.log( "HTML: " + value );
		return value;
	}

	@JsProperty( name = "test" )
	public String test()
	{
		return text;
	}
}
