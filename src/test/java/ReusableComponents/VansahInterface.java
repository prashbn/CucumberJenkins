package ReusableComponents;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;

public class VansahInterface {
	
	
	private  String VANSAH_URI;
	private  String VANSAH_PACKAGE;
	private  String VANSAH_CASE;
	private  String VANSAH_TYPE;
	private  String VANSAH_RELEASE;
	private  String VANSAH_BUILD;
	private  String VANSAH_ENVIRONMENT;
	private  String VANSAH_RESULT;
	private  String VANSAH_COMMENT;
	private  String VANSAH_AGENT;
	private  String VANSAH_TOKEN;
	private  String PROXY_SERVER;
	private  int PROXY_PORT=0;
	private int HTTPS_RESPONSE_CODE;
	private String  HTTPS_RESULT;
	private Proxy proxy;
	
	static VansahInterface vansahinterface=null;
	
	 /**
	 * Default Constructor 
	 */
	//Default constructor if using use the UpdateResultsInVansah(String, String ,String ,String ,String ,String , String , String ,  String , String , String) to update results
	public VansahInterface()
	{
		
	}
	
	 /**

	 * Singleton overloaded constructor
	 * @param clientName String value
	 * @param packageName String value
	 * @param type String value
	 * @param release String value
	 * @param build String value
	 * @param environment String value
	 * @param agent String value
	 * @param token String value
	 */
	protected VansahInterface(String clientName, String packageName,String type,String release,String build,String environment, String agent, String token)
	{
		VANSAH_URI=clientName;
		VANSAH_PACKAGE= packageName;
		VANSAH_TYPE=type;
		VANSAH_RELEASE=release;
		VANSAH_BUILD=build;
		VANSAH_ENVIRONMENT=environment;
		VANSAH_AGENT=agent;
		VANSAH_TOKEN=token;	
	}
	
	 /**

	 * Singleton overloaded constructor
	 * @param clientName String value
	 * @param packageName String value
	 * @param type String value
	 * @param release String value
	 * @param build String value
	 * @param environment String value
	 * @param agent String value
	 * @param token String value
	 * @param proxy_address String value
	 * @param proxy_port String value
	 */
	
	protected VansahInterface(String clientName, String packageName,String type,String release,String build,String environment, String agent, String token,String proxy_address,int port_number)
	{
		VANSAH_URI=clientName;
		VANSAH_PACKAGE= packageName;
		VANSAH_TYPE=type;
		VANSAH_RELEASE=release;
		VANSAH_BUILD=build;
		VANSAH_ENVIRONMENT=environment;
		VANSAH_AGENT=agent;
		VANSAH_TOKEN=token;	
		PROXY_SERVER=proxy_address;
		PROXY_PORT=port_number;
	}
	
		/**
		 * Method to get singelton Instance of VansahInterface Object
		 * @param clientName String value
		 * @param packageName String value
		 * @param type String value
		 * @param release String value
		 * @param build String value
		 * @param environment String value
		 * @param agent String value
		 * @param token String value
		 * @return VansahInterface object
		 */
	public static VansahInterface getInstance(String clientName, String packageName,String type,String release,String build,String environment, String agent, String token)
	{
		if(vansahinterface==null)
		{
			
			vansahinterface=new VansahInterface(clientName, packageName, type, release, build, environment,  agent,  token);
			
		}
		return vansahinterface;
		
	}
	
	
	/**
	 * Method to get singelton Instance of VansahInterface Object
	 * @param clientName String value
	 * @param packageName String value
	 * @param type String value
	 * @param release String value
	 * @param build String value
	 * @param environment String value
	 * @param agent String value
	 * @param token String value
	 * @param proxy_address String value
	 * @param proxy_port String value
	 * @return VansahInterface object
	 */
	
	public static VansahInterface getInstance(String clientName, String packageName,String type,String release,String build,String environment, String agent, String token,String proxy_address, int port_number)
	{
		if(vansahinterface==null)
		{
			
			vansahinterface=new VansahInterface(clientName, packageName, type, release, build, environment,  agent,  token,proxy_address,port_number);
			
		}
		return vansahinterface;
		
	}
	
