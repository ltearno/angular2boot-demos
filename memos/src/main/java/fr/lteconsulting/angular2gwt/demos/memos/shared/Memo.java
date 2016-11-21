package fr.lteconsulting.angular2gwt.demos.memos.shared;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
public class Memo
{
	public String id;
	public String title;
	public String description;
}
