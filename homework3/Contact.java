package homework3;


public class Contact implements Comparable<Contact>{
	
	/* Contact sinifi kisilerin telefon numarasi, ismi, soyismi, SSN numarasinin String olarak tutan bir siniftir.
	 * Comparable sinifindan implement eder ve bazi methodlarini override eder. Kendi methodlari olarak ise data field
	 * alanlarina erisebilmek icin olusturulmus getter ve setter methodlari vardir.
	 */
	
	// data fields
	
	private String phoneNumber;	
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private int intPhoneNumber;
	
	//constructor
	
	public Contact(String phoneNumber , String firstName, String lastName, String socialSecurityNumber ) { // constructor
		
		this.socialSecurityNumber = socialSecurityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		
	} // end constructor
	
	
	// getter ve setter methodlar
	
	public String getSocialSecurityNumber() { // socialSecurityNumber'ý getirmek icin method
		
		return socialSecurityNumber;
		
	} // end method getSocialSecurityNumber

	public String getFirstName() { // firstName'i getirebilmek icin method
		
		return firstName;
		
	} // end method getFirstName
	
	public String getLastName() { // lastName'i getirebilmek icin method
		
		return lastName;
		
	} // end method getFirstName
	
	public String getPhoneNumber() { // PhoneNumber'i getirebilmek icin method
		
		return phoneNumber;
		
	} // end method getPhoneNumber
	
	public int getIntPhoneNumber() { // intPhoneNumber'i getirebilmek icin method
		
		return intPhoneNumber;
		
	} // end method getIntPhoneNumber
	
	public void setSocialSecurityNumber(String socialSecurityNumber) { // socialSecurityNumber'i olusturabilmek icin method
		
		this.socialSecurityNumber = socialSecurityNumber;
		
	} // end method setSocialSecurityNumber
	
	public void setFirstName(String firstName) { //firstName'i olusturabilmek icin method
		
		this.firstName = firstName;
		
	} // end method setFirstName
	
	public void setLastName(String lastName) { // lastName'i olusturabilmek icin method
		
		this.lastName = lastName;
		
	} // end method setLastName
	
	public void setPhoneNumber(String phoneNumber) { // phoneNumber'i olusturabilmek icin method
		
		this.phoneNumber = phoneNumber;
		
	} // end method setPhoneNumber
	
	public void setIntPhoneNumber(int intPhoneNumber) { // inPhoneNumber'i olusturabilmek icin method
		
		this.intPhoneNumber = intPhoneNumber;
		
	} // end method setPhoneNumber
	
	@Override
	public String toString() { // verileri yazdirabilmek icin toString methodunu override ediyoruz
		
		return phoneNumber + " " + firstName + " " + lastName + " " + socialSecurityNumber;
		
	} // end method toString
	
	@Override
	public int compareTo(Contact cont) { // telefon numarasina göre sirayalbilmek icin compareTo methodunu override ediyoruz
		
		
		if(this.intPhoneNumber < cont.intPhoneNumber)
			return -1;
		else if(this.intPhoneNumber > cont.intPhoneNumber)
			return 1;
		
		return 0;
	}
	
	@Override
	public boolean equals(Object o) { // esitlik kontrolü methodu
		
		Contact ct = (Contact)o;
		return (ct.intPhoneNumber == this.intPhoneNumber);
		
	}
	
	@Override
	public int hashCode() { // hashCode'u intPhoneNumber'a esitliyoruz
		
		return this.intPhoneNumber;
	}
	
	public static void main(String[] args) { // main method
		
	} // end method main

} // end class Contact
