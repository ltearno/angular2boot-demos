package fr.lteconsulting.primeng.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.primeng.client.primeng.TreeNode;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-treetable-demo",
		templateUrl = "TreeTableDemoComponent.html" )
@JsType
public class TreeTableDemoComponent implements OnInit
{
	public JsArray<TreeNode> files;

	private NodeService nodeService;

	public TreeTableDemoComponent( NodeService nodeService )
	{
		this.nodeService = nodeService;
	}

	@Override
	public void ngOnInit()
	{
		nodeService.getFileSystem().then( files -> this.files = files );
	}
}
