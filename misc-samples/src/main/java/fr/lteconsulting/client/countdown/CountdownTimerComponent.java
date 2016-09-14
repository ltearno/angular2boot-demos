package fr.lteconsulting.client.countdown;

import fr.lteconsulting.angular2gwt.client.interop.GlobalScope;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnDestroy;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "countdown-timer",
		template = "<p>{{message}}</p>" )
@JsType
public class CountdownTimerComponent implements OnInit, OnDestroy
{
	public String message = "";

	private int intervalId = 0;
	public int seconds = 11;

	private void clearTimer()
	{
		if( intervalId != 0 )
			GlobalScope.clearInterval( intervalId );
		intervalId = 0;
	}

	@Override
	public void ngOnDestroy()
	{
		clearTimer();
	}

	@Override
	public void ngOnInit()
	{
		start();
	}

	public void start()
	{
		countDown();
	}

	public void stop()
	{
		clearTimer();
		message = "Holding at T-" + seconds + " seconds";
	}

	private void countDown()
	{
		clearTimer();
		intervalId = GlobalScope.setInterval( () -> {
			seconds -= 1;
			if( seconds == 0 )
			{
				message = "Blast off!";
			}
			else
			{
				if( seconds < 0 )
					seconds = 10;

				message = "T-" + seconds + " seconds and counting";
			}
		}, 1000 );
	}
}
