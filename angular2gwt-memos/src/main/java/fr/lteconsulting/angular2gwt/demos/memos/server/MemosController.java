package fr.lteconsulting.angular2gwt.demos.memos.server;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lteconsulting.angular2gwt.demos.memos.shared.Memo;

@RestController
@RequestMapping( "/app/memos" )
public class MemosController
{
	@Autowired
	private MemosRepository repository;

	@GetMapping
	public Collection<Memo> getAll()
	{
		return repository.getAll();
	}

	@GetMapping( "/{id}" )
	public Memo getOne( @PathVariable( "id" ) String id )
	{
		return repository.getOne( id );
	}

	@PostMapping
	public Memo createOrUpdate( @RequestBody Memo memo )
	{
		return repository.createOrUpdate( memo );
	}

	@DeleteMapping( "/{id}" )
	public Memo deleteOne( @PathVariable( "id" ) String id )
	{
		return repository.delete( id );
	}
}
