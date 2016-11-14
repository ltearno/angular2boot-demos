package fr.lteconsulting.angular2gwt.demos.memos.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import fr.lteconsulting.angular2gwt.demos.memos.shared.Memo;

public class MemosRepository
{
	private final Map<String, Memo> memos = new HashMap<>();

	public Collection<Memo> getAll()
	{
		return memos.values();
	}

	public Memo getOne( String id )
	{
		return memos.get( id );
	}

	public Memo createOrUpdate( Memo memo )
	{
		if( memo.id == null || !memos.containsKey( memo.id ) )
			memo.id = UUID.randomUUID().toString();

		memos.put( memo.id, memo );

		return memo;
	}

	public Memo delete( String id )
	{
		memos.remove( id );

		return null;
	}
}
