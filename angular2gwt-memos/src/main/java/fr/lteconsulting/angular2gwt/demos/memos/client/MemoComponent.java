package fr.lteconsulting.angular2gwt.demos.memos.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.ActivatedRoute;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.Router;
import fr.lteconsulting.angular2gwt.demos.memos.shared.Memo;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-memo-edition",
		templateUrl = "MemoComponent.html" )
@JsType
public class MemoComponent implements OnInit
{
	private final MemosService service;
	private final ActivatedRoute route;
	private final Router router;

	public boolean editionMode;

	public Memo memo;

	public MemoComponent( MemosService service, ActivatedRoute route, Router router )
	{
		this.service = service;
		this.route = route;
		this.router = router;
	}

	@Override
	public void ngOnInit()
	{
		route.params.subscribe( parameters -> {
			String id = parameters.get( "id" );
			if( id == null || id.isEmpty() )
			{
				memo = new Memo();
				editionMode = true;
			}
			else
			{
				service.getMemo( id ).then( result -> {
					memo = result;
					return null;
				} );
			}
		} );
	}

	public void edit()
	{
		editionMode = true;
	}

	public void view()
	{
		if( memo == null || memo.id == null )
			router.navigate( JsArray.of( "memos" ) );
		else
			editionMode = false;
	}

	public void save( Memo item )
	{
		boolean isNew = memo.id == null;

		item.id = memo.id;

		service.createOrUpdate( item ).then( result -> {
			memo = result;
			editionMode = false;

			if( isNew )
				router.navigate( JsArray.of( "memo", result.id ) );

			return null;
		} );
	}
}
