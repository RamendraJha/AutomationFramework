package com.MailUtils;


public class Main {
	
	public static void main(String args[]) {
		
		final String username = "mail ID";
        final String password = "Password";
        String fromAddress="fromAdress";
        String toAddress="toAddress";
        String bodyTable=MailBody.HtmlBodyTable();
        System.out.println(bodyTable);
        FileReadWrite.saveHtmlFile(bodyTable);
        
       /* ReportingPojo re= new ReportingPojo();
        re.setFeatureName("ABC def ghj");
        re.setStatus("Status");
        re.setTag("[Tag, Tag2]");
        System.out.println(re.toString()); 
        String val=re.toString();
        String[] x=val.split(":");
        System.out.println(x[0]); 
        System.out.println(x[1]);
        System.out.println(x[2]);
        */
        //MailSendUtil.sendMail(username, password, fromAddress, toAddress, bodyTable);
		    
	}

}
