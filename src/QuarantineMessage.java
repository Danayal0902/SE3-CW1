import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class QuarantineMessage extends Message{

	public QuarantineMessage(String header, String body, String quarDialog) {
		super(header, body); //inherits values from super class (Message)
		this.setQuarDialog(quarDialog); //value for the message that will show when a message is quarantined
	}
	
@SuppressWarnings("unchecked")
	public void JSONMessage(String fileName) {
		
		//creates a JSON object
		JSONObject obj = new JSONObject();
		
		//puts the following values, in JSON format, into a file
		obj.put("Header", this.getHeader());
		obj.put("Body", this.getBody());
		obj.put("QuarantineDialog", this.getQuarDialog());
		
		
		
		try {
			FileWriter fw = new FileWriter("/Users/danayaliftikhar/Desktop/SE3CW1/QuarantineMessages" + fileName + ".txt");
			fw.write(obj.toJSONString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//private properties for the Quarantine class
	private String quarDialog;
	
	//get and set methods
	public void setQuarDialog(String quarDialog) {
		this.quarDialog = quarDialog;
	}
	
	public String getQuarDialog() {
		return quarDialog;
	}

}
