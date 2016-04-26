package kaplanHealth;
import java.io.*;
import java.util.*;
import java.lang.StringBuffer;
import java.net.*;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

public class testRestFull {
	
	      public static void main (String args[]){

	          try{            

	          // set this property to the location of the cert file
	           System.setProperty("javax.net.ssl.trustStore","C:/Documents and Settings/bhattdr/Desktop/-.energystar.gov.der");   


	          String username = "yy777PPP";
	          String password = "yy777PPP";
	          String userpass = "";

	          URL url = new URL("https://portfoliomanager.energystar.gov/wstest/account");
//	          URLConnection uc = url.openConnection();
	          HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();

	          userpass = username + ":" + password;
	          String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());

	          System.out.println("sending request...");

	          uc.setRequestMethod("GET");
	          uc.setAllowUserInteraction(false);
	          uc.setDoOutput(true);
	          uc.setRequestProperty( "Content-type", "text/xml" );
	          uc.setRequestProperty( "Accept", "text/xml" );

	          uc.setRequestProperty ("Authorization", basicAuth);

	          System.out.println(uc.getRequestProperties());


//	          uc.setRequestProperty( "authorization", "Basic " + encode("administrator:collation"));

//	          Map headerFields = uc.getHeaderFields();
//	          System.out.println("header fields are: " + headerFields);


	          int rspCode = uc.getResponseCode();

	          if (rspCode == 200) {
	              InputStream is = uc.getInputStream();
	              InputStreamReader isr = new InputStreamReader(is);
	              BufferedReader br = new BufferedReader(isr);

	              String nextLine = br.readLine();
	              while (nextLine != null) {
	                  System.out.println(nextLine);
	                  nextLine = br.readLine();
	              }

	          }
	          }

	          catch(IOException e) { 
	              e.printStackTrace();
	          }

	      }
}
