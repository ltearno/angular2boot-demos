package fr.lteconsulting.client.mainchild;

import java.util.Map.Entry;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.Event;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.EventEmitter;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnChanges;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.SimpleChange;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.SimpleChanges;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import fr.lteconsulting.angular2gwt.ng.core.Output;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-child",
		template = "<h1>{{title}} - I am {{name}}</h1>" +
				"<button (click)='click($event)'>Click</button>" +
				"<ul><li *ngFor='let item of history'>Changed {{item}}</li></ul>" )
@JsType
public class ChildComponent implements OnChanges
{
	public String title = "Child component";

	public JsArray<String> history = JsArray.of();

	@Output
	public final EventEmitter<String> em = new EventEmitter<>();

	private String _name;

	@Input
	public void setName( String name )
	{
		_name = name.trim().toUpperCase();
	}

	protected String getName()
	{
		return _name;
	}

	@Override
	public void ngOnChanges( SimpleChanges o )
	{
		for( Entry<String, SimpleChange> e : o.changes() )
		{
			history.push( (e.getValue().isFirstChange() ? "(FIRST_CHANGE) " : "") + e.getKey() + " from '" + e.getValue().previousValue + "' to '" + e.getValue().currentValue + "'" );
		}
	}

	public void click( Event e )
	{
		em.emit( "hello to subscribers !" );
	}
}
