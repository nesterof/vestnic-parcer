/**
 * vmf/vmf1_inputtoresult.java
 *
 * This file was generated by MapForce 2011r2.
 *
 * YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
 *
 * Refer to the MapForce Documentation for further details.
 * http://www.altova.com/mapforce
 */
package com.mapforce.vmf;
import com.altova.mapforce.*;
import com.altova.types.*;
import com.altova.xml.*;
import java.util.*;

public class vmf1_inputtoresult extends com.altova.TraceProvider 
{

	
	static class Main implements IEnumerable
	{
		String var1_input;
	
		public Main(String var1_input)
		{
			this.var1_input = var1_input;
		}

		public IEnumerator enumerator() {return new MFEmptySequence().enumerator();}
				
	}





	public static IEnumerable create(String var1_input)
	{
		if (hash == null) init();
		Object o = hash.get(var1_input);
		if (o != null)
			return new MFSingletonSequence(o);
		else
			return new MFEmptySequence();

	}
	
	private static HashMap hash = null;

	private synchronized static void init()
	{
		hash = new HashMap();
		hash.put(com.altova.CoreTypes.box("1"), com.altova.CoreTypes.box("03-20"));
		hash.put(com.altova.CoreTypes.box("2"), com.altova.CoreTypes.box("06-20"));
		hash.put(com.altova.CoreTypes.box("3"), com.altova.CoreTypes.box("09-20"));
		hash.put(com.altova.CoreTypes.box("4"), com.altova.CoreTypes.box("12-20"));
	}

}