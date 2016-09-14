package fr.lteconsulting.angular.demos.canvas.client;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Math" )
public class Math
{
	public static native double random();

	public static native int floor( double value );

	@JsOverlay
	public static int nextInt()
	{
		return (int) (floor( random() * 4294967296.0 ));
	}

	@JsOverlay
	public static int nextInt( int bound )
	{
		return nextInt() % bound;
	}

	@JsOverlay
	public static boolean nextBoolean()
	{
		return random() < 0.5;
	}
}
