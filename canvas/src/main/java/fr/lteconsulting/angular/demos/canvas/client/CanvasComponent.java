package fr.lteconsulting.angular.demos.canvas.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.GlobalScope;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnDestroy;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "mb-canvas",
		template = "<svg [attr.viewBox]='getViewBox()' preserveAspectRatio='xMidYMid meet' (click)='toggleRunning()'>" +
				"<svg:g mb-circle *ngFor='let circle of circles' [circle]='circle'/></svg>",
		styleUrls = "canvas.component.css" )
@JsType
public class CanvasComponent implements OnInit, OnDestroy
{
	@JsProperty
	private JsArray<Circle> circles;

	private final CirclesService circlesService;
	private boolean running = false;

	private final int canvasWidth;
	private final int canvasHeight;

	public CanvasComponent( CirclesService circlesService, ApplicationConfiguration config )
	{
		this.circlesService = circlesService;
		this.canvasWidth = config.canvasWidth;
		this.canvasHeight = config.canvasHeight;

		circles = circlesService.circles;
	}

	@Override
	public void ngOnInit()
	{
		running = true;
		animationFrame();
	}

	@JsMethod
	private String getViewBox()
	{
		return "0 0 " + canvasWidth + " " + canvasHeight;
	}

	@JsMethod
	private void toggleRunning()
	{
		running = !running;

		animationFrame();
	}

	@Override
	public void ngOnDestroy()
	{
		running = false;
	}

	private void animationFrame()
	{
		circlesService.update();
		if( running )
			GlobalScope.requestAnimationFrame( this::animationFrame );
	}
}