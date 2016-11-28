package fr.lteconsulting.primeng.client;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
public class Country
{
	public String name;
	public String code;
}
