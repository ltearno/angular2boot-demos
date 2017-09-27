package fr.lteconsulting.angular2gwt.demos.orchard.client;

import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import fr.lteconsulting.angular2gwt.ng.core.Output;
import fr.lteconsulting.jsinterop.browser.Array;
import fr.lteconsulting.jsinterop.ng.core.EventEmitter;
import jsinterop.annotations.JsType;

@Component(
        selector = "my-trees",
        template = "<my-tree *ngFor='let nbFruit of treesNbFruits; let i=index;'"
                + "  [nbFruits]='nbFruit'"
                + "  [chooseTree]='chooseTree'"
                + "  (choosen)='onChoosen(i)'>"
                + "</my-tree>",
        styles = ":host { display:flex; flex-flow:row nowrap; }")
@JsType
public class TreesComponent {
    @Input
    public Array<Integer> treesNbFruits;

    @Input
    public boolean chooseTree;

    @Output
    public EventEmitter<Integer> choosen = new EventEmitter<>();

    public void onChoosen(int treeIndex) {
        choosen.emit(treeIndex);
    }
}
