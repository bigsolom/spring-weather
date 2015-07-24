package com.efoad.weather.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Service
public class ErrorMappingService {
	
	private static String baseErrorsKey = "base";
	
	public ErrorMappingService(){
		
	}
	
	public Map<String, List<String>> getErrors(List<ObjectError> errorsObject){
		Map<String, List<String>> errors = new HashMap<String, List<String>>();
		for(ObjectError error: errorsObject){
			
			String key;
			if (error instanceof FieldError){
				key = ((FieldError)error).getField();
			}else{
				key = baseErrorsKey;
			}
			List<String> subErrors = errors.getOrDefault(key, new ArrayList<String>());
			subErrors.add(error.getDefaultMessage());
			errors.put(key, subErrors);
			
		}
		return errors;
	}
}
