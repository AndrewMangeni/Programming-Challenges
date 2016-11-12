import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.StringBuilder;
import org.json.JSONObject;

public class Request {

	public static String sendPost(URL serverUrl, JSONObject dictionary) throws Exception {


		HttpURLConnection urlCon = (HttpURLConnection) serverUrl.openConnection();
		
		urlCon.setDoOutput(true);
		urlCon.setRequestProperty("Content-Type", "application/json");
		urlCon.setRequestMethod("POST");

		OutputStreamWriter writer = new OutputStreamWriter(urlCon.getOutputStream());
		writer.write(dictionary.toString());
			
        writer.flush();
		writer.close();
	
		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
		StringBuilder sb = new StringBuilder();
 
		
		while ((line = reader.readLine()) != null){
			sb.append(line);
		}
		reader.close();
		return sb.toString();
	}
}
