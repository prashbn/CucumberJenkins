import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateVansahTestStatus {
	
	private String VANSHA_PACKAGE;
	private String VANSHA_CASE;
	private String VANSHA_TYPE;
	private String VANSHA_RELEASE;
	private String VANSHA_BUILD;
	private String VANSHA_ENVIRONMENT;
	private String VANSHA_RESULT;
	private String VANSHA_COMMENT;
	private String VANSHA_AGENT;
	private String VANSHA_TOKEN;
	
	private String result;
	
	
	private IntializeVansah VANSAH = IntializeVansah.getInstance( );
;
	
	public Boolean UpdateResults(String testcaseID, String testStatus, String testComment)
	{
	    
		VANSHA_PACKAGE= VANSAH.getPackage();
		VANSHA_TYPE=VANSAH.getType();
		VANSHA_RELEASE=VANSAH.getRelease();
		VANSHA_BUILD=VANSAH.getBuild();
		VANSHA_ENVIRONMENT=VANSAH.getEnvironment();
		VANSHA_AGENT=VANSAH.getAgent();
		VANSHA_TOKEN=VANSAH.getToken();
		
		VANSHA_CASE= testcaseID;
		if(testStatus.equalsIgnoreCase("pass"))
			VANSHA_RESULT ="1";
		else if(testStatus.equalsIgnoreCase("fail"))
			VANSHA_RESULT ="0";
		VANSHA_COMMENT=testComment.replace(" ", "%20");
			
		
			String URI = "https://testpoint.vansah.net/atsi/save_to_testlog.php?PACKAGE="+VANSHA_PACKAGE+"&CASE="+VANSHA_CASE+"&TYPE="+VANSHA_TYPE+
					"&RELEASE="+VANSHA_RELEASE+"&BUILD="+VANSHA_BUILD+"&ENVIRONMENT="+VANSHA_ENVIRONMENT+"&RESULT="+VANSHA_RESULT+"&COMMENT="+VANSHA_COMMENT+"&AGENT="+VANSHA_AGENT+"&TOKEN="+VANSHA_TOKEN;
			System.out.println(" URI is :"+  URI);
	        HttpURLConnection urlConnection;
	        try {
	            //Connect
	            urlConnection = (HttpURLConnection) ((new URL(URI).openConnection()));
	            urlConnection.setRequestMethod("GET");
	            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
	            urlConnection.setRequestProperty("api_key", "27a309cb-4559-40d6-8052-6b7d1b672972");
	            int responseCode = urlConnection.getResponseCode();
	        
	            BufferedReader in = new BufferedReader(
	                    new InputStreamReader(urlConnection.getInputStream()));
	            String inputLine;
	            StringBuffer response = new StringBuffer();

	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();
	            result = response.toString();
	            System.out.println(" Value of Result is :" +result);

	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }


		return true;
		
	    }

}
