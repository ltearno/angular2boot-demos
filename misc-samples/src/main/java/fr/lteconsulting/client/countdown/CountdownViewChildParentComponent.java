package fr.lteconsulting.client.countdown;

import fr.lteconsulting.angular2gwt.client.interop.GlobalScope;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.AfterViewInit;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.ViewChild;
import jsinterop.annotations.JsType;

@Component(
		selector = "countdown-parent-vc",
		template = "<h1>Countdown to Liftoff (via ViewChild)</h1>" +
				"<button (click)='start()'>Start</button>" +
				"<button (click)='stop()'>Stop</button>" +
				"<div class='seconds'>{{ seconds() }}</div>" +
				"<countdown-timer></countdown-timer>" )
@JsType
public class CountdownViewChildParentComponent implements AfterViewInit
{
	@ViewChild( component = CountdownTimerComponent.class )
	public CountdownTimerComponent timerComponent = null;

	public int seconds()
	{
		if( !initialized || timerComponent == null )
			return 0;
		else
			return timerComponent.seconds;
	}

	private boolean initialized = false;

	@Override
	public void ngAfterViewInit()
	{
		GlobalScope.setTimeout( () -> initialized = true, 0 );
	}

	public void start()
	{
		timerComponent.start();
	}

	public void stop()
	{
		timerComponent.stop();
	}
}
