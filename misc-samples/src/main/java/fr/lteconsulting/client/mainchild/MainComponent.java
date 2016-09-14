package fr.lteconsulting.client.mainchild;

import java.util.Date;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "main",
		template = "<h1>{{title}}</h1>" +
				"<my-child (em)='baby($event)' [name]='childName'></my-child>" +
				"<input [(ngModel)]='childName' type='text'/>" +
				"<ul><li *ngFor='let item of history'>Changed {{item}}</li></ul>" )
@JsType
public class MainComponent
{
	public String childName = "init";
	public String title = "Main component";
	public JsArray<String> history = JsArray.of();

	public void baby( String item )
	{
		history.push( "received an event from the child : " + item );
		childName = new Date().toString();
	}
}
