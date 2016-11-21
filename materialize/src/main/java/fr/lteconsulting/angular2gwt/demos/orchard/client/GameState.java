package fr.lteconsulting.angular2gwt.demos.orchard.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import jsinterop.annotations.JsType;

@JsType
public class GameState
{
	public int crowPosition = 4;
	public JsArray<Integer> trees = JsArray.of( 4, 4, 4, 4 );
}
