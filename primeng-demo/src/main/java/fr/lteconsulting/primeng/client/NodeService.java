package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Http;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import fr.lteconsulting.primeng.client.primeng.TreeNode;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class NodeService
{
	private Http http;

	public NodeService( Http http )
	{
		this.http = http;
	}

	public Promise<JsArray<TreeNode>> getFileSystem()
	{
		return this.http.get( "filesystem.json" )
				.toPromise()
				.then( res -> res.<JsObject> json().<JsArray<TreeNode>> get( "data" ) );
	}
}
