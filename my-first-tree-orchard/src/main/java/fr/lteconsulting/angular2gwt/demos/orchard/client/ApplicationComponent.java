package fr.lteconsulting.angular2gwt.demos.orchard.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-app",
		template = "<h1 class='noGrow'>{{title}}</h1>"
				+ "<h2 *ngIf='winner' class='fullSize' >The winner is : {{winner}}"
				+ "  <button (click)='restart()'>Restart</button>"
				+ "</h2>"
				+ "<div *ngIf='!winner' class='growFull' style='display: flex; flex-flow: column nowrap;' >"
				+ "  <h2 class='noGrow'>{{message}}</h2>"
				+ "  <my-dice *ngIf='!chooseTree'"
				+ "    style='padding: 0.25em;'"
				+ "    [nbFaces]='state.trees.length + 2'"
				+ "    (diceRolled)='onDiceRolled($event)'></my-dice>"
				+ "  <my-crow style='padding: 0.25em;'"
				+ "    [position]='state.crowPosition'></my-crow>"
				+ "  <my-trees"
				+ "    [chooseTree]='chooseTree'"
				+ "    [treesNbFruits]='state.trees'"
				+ "    (choosen)='onTreeChoosen($event)'></my-trees>"
				+ "  <div class='noGrow' style='padding:1em; overflow:auto;'>"
				+ "    <div class='messages' *ngFor='let message of history'>{{message}}</div>"
				+ "  </div>"
				+ "</div>",
		styleUrls = "ApplicationComponent.css" )
@JsType
public class ApplicationComponent
{
	public String title = "My first tree orchard";

	public String message = "Roll the dice please !";

	public JsArray<String> history = JsArray.<String> empty();

	@JsProperty
	public String getWinner()
	{
		if( state.crowPosition == 0 )
			return "The crow";
		else if( fruitsLeft() == 0 )
			return "You !";
		else
			return null;
	}

	public GameState state = new GameState();

	public boolean chooseTree = false;

	public void onDiceRolled( int diceValue )
	{
		diceValue *= 1;

		log( "Dice rolled, result : " + (diceValue + 1) );

		if( chooseTree )
		{
			log( "You cannot roll the dice, please choose a tree to remove a fruit from !" );
			return;
		}

		if( diceValue >= state.trees.length() )
		{
			int fake = diceValue - state.trees.length();
			if( fake == 0 )
			{
				log( "The crow is arriving !" );

				state.crowPosition--;
			}
			else
			{
				log( "Please choose a tree to remove a fruit from" );
				chooseTree = true;
			}
		}
		else
		{
			if( state.trees.get( diceValue ) == 0 )
			{
				log( "No fruit left on this tree, sorry !" );
				return;
			}
			else
			{
				log( "You ate a fruit on tree " + (diceValue + 1) + "!" );
				state.trees.set( diceValue, state.trees.get( diceValue ) - 1 );
			}
		}
	}

	public void onTreeChoosen( int treeIndex )
	{
		if( !chooseTree )
		{
			log( "It's not the time to choose a tree !" );
			return;
		}

		chooseTree = false;

		if( state.trees.get( treeIndex ) > 0 )
		{
			state.trees.set( treeIndex, state.trees.get( treeIndex ) - 1 );
			message = "Roll the dice please !";
		}
		else
		{
			log( "You cannot choose this tree, it's empty" );
		}
	}

	public void restart()
	{
		state = new GameState();
		history = JsArray.empty();
		log( "Game started !" );
	}

	private void log( String message )
	{
		this.message = message;
		history.push( message );

		int length = history.length();
		if( length > 4 )
			history = history.slice( length - 4, length );
	}

	private int fruitsLeft()
	{
		int res = 0;
		for( int left : state.trees.iterate() )
			res += left;
		return res;
	}
}
