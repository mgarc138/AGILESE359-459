package edu.depaul.se359.model;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;


public final  class LogFile {
	
	private LogFile(){
			
	}
	
	
	public static void writeLogFile(String report, String fileName) throws IOException{
		
		FileWriter fileWrite;
		BufferedWriter buffWriter;
		
		// the file will be store in the report folder here
		File ReportFile = new File("Reports", fileName);
		
		if(ReportFile.createNewFile() == true){
			
			System.out.print("The report file has been created as: " + fileName);
		}
		
		
		
		
		
		
		
		
	}

}
