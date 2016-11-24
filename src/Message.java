import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class Message {
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	//creates message instance
	public Message(String header, String body) {
		this.setHeader(header);
		this.setBody(body);
	}
	

	//outputs a message in JSON format into a file
	@SuppressWarnings("unchecked")
	public void JSONMessage(String fileName) {
		
		JSONObject obj = new JSONObject();
		obj.put("Header", this.getHeader());
		obj.put("Body", this.getBody());
		
		
		
		try {
			FileWriter fw = new FileWriter("/SE3CW1/InitialMessages/" + fileName + ".txt");
			fw.write(obj.toJSONString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//message variables
	private String header;
	private String body;
	
	//get and set methods for messages
	public void setHeader(String header) {
		this.header = header;
	}
	
	public String getHeader() {
		return header;
	}
	
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getBody() {
		return body;
	}
}
