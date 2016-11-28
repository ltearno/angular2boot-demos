package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.client.interop.ng.http.Http;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class CountryService
{
	private Http http;

	public CountryService( Http http )
	{
		this.http = http;
	}

	public Promise<Country[]> getCountries()
	{
		return http.get( "countries.json" )
				.toPromise()
				.then( res -> res.<Countries> json().data );
	}
}
