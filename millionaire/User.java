package millionaire;

public class User {
	
	/* User sinifi, milyoner yarismasinda yarismaci objelerinin bagli olacagi siniftir. Yarismaci objesi
	 * tipik olarak, bir isme, soru basina kazandigi paraya, kesin olarak kazandigi paraya ve joker haklarina
	 * sahip olur. User sinifi Joker sinifi ile has-a inhertiance iliskisine sahiptir. Joker haklari bu sinifin
	 * alt siniflarindan turetilen objelerdir.
	 */
	
	// data fields
	
	private String userName; // yarimacimizin ismi
	private int tempMoney; // yarismacimizin o soruya kadar kazandigi para
	private int winMoney; // yarismacimizin kesin kazandigi para
	private int answeredQuestions; // yarismacimizin cevapladigi toplam soru sayisi
	private PhoneJoker phoneJoker; // yarismacimizin telefon joker hakki
	private FiftyFifty fiftyFiftyJoker; // yarismacimizin telefon joker hakki
	private Spectator spectatorJoker; // yarismacimizin seyirciye sorma joker hakki
	private DoubleAnswer doubleAnswerJoker; // yarismacimizin cift cevap joker hakki
	
		
	
	// constructor
	
	public User(String userName) { // User objesi sadece bir isim verilerek olusturulur. Diger veriler yarisma sirasinda guncellenir.
		
		this.userName = userName;
		
	} // end constractor
	
		
	// getter ve setter methodlar
	
	public String getUserName() { // yarismacinin ismini erkana bastiran method
		
		return userName;
		
	} // end method getUserName

	public int getTempMoney() { // yarismacinin o ana kadar kazandigi parayi ekrana bastiran method
		
		return tempMoney;
		
	} // end method getTempMoney
	
	public int getWinMoney() { // yarismacinin nihai olarak kazandigi parayi ekrana bastiran method
		
		return winMoney;
		
	} // end method getWinMoney
	
	public int getAnsweredQuestions() { // yarismacinin cevapladigi toplam sorularý tutan deger
		
		return answeredQuestions;
		
	} // end method getAnsweredQuestions
	
		
	public void getPhoneJokerString(){ // yarismaci telefon jokeri kullandiginda aranacak kisleri ekrana bastirir.
		
		System.out.println(phoneJoker);
		
	
	} // end method getPhoneJokerString
	
	public PhoneJoker getPhoneJoker(){ // Yarismacinin telefon jokerini getiren method
		
		return phoneJoker;
		
	
	} // end method getPhoneJoker
	
	public FiftyFifty getFiftyFiftyJoker(){ // yarismacinin 50.50 jokerini getiren method
		
		return fiftyFiftyJoker;
		
	
	} // end method getFiftyFiftyJoker
	
	public Spectator getSpectatorJoker() { // yarismacinin Uzmana Sorma jokerini getiren method
		
		return spectatorJoker;
		
	} // end method getExpertJoker
	
	public DoubleAnswer getDoubleAnswerJoker() { // yarismacinin Cift Cevap Jokerini getiren method
		
		return doubleAnswerJoker;
		
	} // end method getExpertJoker
	
	public void getJokers() { // yarismacinin joker haklarini ekrana yazan method
		
		System.out.println("Jokerlerin: \n");
		
		if (phoneJoker.getJokerRight() == 1) {
			
			System.out.println("1. Telefon Jokeri");
			
		} // end if 1
		
		if (fiftyFiftyJoker.getJokerRight() == 1) {
			
			System.out.println("2. 50:50 Jokeri");
			
		} // end if 2
		
		if (spectatorJoker.getJokerRight() == 1) {
			
			System.out.println("3. Seyirciye Sor Jokeri");
			
		} // end if 1
		
		if (doubleAnswerJoker.getJokerRight() == 1) {
			
			System.out.println("4. Cift Cevap Jokeri");
			
		} // end if 1
		
		
	} // end method getJokers
	
	public void setUserName(String userName) { // yarismacinin ismini olusturan method
		
		this.userName = userName;
		
	} // end method setUserName

	public void setTempMoney(int tempMoney) { // yarismacinin o ana kadar kazandigi parayi olusturan method
		
		this.tempMoney = tempMoney;
		
	} // end method setTempMoney
	
	public void setWinMoney(int winMoney) { // yarismacinin nihai kazandigi parayi olusturan method
		
		this.winMoney = winMoney;
		
	} // end method setWinMoney
	
	public void setAnsweredQuestions(int answeredQuestions) { // yarismacinin toplam cevapladigi soru sayisini olusturan method
		
		this.answeredQuestions = answeredQuestions;
		
	} // end method setAnsweredQuestions
	
	public void setPhoneJoker(PhoneJoker phoneJoker){ // yarismacinin telefon jokerini tanimlayan method
		
		this.phoneJoker = phoneJoker;
		
	} // end method setPhoneJoker
	
	public void setFiftyFiftyJoker(FiftyFifty fiftyFiftyJoker){ // yarismacinin 50:50 jokerini tanimlayan method
		
		this.fiftyFiftyJoker = fiftyFiftyJoker;
		
	} // end method setFiftyFiftyJoker
	
	public void setExpertJoker(Spectator spectatorJoker){ // yarismacinin Uzmana Sor jokerini tanimlayan method
		
		this.spectatorJoker = spectatorJoker;
		
	} // end method setExpertJoker
	
	public void setDoubleAnswerJoker(DoubleAnswer doubleAnswerJoker) { // // yarismacinin Cift Cevap jokerini tanimlayan method
		
		this.doubleAnswerJoker = doubleAnswerJoker;
		
	} // end method setDoubleAnswerJoker
	
	@Override
	public String toString() {
			
		return "Yarismaci ismi: " + userName + "\n" + "Yarismacinin kazandigi para: " + winMoney + " TL" + "\n" + "Yarismacinin cevapladigi toplam soru: " + answeredQuestions;
		
		
	} // end method
	

	public static void main(String[] args) { // main method
		

	} // end method main

} // end class User
