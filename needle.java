import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class needle{


	public static void main(String [] args) throws Exception{
	
		URL haystackUrl = new URL("http://challenge.code2040.org/api/haystack");	
        JSONObject dictionary = new JSONObject();
        dictionary.put("token", "d8bf86b816b5e01b4f29d8b48503a6d6");
				
		String dict = Request.sendPost(haystackUrl, dictionary);

		JSONObject input = new JSONObject(dict);
		findNeedle(input, dictionary);
		
		URL validateUrl = new URL("http://challenge.code2040.org/api/haystack/validate");
		String response = Request.sendPost(validateUrl, dictionary);
		System.out.println(response);	
	}

	public static void findNeedle(JSONObject input, JSONObject dictionary) throws Exception{
		String needle = input.getString("needle");
		JSONArray haystack = input.getJSONArray("haystack");

		for(int i = 0; i < haystack.length(); i++){
			if(needle.equals(haystack.get(i))){
				dictionary.put("needle", i);
			}
		}
	}
	
}
	