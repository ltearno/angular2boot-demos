package fr.lteconsulting.angular2gwt.demos.memos.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.ng.ProviderWrapper;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.RouterConfig;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.RouterModule;

public class Routes implements ProviderWrapper
{
	@Override
	public Object get()
	{
		return RouterModule.forRoot( JsArray.of(
				RouterConfig.route( "", "/memos", "full" ),
				RouterConfig.route( "memos", MemosComponent_AngularComponent.getComponentPrototype() ),
				RouterConfig.route( "memo", MemoComponent_AngularComponent.getComponentPrototype() ),
				RouterConfig.route( "memo/:id", MemoComponent_AngularComponent.getComponentPrototype() )),
				new JsObject().set( "useHash", true ) );
	}
}
