
public class SMS extends Message{

	public SMS(String no, String header, String body) {
		super(header, body); //inherits these values from the Message class
		this.setPhoneNo(no); //adds a value which is unique to an SMS
	}
	
	//SMS message private variable
	private String phoneNo;
	
	//get and set method for phone number value
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}

}
