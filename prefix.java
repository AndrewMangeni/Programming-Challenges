import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class prefix {

	public static void main(String [] args) throws Exception{
		URL prefixUrl = new URL("http://challenge.code2040.org/api/prefix");
		JSONObject dictionary = new JSONObject();
		dictionary.put("token", "d8bf86b816b5e01b4f29d8b48503a6d6");
		
		String dict = Request.sendPost(prefixUrl, dictionary);
		JSONObject input = new JSONObject(dict);
		findPrefix(input, dictionary);
		
		URL validateUrl = new URL("http://challenge.code2040.org/api/prefix/validate");
		String response = Request.sendPost(validateUrl, dictionary);
		System.out.println(response);
	}
	
	public static void findPrefix(JSONObject input, JSONObject dictionary) throws Exception{
		String prefix = input.getString("prefix");
		JSONArray array = input.getJSONArray("array");

		String [] found = new String[array.length()];
		int j=0;
		
		for(int i=0; i<array.length(); i++){
			if(!(array.get(i).toString().substring(0, (prefix.length())).equals(prefix))){
				found[j] = array.get(i).toString();
				j++;
			}				
		}
		
		String [] finalArray = new String[j];
		for(int i=0; i<j; i++){
			finalArray[i] = found[i];
		}
		dictionary.put("array", finalArray);
	}
}
