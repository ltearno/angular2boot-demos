package fr.lteconsulting.angular.demos.canvas.client;

import jsinterop.annotations.JsType;

@JsType
public class Circle
{
	public int x;
	public int y;
	public int radius;
	public int xMove;
	public int yMove;

	public Circle( int x, int y, int radius, int xMove, int yMove )
	{
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.xMove = xMove;
		this.yMove = yMove;
	}
}