package fr.lteconsulting.primeng.client;


import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = "google.maps" )
public class Marker
{
	@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
	public static class MarkerOptions
	{
		public Map map;
		public LatLngLiteral position;
		public String title;
		public boolean draggable;
	}

	@JsOverlay
	public static Marker addMarker( Map map, LatLngLiteral position, String title, boolean draggable )
	{
		MarkerOptions options = new MarkerOptions();
		options.map = map;
		options.position = position;
		options.title = title;
		options.draggable = draggable;

		return new Marker( options );
	}

	public Marker( MarkerOptions options )
	{
		// vide, implÃ©mentÃ© en JS
	}

	public native LatLng getPosition();

	public native void setPosition( LatLng position );

	public native void setPosition( LatLngLiteral position );
}
