package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.primeng.client.primeng.MenuItem;
import fr.lteconsulting.primeng.client.primeng.Message;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-splitbutton-demo",
		templateUrl = "SplitButtonDemoComponent.html" )
@JsType
public class SplitButtonDemoComponent implements OnInit
{
	public JsArray<Message> msgs = JsArray.empty();

	public JsArray<MenuItem> items;

	@Override
	public void ngOnInit()
	{
		items = JsArray.of(
				MenuItem.create( "Update", "fa-refresh", this::update ),
				MenuItem.create( "Delete", "fa-close", this::delete ),
				MenuItem.create( "Angular.io", "fa-link", "http://angular.io" ),
				MenuItem.create( "Theming", "fa-paint-brush", JsArray.of( "/theming" ) ) );
	}

	public void save()
	{
		msgs = JsArray.empty();
		msgs.push( Message.create( "info", "Success", "Data Saved" ) );
	}

	public void update()
	{
		msgs = JsArray.empty();
		msgs.push( Message.create( "info", "Success", "Data Updated" ) );
	}

	public void delete()
	{
		msgs = JsArray.empty();
		msgs.push( Message.create( "info", "Success", "Data Deleted" ) );
	}
}
