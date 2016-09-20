package fr.lteconsulting.angular2gwt.demos.orchard.client;

import fr.lteconsulting.angular2gwt.client.interop.ng.core.EventEmitter;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import fr.lteconsulting.angular2gwt.ng.core.Output;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-tree",
		template = "<div [class.empty]='nbFruits==0'>{{nbFruits}} fruit(s) left"
				+ "  <button *ngIf='chooseTree && nbFruits>0'"
				+ "    (click)='choose()'>Take a fruit</button>"
				+ "</div>",
		styleUrls = "TreeComponent.css" )
@JsType
public class TreeComponent
{
	@Input
	public int nbFruits;

	@Input
	public boolean chooseTree;

	@Output
	public EventEmitter<Void> choosen = new EventEmitter<>();

	public void choose()
	{
		choosen.emit( null );
	}
}
