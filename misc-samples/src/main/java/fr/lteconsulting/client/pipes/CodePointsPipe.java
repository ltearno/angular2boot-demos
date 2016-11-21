package fr.lteconsulting.client.pipes;

import fr.lteconsulting.angular2gwt.client.interop.ng.core.PipeTransform;
import fr.lteconsulting.angular2gwt.ng.core.Pipe;
import fr.lteconsulting.client.LoggerService;
import jsinterop.annotations.JsType;

@Pipe( name = "codepoints" )
@JsType
public class CodePointsPipe implements PipeTransform<String>
{
	private LoggerService logger;

	public CodePointsPipe( LoggerService logger )
	{
		this.logger = logger;
	}

	@Override
	public String transform( String value, Object... parameters )
	{
		if( value == null )
			return null;

		StringBuilder sb = new StringBuilder();

		boolean toHex = parameters.length > 0 && "hex".equals( parameters[0] );

		for( int i = 0; i < value.length(); i++ )
		{
			if( i > 0 )
				sb.append( " " );

			sb.append( value.charAt( i ) );
			sb.append( "(" );
			if( toHex )
				sb.append( Integer.toHexString( value.codePointAt( i ) ) );
			else
				sb.append( value.codePointAt( i ) );
			sb.append( ")" );
		}

		String result = sb.toString();

		logger.log( "HexLettersPipe, transform '" + value + "' to '" + result + "'" );

		return result;
	}
}
