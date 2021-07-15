package com.syniti;

import java.util.List;

import com.syniti.helper.Helper;

public class ValidateRecords {

	public static void main(String[] args) {

		// init -> instance creation
		Helper helper = new Helper();
		
		// get list of faulty records id
		List<String> faultyRecordsId = helper.processJSON();
		
		// render the record id
		for(String id: faultyRecordsId)
				System.out.println(id );
	}

}
