package fr.lteconsulting.angular2gwt.demos.orchard.client;

import fr.lteconsulting.angular2gwt.client.interop.ng.core.EventEmitter;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import fr.lteconsulting.angular2gwt.ng.core.Output;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-dice",
		template = "<button (click)='roll()' class='waves-effect waves-light btn'>"
				+ "    Roll {{nbFaces}} faces dice</button>" )
@JsType
public class DiceComponent
{
	@Input
	public int nbFaces;

	@Output
	public EventEmitter<Integer> diceRolled = new EventEmitter<>();

	public void roll()
	{
		int n = (int) (Math.random() * nbFaces) % nbFaces;

		diceRolled.emit( n );
	}
}
