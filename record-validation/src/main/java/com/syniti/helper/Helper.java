package com.syniti.helper;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.syniti.model.Person;

public class Helper {
	
	private static final String ZIP_REGEX = "^[0-9]{5}(?:-[0-9]{4})?$"; 
	
	/**
	 * @author Amarjit
	 * This method will scan the entire data.json file and convert into
	 * List<Person> java object
	 * @return List<Person>
	 */
	public static List<Person> readJSON() {
		List<Person> listOfPerson = null;
		Gson gson = new Gson();
		
		try {
		 Reader reader = Files.newBufferedReader(Paths.get("data.json"));
		 listOfPerson = gson.fromJson(reader, new TypeToken<List<Person>>() {}.getType());
		 reader.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return listOfPerson;
	}
	
	// validating name field
	private boolean isNameValueInvalid(Person person) {
		return ( person.getName() == null || person.getName().equals(""));
	}
	
	// validating address field
	private boolean isAddressValueInvalid(Person person) {
		return (person.getAddress() == null ||  person.getAddress().equals(""));
	}
	
	// validating zip field field
	private boolean isZipValueInvalid(Person person) {
		return ( person.getZip() == null || person.getZip().equals("") ||
				 !person.getZip().matches(ZIP_REGEX));
	}
	
	/**
	 * This method will give you all list of all faulty records id
	 * 
	 * @return List<String>
	 */
	public  List<String> processJSON() {
		
		List<Person> personList = readJSON();
		Set<String> faultyRecords = new HashSet<>();
		Map<Person, Person> uniqueRecords = new LinkedHashMap<>();
		
		for (Person person : personList) {
			// records with invalid values (name or address or zip)
			if (isNameValueInvalid(person) || isAddressValueInvalid(person) ||
					isZipValueInvalid(person)) {
				faultyRecords.add(person.getId());
				
				// duplicate records
			} else if (uniqueRecords.containsKey(person)) {
				faultyRecords.add(person.getId());
				faultyRecords.add(uniqueRecords.get(person).getId());
				
			} else {
				uniqueRecords.put(person, person);
			}
		}
		return new ArrayList<>(faultyRecords);
	}

}
