package fr.lteconsulting.primeng.client;

import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = "google.maps" )
public class InfoWindow
{
	public native void setContent( String string );
	public native void open( Object object, Object object2 );
}
