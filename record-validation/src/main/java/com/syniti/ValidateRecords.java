package com.syniti;

import java.util.List;

import com.syniti.helper.Helper;

public class ValidateRecords {

	public static void main(String[] args) {
		Helper helper = new Helper();
		
		List<String> faultyRecords = helper.processJSON();
		
		for(String id: faultyRecords)
			System.out.println(id );
	}

}
