package com.MailUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReadWrite {
	
	public static String scenarioDetails="scenarioDetails.txt";
	
	public static void saveHtmlFile(String htmlBody) {
		String path = "mailBody.html";
		try {
	        FileWriter writer = new FileWriter(path, false);
	        
	        writer.write(htmlBody);
	        writer.close();
	        }
	     catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	public static void saveScenarioNameToFile(String scenarioName, String path) {
	    try {
	        FileWriter writer = new FileWriter(path, true);
	        if(scenarioName.equals(null)||scenarioName=="") {
	        	writer.write("None" + "\n");
		        writer.close();
	        }else {
	        writer.write(scenarioName + "\n");
	        writer.close();
	        }
	        }
	     catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	}
	public static List<String> readScenarioNamesFromFile(String path) {
		
		List<String> fileValue =new ArrayList<String>();
	    try {
	        FileReader reader = new FileReader(path);
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	        	fileValue.add(line);
	        }
	        bufferedReader.close();
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return fileValue;
	}
	
	public static void deleteFile(String filePath) {
		Path path = Paths.get(filePath);
        try {
            Files.delete(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}


}
