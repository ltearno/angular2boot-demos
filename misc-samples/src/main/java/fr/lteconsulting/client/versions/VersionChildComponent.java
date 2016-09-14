package fr.lteconsulting.client.versions;

import java.util.Map.Entry;

import fr.lteconsulting.angular2gwt.client.JSON;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnChanges;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.SimpleChange;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.SimpleChanges;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import jsinterop.annotations.JsType;

@Component( selector = "version-child",
		template = "<h3>Version {{major}}.{{minor}}</h3>" +
				"<h4>Change log:</h4>" +
				"<ul>" +
				"  <li *ngFor='let change of changeLog'>{{change}}</li>" +
				"</ul>" )
@JsType
public class VersionChildComponent implements OnChanges
{
	@Input
	public int major;

	@Input
	public int minor;
	
	public JsArray<String> changeLog = JsArray.empty();

	@Override
	public void ngOnChanges( SimpleChanges changes )
	{
		JsArray<String> log = JsArray.empty();

		for( Entry<String, SimpleChange> entry : changes.changes() )
		{
			SimpleChange change = entry.getValue();

			String from = JSON.stringify( change.previousValue );
			String to = JSON.stringify( change.currentValue );

			log.push( entry.getKey() + " changed from " + from + " to " + to );
		}

		changeLog.push( log.join( ", " ) );
	}
}
