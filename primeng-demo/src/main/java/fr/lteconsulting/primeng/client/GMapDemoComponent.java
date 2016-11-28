package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.primeng.client.primeng.Message;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-gmap-demo",
		templateUrl = "GMapDemoComponent.html" )
@JsType
public class GMapDemoComponent implements OnInit
{
	public JsObject options;

	public JsArray<Object> overlays;

	public boolean dialogVisible;

	public String markerTitle;

	public Object selectedPosition;

	public InfoWindow infoWindow;

	public boolean draggable;

	public JsArray<Message> msgs = JsArray.empty();

	@Override
	public void ngOnInit()
	{
		options = new JsObject()
				.set( "center", new JsObject()
						.set( "lat", 36.890257 )
						.set( "lng", 30.707417 ) )
				.set( "zoom", 12 );

		initOverlays();

		infoWindow = new InfoWindow();
	}

	public void handleMapClick( JsObject event )
	{
		dialogVisible = true;
		selectedPosition = event.get( "latLng" );
	}

	public void handleOverlayClick( JsObject event )
	{
		msgs = JsArray.empty();
		boolean isMarker = event.<JsObject> get( "overlay" ).get( "title" ) != null;

		if( isMarker )
		{
			String title = event.<JsObject> get( "overlay" ).get( "title" );
			infoWindow.setContent( "" + title + "" );
			infoWindow.open( event.get( "map" ), event.get( "overlay" ) );
			event.<JsObject> get( "map" ).set( "center", event.<JsObject> get( "overlay" ).get( "position" ) );

			this.msgs.push( Message.create( "info", "Marker Selected", title ) );
		}
		else
		{
			this.msgs.push( Message.create( "info", "Shape Selected", "" ) );
		}
	}

	public void addMarker()
	{
		// overlays.push(new Marker({position:{lat: this.selectedPosition.lat(), lng: this.selectedPosition.lng()}, title:this.markerTitle, draggable:
		// this.draggable}));
		markerTitle = null;
		dialogVisible = false;
	}

	public void handleDragEnd( JsObject event )
	{
		msgs = JsArray.empty();
		msgs.push( Message.create( "info", "Marker Dragged", event.<JsObject> get( "overlay" ).get( "title" ) ) );
	}

	public void initOverlays()
	{
		if( overlays != null && overlays.length() > 0 )
			return;

		// overlays = JsArray.of(
		// new Marker({position: {lat: 36.879466, lng: 30.667648}, title:"Konyaalti"}),
		// new Marker({position: {lat: 36.883707, lng: 30.689216}, title:"Ataturk Park"}),
		// new Marker({position: {lat: 36.885233, lng: 30.702323}, title:"Oldtown"}),
		// new Polygon({paths: [
		// {lat: 36.9177, lng: 30.7854},{lat: 36.8851, lng: 30.7802},{lat: 36.8829, lng: 30.8111},{lat: 36.9177, lng: 30.8159}
		// ], strokeOpacity: 0.5, strokeWeight: 1,fillColor: '#1976D2', fillOpacity: 0.35
		// }),
		// new Circle({center: {lat: 36.90707, lng: 30.56533}, fillColor: '#1976D2', fillOpacity: 0.35, strokeWeight: 1, radius: 1500}),
		// new Polyline({path: [{lat: 36.86149, lng: 30.63743},{lat: 36.86341, lng: 30.72463}], geodesic: true, strokeColor: '#FF0000', strokeOpacity: 0.5,
		// strokeWeight: 2})
		// );
	}

	public void zoomIn( Object map )
	{
		// map.setZoom(map.getZoom()+1);
	}

	public void zoomOut( Object map )
	{
		// map.setZoom(map.getZoom()-1);
	}

	public void clear()
	{
		overlays = JsArray.empty();
	}
}
