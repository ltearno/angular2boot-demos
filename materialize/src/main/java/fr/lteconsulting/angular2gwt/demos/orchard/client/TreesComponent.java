package fr.lteconsulting.angular2gwt.demos.orchard.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.EventEmitter;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import fr.lteconsulting.angular2gwt.ng.core.Output;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-trees",
		template = "<my-tree *ngFor='let treeIndex of treesIndices'"
				+ "  [nbFruits]='treesNbFruits[treeIndex]'"
				+ "  [chooseTree]='chooseTree'"
				+ "  (choosen)='onChoosen(treeIndex)'>"
				+ "</my-tree>",
		styles = ":host { display:flex; flex-flow:row nowrap; }" )
@JsType
public class TreesComponent
{
	@Input
	public JsArray<Integer> treesNbFruits;

	@Input
	public boolean chooseTree;

	@Output
	public EventEmitter<Integer> choosen = new EventEmitter<>();

	public JsArray<Integer> treesIndices = JsArray.of( 0, 1, 2, 3 );

	public void onChoosen( int treeIndex )
	{
		choosen.emit( treeIndex );
	}
}
