package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.GlobalScope;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-autocomplete-demo",
		templateUrl = "AutoCompleteDemoComponent.html" )
@JsType
public class AutoCompleteDemoComponent
{
	private CountryService countryService;

	public Object country;

	public JsArray<Country> countries;

	public JsArray<Country> filteredCountriesSingle;

	public JsArray<Country> filteredCountriesMultiple;

	public JsArray<String> brands = JsArray.of( "Audi", "BMW", "Fiat", "Ford", "Honda", "Jaguar", "Mercedes", "Renault", "Volvo", "VW" );

	public JsArray<String> filteredBrands;

	public String brand;

	public AutoCompleteDemoComponent( CountryService countryService )
	{
		this.countryService = countryService;
	}

	public void filterCountrySingle( JsObject event )
	{
		String query = event.get( "query" );
		countryService.getCountries().then( countries -> {
			filteredCountriesSingle = filterCountry( query, countries );
			return null;
		} );
	}

	public void filterCountryMultiple( JsObject event )
	{
		String query = event.get( "query" );
		countryService.getCountries().then( countries -> {
			filteredCountriesMultiple = filterCountry( query, countries );
			return null;
		} );
	}

	public JsArray<Country> filterCountry( String query, Country[] countries )
	{
		// in a real application, make a request to a remote url with the query and return filtered results, for demo we filter at client side
		JsArray<Country> filtered = JsArray.empty();
		for( int i = 0; i < countries.length; i++ )
		{
			Country country = countries[i];
			if( country.name.toLowerCase().indexOf( query.toLowerCase() ) == 0 )
			{
				filtered.push( country );
			}
		}
		return filtered;
	}

	public void filterBrands( JsObject event )
	{
		String query = event.get( "query" );
		filteredBrands = JsArray.empty();
		for( int i = 0; i < brands.length(); i++ )
		{
			String brand = brands.get( i );
			if( brand.toLowerCase().indexOf( query.toLowerCase() ) == 0 )
			{
				this.filteredBrands.push( brand );
			}
		}
	}

	public void handleDropdownClick()
	{
		filteredBrands = JsArray.empty();

		// mimic remote call
		GlobalScope.setTimeout( () -> {
			filteredBrands = brands;
		}, 100 );
	}
}
