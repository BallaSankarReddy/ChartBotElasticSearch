package com.hcl.chartbot.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertingObjectToJson {
	
	public static String getJsonObjectMapper(Object t) {
		
		ObjectMapper Obj = new ObjectMapper(); 
		String writeValueAsString ="";
			try {
				 writeValueAsString = Obj.writeValueAsString(t);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return writeValueAsString;
		
	}
	

}