	public static VansahInterface getInstance()
	{
	
		return vansahinterface;
		
	}
	
	
	
	
	/**
	 * Method to update a test case in Vansah 
	 * @param clientName String value
	 * @param packageName String value
	 * @param type String value
	 * @param release String value
	 * @param build String value
	 * @param environment String value
	 * @param agent String value
	 * @param token String value
	 * @param testcaseID String value
	 * @param resultStatus String value
	 * @param testComment String value
	 * @return HTTPS_RESULT String
	 */
	public String UpdateResultsInVansah(String clientName, String packageName,String type,String release,String build,String environment, String agent, String token,  String testcaseID, String resultStatus, String testComment)
	{	
		VANSAH_PACKAGE= packageName;
		VANSAH_TYPE=type;
		VANSAH_RELEASE=release;
		VANSAH_BUILD=build;
		VANSAH_ENVIRONMENT=environment;
		VANSAH_AGENT=agent;
		VANSAH_TOKEN=token;
		VANSAH_URI=clientName;
		
		VANSAH_CASE= testcaseID;
		if(resultStatus.equalsIgnoreCase("pass"))
			VANSAH_RESULT ="1";
		if(resultStatus.equalsIgnoreCase("fail"))
			VANSAH_RESULT ="2";
		if(resultStatus.equalsIgnoreCase("N/A"))
			VANSAH_RESULT ="0";
		VANSAH_COMMENT=testComment.replace(" ", "%20");
			
		
		String URI = "https://"+VANSAH_URI+".vansah.net/atsi/save_to_testlog.php?&PACKAGE="+VANSAH_PACKAGE+"&CASE="+VANSAH_CASE+"&TYPE="+VANSAH_TYPE+
					"&RELEASE="+VANSAH_RELEASE+"&BUILD="+VANSAH_BUILD+"&ENVIRONMENT="+VANSAH_ENVIRONMENT+"&RESULT="+VANSAH_RESULT+"&COMMENT="+VANSAH_COMMENT+"&AGENT="+VANSAH_AGENT+"&TOKEN="+VANSAH_TOKEN;
		System.out.println("Vansa URI :" + URI);
	       HttpURLConnection urlConnection;
	        try {
	            //Connect
	            urlConnection = (HttpURLConnection) ((new URL(URI).openConnection()));
	            urlConnection.setRequestMethod("GET");
	            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
	            HTTPS_RESPONSE_CODE = urlConnection.getResponseCode();
	         
	            BufferedReader in = new BufferedReader(
	                    new InputStreamReader(urlConnection.getInputStream()));
	            String inputLine;
	            StringBuffer response = new StringBuffer();

	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();
	            HTTPS_RESULT=response.toString(); 
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		return HTTPS_RESULT;
		
	    }
	
	/**
	 * Method to update a test case in Vansah
	 * @param testcaseID String value
	 * @param resultStatus String value
	 * @param testComment String value
	 * @return HTTPS_RESULT String
	 */
	
	public String UpdateResultsInVansah(String testcaseID, String resultStatus, String testComment)
	{

		if(!PROXY_SERVER.isEmpty() && PROXY_PORT!=0 )
		proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_SERVER, PROXY_PORT));
		
		/*System.setProperty("http.proxyHost", "host");
		System.setProperty("http.proxyPort", "port_number");
		//If proxy requires authentication,

		System.setProperty("http.proxyUser", "user");
		System.setProperty("http.proxyPassword", "password");*/
		
		
		/*   Authenticator authenticator = new Authenticator() {

		        public PasswordAuthentication getPasswordAuthentication() {
		            return (new PasswordAuthentication("user",
		                    "password".toCharArray()));
		        }
		    };
		    Authenticator.setDefault(authenticator);*/
		
		VANSAH_CASE= testcaseID;
		if(resultStatus.equalsIgnoreCase("pass"))
			VANSAH_RESULT ="1";
		if(resultStatus.equalsIgnoreCase("fail"))
			VANSAH_RESULT ="2";
		if(resultStatus.equalsIgnoreCase("N/A"))
			VANSAH_RESULT ="0";
		VANSAH_COMMENT=testComment.replace(" ", "%20");
			
		
			String URI = "https://"+VANSAH_URI+".vansah.net/atsi/save_to_testlog.php?&PACKAGE="+VANSAH_PACKAGE+"&CASE="+VANSAH_CASE+"&TYPE="+VANSAH_TYPE+
					"&RELEASE="+VANSAH_RELEASE+"&BUILD="+VANSAH_BUILD+"&ENVIRONMENT="+VANSAH_ENVIRONMENT+"&RESULT="+VANSAH_RESULT+"&COMMENT="+VANSAH_COMMENT+"&AGENT="+VANSAH_AGENT+"&TOKEN="+VANSAH_TOKEN;
		
	        HttpURLConnection urlConnection;
	        try {
	            //https get method with required parameters
	        	if(!PROXY_SERVER.isEmpty() && PROXY_PORT!=0 )
	        		urlConnection = (HttpURLConnection) ((new URL(URI).openConnection(proxy)));
	        	else
	        		  urlConnection = (HttpURLConnection) ((new URL(URI).openConnection()));
	            urlConnection.setRequestMethod("GET");
	           // urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
	            HTTPS_RESPONSE_CODE = urlConnection.getResponseCode();
	         
	            BufferedReader in = new BufferedReader(
	                    new InputStreamReader(urlConnection.getInputStream()));
	            String inputLine;
	            StringBuffer response = new StringBuffer();

	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	            in.close();
	            HTTPS_RESULT=response.toString(); 
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		return HTTPS_RESULT;
		
	    }

	/**
	 * Method to get the last https response code from Vansah
	 * @return HTTPS_RESPONSE_CODE int
	 */
	
	public int getHttpsStatus()
	{
		return HTTPS_RESPONSE_CODE;
		
	}
	
	/**
	 * Method to get the last update response from Vansah
	 * @return HTTPS_RESULT String
	 */
	public String getUpdateStatus()
	{
		return HTTPS_RESULT;
	}
}
