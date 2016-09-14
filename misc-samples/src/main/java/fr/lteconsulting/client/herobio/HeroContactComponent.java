package fr.lteconsulting.client.herobio;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Host;
import fr.lteconsulting.angular2gwt.ng.core.Optional;
import fr.lteconsulting.angular2gwt.ng.core.PropertyGetter;
import fr.lteconsulting.client.LoggerService;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

@Component(
		selector = "hero-contact",
		template = "<div>Phone #: {{myPhoneNumber}}"
				+ "<span *ngIf='hasLogger'>!!!</span>" +
				"</div>" )
@JsType
public class HeroContactComponent
{
	public boolean hasLogger = false;

	private HeroCacheService heroCache;

	// limit to the host component's instance of the HeroCacheService
	// limit search for logger; hides the application-wide logger and ok if the
	// logger doesn't exist
	@JsConstructor
	HeroContactComponent( @Host HeroCacheService heroCache, @Host @Optional LoggerService loggerService )
	{
		this.heroCache = heroCache;

		if( loggerService != null )
		{
			hasLogger = true;
			loggerService.log( "HeroContactComponent can log!" );
		}
	}

	/**
	 * This @PropertyGetter annotation triggers the creation of a Js property
	 * associated with the current getter
	 */
	@PropertyGetter
	String getMyPhoneNumber()
	{
		return heroCache.hero.phoneNumber;
	}
}
