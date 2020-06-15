public class Persondetails {
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private int zipCode;
	private long phoneNum;
	public Persondetails(String firstName,String lastName,String street,String city,String state,int zipCode,long phoneNum) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.street=street;
		this.city=city;
		this.state=state;
		this.zipCode=zipCode;
		this.phoneNum=phoneNum;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}

}
