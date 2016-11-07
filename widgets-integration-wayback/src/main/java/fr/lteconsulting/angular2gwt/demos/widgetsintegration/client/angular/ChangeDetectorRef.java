package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular;

import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = "ng.core" )
public class ChangeDetectorRef
{
	public native void detectChanges();

	public native void destroy();

	public native void detach();

	public native void reattach();
}
