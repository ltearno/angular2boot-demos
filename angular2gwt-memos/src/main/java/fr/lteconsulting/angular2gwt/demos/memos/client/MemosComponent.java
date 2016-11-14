package fr.lteconsulting.angular2gwt.demos.memos.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.Router;
import fr.lteconsulting.angular2gwt.demos.memos.shared.Memo;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-memos",
		templateUrl = "MemosComponent.html" )
@JsType
public class MemosComponent implements OnInit
{
	public JsArray<Memo> memos;

	private final MemosService service;
	private final Router router;

	public MemosComponent( MemosService service, Router router )
	{
		this.service = service;
		this.router = router;
	}

	@Override
	public void ngOnInit()
	{
		service.getAll().then( results -> {
			memos = results;
			return null;
		} );

	}

	public void createMemo()
	{
		router.navigate( JsArray.of( "memo" ) );
	}

	public void detailMemo( Memo memo )
	{
		router.navigate( JsArray.of( "memo", memo.id ) );
	}

	public void deleteMemo( String id )
	{
		service.delete( id )
				.then( deleted -> {
					if( deleted == null )
						memos = memos.filter( m -> !m.id.equals( id ) );
					return null;
				} );
	}
}
