package fr.lteconsulting.primeng.client.primeng;

import fr.lteconsulting.angular2gwt.client.JsArray;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
public class MenuItem
{
	public String label;
	public String icon;
	public Command command;
	public String url;
	public JsArray<String> routerLink;

	@JsOverlay
	public static MenuItem create( String label, String icon, Command command )
	{
		MenuItem res = new MenuItem();

		res.label = label;
		res.icon = icon;
		res.command = command;

		return res;
	}

	@JsOverlay
	public static MenuItem create( String label, String icon, String url )
	{
		MenuItem res = new MenuItem();

		res.label = label;
		res.icon = icon;
		res.url = url;

		return res;
	}

	@JsOverlay
	public static MenuItem create( String label, String icon, JsArray<String> routerLink )
	{
		MenuItem res = new MenuItem();

		res.label = label;
		res.icon = icon;
		res.routerLink = routerLink;

		return res;
	}
}