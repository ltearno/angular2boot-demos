package fr.lteconsulting.angular.demos.canvas.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class CirclesService
{
	public JsArray<Circle> circles;

	private final int canvasWidth;
	private final int canvasHeight;

	public CirclesService( ApplicationConfiguration config )
	{
		this.canvasHeight = config.canvasHeight;
		this.canvasWidth = config.canvasWidth;

		circles = new JsArray<>();
		for( int i = 0; i < 10; i++ )
		{
			circles.push( new Circle(
					Math.nextInt( canvasWidth ),
					Math.nextInt( canvasHeight ),
					Math.nextInt( 100 ) + 10,
					Math.nextInt( 5 ) - 2,
					Math.nextInt( 5 ) - 2 ) );
		}
	}

	public void update()
	{
		for( Circle circle : circles.iterate() )
		{
			circle.x += circle.xMove;
			circle.y += circle.yMove;

			if( circle.x > (canvasWidth + circle.radius) )
				circle.x = 0 - circle.radius;

			if( circle.x < (0 - circle.radius) )
				circle.x = canvasWidth + circle.radius;

			if( circle.y > (canvasHeight + circle.radius) )
				circle.y = 0 - circle.radius;

			if( circle.y < (0 - circle.radius) )
				circle.y = canvasHeight + circle.radius;
		}
	}
}
