package fr.lteconsulting.server;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.lteconsulting.client.Hero;

@RequestMapping( "/app" )
@RestController
@EnableAutoConfiguration
public class ApplicationController
{
	public static void main( String[] args ) throws Exception
	{
		SpringApplication.run( ApplicationController.class, args );
	}

	private List<Hero> heroes = new ArrayList<>( MockHeroes.HEROES );
	private int nextId = 60;

	@RequestMapping( value = "/heroes", method = RequestMethod.GET, produces = "application/json" )
	List<Hero> getHeroes()
	{
		return heroes;
	}

	@RequestMapping( value = "/heroes", params = { "name" }, method = RequestMethod.GET, produces = "application/json" )
	List<Hero> getHeroes( @RequestParam String name )
	{
		return heroes.stream().filter( hero -> hero.name.toLowerCase().contains( name.toLowerCase() ) ).collect( Collectors.toList() );
	}

	@RequestMapping( value = "/heroes/{id}", method = RequestMethod.GET, produces = "application/json" )
	Hero getHero( @PathVariable( "id" ) int id )
	{
		return heroes.stream().filter( hero -> hero.id == id ).findFirst().orElse( null );
	}

	@RequestMapping( value = "/heroes", method = RequestMethod.POST, produces = "application/json" )
	Hero addHero( @RequestBody Hero hero )
	{
		hero.id = nextId++;
		heroes.add( hero );
		return hero;
	}

	@RequestMapping( value = "/heroes/{id}", method = RequestMethod.PUT, produces = "application/json" )
	Hero updateHero( @PathVariable( "id" ) int id, @RequestBody Hero hero )
	{
		hero.id = id;

		heroes.stream().filter( h -> h.id == hero.id ).findFirst().ifPresent( h -> {
			int index = heroes.indexOf( h );
			heroes.set( index, hero );
		} );

		return hero;
	}

	@RequestMapping( value = "/heroes/{id}", method = RequestMethod.DELETE )
	Boolean deleteHero( @PathVariable( "id" ) int id )
	{
		heroes.stream().filter( hero -> hero.id == id ).findFirst().ifPresent( hero -> heroes.remove( hero ) );
		return true;
	}
}