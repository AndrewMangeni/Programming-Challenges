import java.net.URL;
import org.json.JSONObject;
import java.lang.StringBuilder;

public class reverse{


	public static void main(String [] args) throws Exception{
	
		URL reverseUrl = new URL("http://challenge.code2040.org/api/reverse");	

        JSONObject dictionary = new JSONObject();
        dictionary.put("token", "d8bf86b816b5e01b4f29d8b48503a6d6");
				
		String input = Request.sendPost(reverseUrl, dictionary);

		reverseString(input, dictionary);
		
		URL validateUrl = new URL("http://challenge.code2040.org/api/reverse/validate");
		String response = Request.sendPost(validateUrl, dictionary);
		System.out.println(response);
	    }
	
	public static void reverseString(String input, JSONObject dictionary) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		sb.reverse();
		dictionary.put("string", sb.toString());
		}
}