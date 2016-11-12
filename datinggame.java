import java.net.URL;
import org.json.JSONObject;
import java.time.ZonedDateTime;

public class datinggame {

	public static void main(String [] args) throws Exception{
		URL prefixUrl = new URL("http://challenge.code2040.org/api/dating");
		JSONObject dictionary = new JSONObject();
		dictionary.put("token", "d8bf86b816b5e01b4f29d8b48503a6d6");
		
		String dict = Request.sendPost(prefixUrl, dictionary);
		JSONObject input = new JSONObject(dict);
		addDate(input, dictionary);
		
		URL validateUrl = new URL("http://challenge.code2040.org/api/dating/validate");
		String response = Request.sendPost(validateUrl, dictionary);
		System.out.println(response);
	}
	
	public static void addDate(JSONObject input, JSONObject dictionary) throws Exception{
		String datestamp = input.getString("datestamp");
		int interval = (int) input.get("interval");
		int seconds = Integer.valueOf(interval);

		ZonedDateTime date = ZonedDateTime.parse(datestamp);
		date = date.plusSeconds(seconds);
		
		dictionary.put("datestamp", date.toString());
	}
}
