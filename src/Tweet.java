import java.util.LinkedList;

public class Tweet extends Message{

	public Tweet(String header, String sender, String body, LinkedList<String> hashtag, LinkedList<String> twitterID) {
		super(header, body); //inherits values from super class
		
		//adds values unique to a Tweet
		this.setSender(sender);
		this.setHashtag(hashtag);
		this.setTwitterID(twitterID);
	}
	
	//private properties for the Tweet class
	private String sender;
	private LinkedList<String>hashtag;
	private LinkedList<String>twitterID;
	
	//get and set methods
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setHashtag(LinkedList<String> hashtag) {
		this.hashtag = hashtag;
	}
	
	public LinkedList<String> getHashtag() {
		return hashtag;
	}
	
	public void setTwitterID(LinkedList<String> twitterID) {
		this.twitterID = twitterID;
	}
	
	public LinkedList<String> getTwitterID() {
		return twitterID;
	}

}
