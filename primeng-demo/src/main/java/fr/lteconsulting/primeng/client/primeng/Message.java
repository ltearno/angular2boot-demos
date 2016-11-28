package fr.lteconsulting.primeng.client.primeng;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
public class Message
{
	public String severity;
	public String summary;
	public String detail;

	@JsOverlay
	public static Message create( String severity, String summary, String detail )
	{
		Message res = new Message();

		res.severity = severity;
		res.summary = summary;
		res.detail = detail;

		return res;
	}
}