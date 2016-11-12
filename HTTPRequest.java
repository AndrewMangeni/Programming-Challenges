import java.net.URL;
import org.json.JSONObject;

public class HTTPRequest{


	public static void main(String [] args) throws Exception{
	
		URL serverUrl = new URL("http://challenge.code2040.org/api/register");	

        JSONObject dictionary = new JSONObject();
        dictionary.put("token", "d8bf86b816b5e01b4f29d8b48503a6d6");
        dictionary.put("github", "https://github.com/AndrewMangeni/Programming-Challenges");
				
		String Response = Request.sendPost(serverUrl, dictionary);
		System.out.println(Response);
	    }
}




