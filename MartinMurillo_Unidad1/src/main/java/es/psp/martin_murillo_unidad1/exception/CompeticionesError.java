package es.psp.martin_murillo_unidad1.exception;

import java.util.HashMap;
import java.util.Map;

/**
 *  Exception class
 */
public class CompeticionesError extends Exception
{

	private static final long serialVersionUID = 2430243519965740823L ;
	
	/** Attribute - code of the error */
	private int code ;
	
	/** Attribute - message of the error */
	private String message ;

	/**
	 * @param code	  
	 * @param message 
	 */
	public CompeticionesError(int code, String message)
	{
		super(message);
		
		this.code    = code ;
		this.message = message ;
	}

	/**
	 * @param code	    
	 * @param message   
	 * @param exception 
	 */
	public CompeticionesError(int code, String message, Throwable exception)
	{
		super(message, exception);

		this.code    = code ;
		this.message = message ;
	}

	public Object getBodyExceptionMessage()
	{
		Map<String, Object> mapBodyException = new HashMap<String, Object>() ;
		
		mapBodyException.put("code", this.code) ;
		mapBodyException.put("message", this.message) ;
		
		return mapBodyException ;
	}
	
}
