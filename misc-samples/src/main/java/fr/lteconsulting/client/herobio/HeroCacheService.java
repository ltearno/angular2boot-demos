package fr.lteconsulting.client.herobio;

import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import fr.lteconsulting.client.Hero;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class HeroCacheService
{
	public Hero hero;

	public Hero fetchCachedHero( int id )
	{
		if( hero == null )
			hero = new Hero( id, "Hero number " + id );

		return hero;
	}
}
