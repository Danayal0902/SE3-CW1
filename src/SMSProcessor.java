import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SMSProcessor {
	
	private static SMSProcessor uniqueInstance;
	
	public static synchronized SMSProcessor getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new SMSProcessor();
		}
		return uniqueInstance;
	}
	
	//array lists that hold initial messages from users and sorted messages
	ArrayList<Message> initialMessages = new ArrayList<Message>();
	ArrayList<SMS> processedSMS = new ArrayList<SMS>();
	
	public void ReadFromJSON() { //method to find and read from the created JSON file
		
		JSONParser parser = new JSONParser();
		
		File f = new File("/Users/danayaliftikhar/Desktop/SE3CW1/InitialSMS"); //creates a new file at specified path
		
		File[] listFiles = f.listFiles();
		
		for(File file : listFiles) { //searches from list of files in folder until the .txt file is found
			if(file.toString().contains(".txt")) {
				String filePath = file.getAbsolutePath();
				
				try {
					Object obj = parser.parse(new FileReader(file.toString()));
					
					JSONObject jsonObject = (JSONObject) obj;
					
					String header = (String) jsonObject.get("Header");
					String body = (String) jsonObject.get("body");
					
					Message message = new Message(header, body);
                    
					initialMessages.add(message);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void ProcessSMS() { //method to process a text message from a list
		
		ReadFromJSON(); //call method used to read from a JSON file
		
		ArrayList<Message> inputSMS = initialMessages;
		
		for(Message m : inputSMS) {
			
			Pattern pattern = Pattern.compile("[0-9]{6-12}$"); //regular expression pattern to match phone numbers found in the message
			
			Matcher matcher = pattern.matcher(m.getBody());
			
			
			//if statement to check the length of the message
			if(m.getBody().length() >140) {
				JOptionPane.showMessageDialog(null, "Your message must not be longer than 140 characters.");
				QuarantineMessage q = new QuarantineMessage(m.getHeader(), m.getBody(), "SMS quarantined, length exceeded.");
				q.JSONMessage(m.getHeader());
			}
			
			if(matcher.find() == false) {
				JOptionPane.showMessageDialog(null, "Please enter a valid phone number.");
			}
			
			else
			{
				phoneNo = m.group(0).toString();
				
				m.setBody(m.getBody().replace(phoneNo, ""));
				
				String file = "/Users/danayaliftikhar/Desktop/textwords.csv";
				String line = "";
				String splitLine = ",";
				
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					if((line = br.readLine()) !=null)
						{
							String[] text = line.split(splitLine);
							
							if(m.getBody().contains(text[0])) {
								int index = m.getBody().indexOf(text[0]) + (text[0].length()) + 1;
								
								StringBuffer buffer = new StringBuffer(m.getBody());
								buffer.insert(index, "<" + text[1] + ">");
								m.setBody(buffer.toString());
							}
						}
					JOptionPane.showMessageDialog(null, m.getBody());
					
					SMS sms = new SMS(m.getHeader(), m.getBody(), phoneNo);
					}
					catch(IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}
}
