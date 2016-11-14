package fr.lteconsulting.angular2gwt.demos.memos.client;

import com.google.gwt.core.client.GWT;

import fr.lteconsulting.angular2gwt.client.JSON;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Headers;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Http;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import fr.lteconsulting.angular2gwt.demos.memos.shared.Memo;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class MemosService
{
	private Http http;

	private static final String baseUrl = "app/memos";
	private static final Headers headers = new Headers();

	static
	{
		headers.append( "Content-Type", "application/json" );
	}

	public MemosService( Http http )
	{
		this.http = http;
	}

	public Promise<JsArray<Memo>> getAll()
	{
		return http.get( baseUrl )
				.toPromise()
				.<JsArray<Memo>> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	public Promise<Memo> getMemo( String id )
	{
		return http.get( baseUrl + "/" + id )
				.toPromise()
				.<Memo> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	public Promise<Memo> delete( String id )
	{
		return http.delete( baseUrl + "/" + id )
				.toPromise()
				.<Memo> then( response -> response == null || response.text().isEmpty() ? null : response.json() )
				.onCatch( this::handleError );
	}

	public Promise<Memo> createOrUpdate( Memo Memo )
	{
		return http.post( baseUrl,
				JSON.stringify( Memo ),
				new JsObject().set( "headers", headers ) )
				.toPromise()
				.<Memo> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	private Promise<?> handleError( Object error )
	{
		// for demo purposes only, one should do more things here !
		GWT.log( "An error occurred" + error );
		return Promise.reject( error );
	}
}
