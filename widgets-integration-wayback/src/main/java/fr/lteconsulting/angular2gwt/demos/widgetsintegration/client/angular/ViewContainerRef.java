package fr.lteconsulting.angular2gwt.demos.widgetsintegration.client.angular;

import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = "ng.core" )
public class ViewContainerRef
{
	public native Object createComponent( Object factory );
}
