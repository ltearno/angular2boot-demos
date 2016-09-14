package fr.lteconsulting.client;

import com.google.gwt.core.client.GWT;

import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class LoggerService
{
	public void log( String text )
	{
		GWT.log( text );
	}
}
