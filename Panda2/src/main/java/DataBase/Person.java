package DataBase;

public class Person {
	private String LastName;
	private String FristName;
	private String Phone;
	private String email;
	private String Password;
	private String Username;
	private String License;
	private String picPath;
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(String lastName, String fristName, String email, String phone, String password, String username,
			String license, String picPath) {
		super();
		LastName = lastName;
		FristName = fristName;
		Phone = phone;
		this.email = email;
		Password = password;
		Username = username;
		License = license;
		this.picPath = picPath;
	}

	public String getLicense() {
		return License;
	}

	public void setLicense(String license) {
		License = license;
	}

	public void setPicPath(String PicPath) {
		picPath = PicPath;
	}
	
	public String getPicPath() {
		return picPath;
	}
	
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFristName() {
		return FristName;
	}
	public void setFristName(String fristName) {
		FristName = fristName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	
		
}
