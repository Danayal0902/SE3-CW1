import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MessageProcessor {
	
	//singleton class with a unique instance variable
	private static MessageProcessor uniqueInstance;
	
	
	public static synchronized MessageProcessor getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new MessageProcessor();
		}
		
		return uniqueInstance;
	}
	
	//array lists to hold all processed messages
	ArrayList<Message> SMS = new ArrayList<Message>();
	ArrayList<Message> Email = new ArrayList<Message>();
	ArrayList<Message> Tweet = new ArrayList<Message>();
	
	
	public void ProcessMessage (Message message) { //method that will take the input message and process it
		
		if(message.getHeader().length() == 10) { //detects the message type from the header to filter it
			
			//if statements that hold the message type constraint and add them to the correct array list
			if(message.getHeader().substring(0,1).toUpperCase().contains("S") == true) {
				
				if(message.getBody().length() <141) {
				message.JSONMessage("SMS" + message.getHeader()); //converts message to JSON format to output to file
				SMS.add(message);
				}
			}
			
			if(message.getHeader().substring(0,1).toUpperCase().contains("E") == true) {
				
				if(message.getBody().length() <1029) {
					message.JSONMessage("Email" + message.getHeader());
					Email.add(message);
				}
			}
			
			if(message.getHeader().substring(0,1).toUpperCase().contains("T") == true) {
				
				if(message.getBody().length() <141) {
					message.JSONMessage("Tweet" + message.getHeader());
					Tweet.add(message);
				}
				
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Tweets may be up to 140 characters, please try again.");
				}
			}
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Your message header must contain an ID comprising of S, E or T followed by 9 numeric characters.");
		}
	}
}
