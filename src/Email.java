import java.util.LinkedList;

public class Email extends Message{
	
	

	public Email(String header, String sender, String subject, String body, LinkedList<String>url) {
		super(header, body); //inherits values from super class
		
		//adds values unique to an Email message
		this.setSender(sender);
		this.setSubject(subject);
		this.setURL(url);
	}
	
	//private properties for Email class
	private String sender;
	private String subject;
	private LinkedList<String>url;
	
	//get and set methods
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setURL(LinkedList<String> url) {
		this.url = url;
	}
	
	public LinkedList<String> getURL() {
		return url;
	}
}
