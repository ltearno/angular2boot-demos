package fr.lteconsulting.primeng.client;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = "google.maps", name = "Map" )
public class Map
{
	@JsProperty( namespace = JsPackage.GLOBAL, name = "googleMapsInitialized" )
	public static native boolean googleMapsInitialized();

	@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
	public static class Options
	{
		public LatLngLiteral center;
		public String mapTypeId;
		public boolean scrollwheel;
		public int zoom;
	}

	public native void setCenter( LatLngLiteral position );

	public native void setCenter( LatLng position );
}
