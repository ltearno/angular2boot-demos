package fr.lteconsulting.client.animations;

import static fr.lteconsulting.angular2gwt.client.interop.ng.core.Core.animate;
import static fr.lteconsulting.angular2gwt.client.interop.ng.core.Core.state;
import static fr.lteconsulting.angular2gwt.client.interop.ng.core.Core.style;
import static fr.lteconsulting.angular2gwt.client.interop.ng.core.Core.transition;
import static fr.lteconsulting.angular2gwt.client.interop.ng.core.Core.trigger;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.ng.AnimationProvider;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.AnimationEntryMetadata;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.client.Hero;
import jsinterop.annotations.JsType;

@Component(
		selector = "animations",
		template = "<div>Hello animations !</div>"
				+ "<ul>"
				+ "<li *ngFor='let hero of heroes'"
				+ "  [@heroState]='hero.state'"
				+ "  (click)='hero.toggleState()'>"
				+ "  {{hero.name}} - {{hero.state}}"
				+ "</li>"
				+ "</ul>",
		animations = AnimationsComponent.Animations.class )
@JsType
public class AnimationsComponent
{
	public JsArray<Hero> heroes = JsArray.of(
			new Hero( 2, "Mandarine" ),
			new Hero( 5, "Sleepy" ),
			new Hero( 17, "Baloin" ) );

	public static class Animations implements AnimationProvider
	{
		@Override
		public AnimationEntryMetadata get()
		{
			return trigger( "heroState", JsArray.of(
					state( "inactive", style( new JsObject()
							.set( "backgroundColor", "#eee" )
							.set( "transform", "scale(1)" ) ) ),
					state( "active", style( new JsObject()
							.set( "backgroundColor", "#cfd8dc" )
							.set( "transform", "scale(1.1)" ) ) ),
					transition( "inactive => active", JsArray.of(
							style( new JsObject()
									.set( "backgroundColor", "#cfd8dc" )
									.set( "transform", "scale(1.3)" ) ),
							animate( "100ms ease-in" ) ) ),
					transition( "active => inactive", animate( "100ms ease-out" ) ) ) );
		}
	}
}
