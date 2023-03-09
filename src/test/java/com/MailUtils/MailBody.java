package com.MailUtils;

import java.util.ArrayList;


public class MailBody {
	

	
	
	
	private static ArrayList<String> scenarioDetails = new ArrayList<String>();	
	
	public static String HtmlBodyTable() {
		
		String[] value;
		
		String cssStyle="<style>\n"
				+ "        .styled-table {\n"
				+ "    border-collapse: collapse;\n"
				+ "    margin: 25px 0;\n"
				+ "    font-size: 0.9em;\n"
				+ "    font-family: sans-serif;\n"
				+ "    min-width: 400px;\n"
				+ "    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);\n"
				+ "}\n"
				+ "\n"
				+ ".styled-table thead tr {\n"
				+ "    background-color: #009879;\n"
				+ "    color: #ffffff;\n"
				+ "    text-align: left;\n"
				+ "}\n"
				+ ".styled-table th,\n"
				+ ".styled-table td {\n"
				+ "    padding: 12px 15px;\n"
				+ "}\n"
				+ "table, th, td {\n"
				+ "  border: 1px solid #009879;\n"
				+ "}\n"
				+ "\n"
				+ ".styled-table tbody tr {\n"
				+ "    border-bottom: 1px solid #dddddd;\n"
				+ "}\n"
				+ "\n"
				+ ".styled-table tbody tr:nth-of-type(even) {\n"
				+ "    background-color: #f3f3f3;\n"
				+ "}\n"
				+ "\n"
				+ ".styled-table tbody tr:last-of-type {\n"
				+ "    border-bottom: 2px solid #009879;\n"
				+ "}\n"
				+ ".styled-table tbody tr.active-row {\n"
				+ "    font-weight: bold;\n"
				+ "    color: #009879;\n"
				+ "}\n"
				+ "\n"
				+ "    </style>\n";
		
		
		scenarioDetails.addAll(FileReadWrite.readScenarioNamesFromFile(FileReadWrite.scenarioDetails));
		
		String text=
		         "<html><body>"+cssStyle
		         + "<table class='styled-table'><thead>"
		                + "<tr align='center'>"
		                + "<td><b>Test Scenario <b></td>"
		                + "<td><b>Tag<b></td>"
		                +"<td><b>Test Status<b></td>"
		                + "</tr>"
		                + "</thead><tbody>";
		
		

		    for (int i=0;i<scenarioDetails.size();i++) {
		    		
				value=scenarioDetails.get(i).split(":");
	
		                   // System.out.println(value[0] + " :" + value[1]+" :" + value[2]);
		                    text=text+"<tr class='active-row'>"+"<td>" + value[0] + "</td>"
		                                + "<td>" + value[1] + "</td>";
		                    if(value[2].equalsIgnoreCase("passed")) {
		                    	
		                    	text=text+"<td style='color: green; font-weight: bold;'>" + value[2] + "</td>"+"</tr>";
		                                
		                    }else if(value[2].equalsIgnoreCase("failed")) {
		                    	
		                    	text=text+"<td style='color: red; font-weight: bold;'>" + value[2] + "</td>"+"</tr>";
		                    }else {
		                    	
		                    	text=text+"<td style='color: yellow; font-weight: bold;'>" + value[2] + "</td>"+"</tr>";
		                    }
		                    
		    			}
		   
		    
		    text=text +"</tbody></table></body></html>";
		
		    // Added this new line to delete Files after creating html Body
		    FileReadWrite.deleteFile(FileReadWrite.scenarioDetails);
		
		return text;
		
		
	}


}
