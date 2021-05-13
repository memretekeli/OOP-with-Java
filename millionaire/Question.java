package millionaire;

public class Question {
	
	/* Question sinifi milyoner yarismasinda kullaniciya sorulacak olan sorularin kacinci soru oldugunu, sorunun kendisini,
	 * soru siklarini, dogru cevabi ve yarismacinin soru icin kazanacagi parayi tutan soru objelerinden olusan bir siniftir.
	 * Milyoner oyununda okutacagimiz dosya bu siniftan soru nesneleri olusturacak ve yarismada kullanacak.  
	 */
	
	// data fileds
	
	private String queryType; // sorunun kacinci soru grubunda oldugunu belirten deger
	private String query; // yarismaciya sorulacak soru
	private String answerA; // sorunun a sikki
	private String answerB; // sorunun b sikki
	private String answerC; // sorunun c sikki
	private String answerD; // sorunun d sikki
	private String rightAnswer; // sorunun dogru cevabi
	private int money; // sorunun yarismaciya kazandirdigi para
	
	// constructor
	
	public Question(String queryType, String query, String answerA, String answerB, String answerC, String answerD,String rightAnswer) {
		
		this.queryType = queryType;
		this.query = query;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.rightAnswer = rightAnswer;
		
	} // end constructor
	
	
	
	// getter ve setter methodlar
	
	public String getQueryType() { // sorunun kacinci soru olduguna ulasma methodu
		
		return queryType;
		
	} // end method getQueryType
	
	
	public String getQuery() { // soruya ulasma methodu
		
		return query;
		
	} // end method getQuery

	public String getAnswerA() { // a sikkina ulasma methodu
		
		return answerA;
		
	} // end method getAnswerA
	
	public String getAnswerB() { // b sikkina ulasma methodu
		
		return answerB;
		
	} // end method getAnswerC
	
	public String getAnswerC() { // c sikkina ulasma methodu
		
		return answerC;
		
	} // end method getAnswerC
	
	public String getAnswerD() { // d sikkina ulasma methodu
		
		return answerD;
		
	} // end method getAnswerD
	
	public String getRightAnswer() { // dogru cevaba ulasma methodu
		
		return rightAnswer;
		
	} // end method getRightAnswer
	
	public int getMoney() { // yarismacinin kazanacagi paraya ulasma methodu
		
		return money;
		
	} // end method getMoney
	
	public void setQueryType(String queryType) { // sorunun kacinci soru tipinde oldugunu olusturma methodu
		
		this.queryType = queryType;
		
	} // end method setQueryType
	
	public void setQuery(String query) { // soruyu olusturma methodu
		
		this.query = query;
		
	} // end method setQuery
	
	public void setAnswerA(String answerA) { // a sikkini olusturma methodu
		
		this.answerA = answerA;
		
	} // end method setAnswerA
	
	public void setAnswerB(String answerB) { // b sikkini olusturma methodu
		
		this.answerB = answerB;
		
	} // end method setAnswerB
	
	public void setAnswerC(String answerC) { // c sikkini olusturma methodu
		
		this.answerC = answerC;
		
	} // end method setAnswerC
	
	public void setAnswerD(String answerD) { // d sikkini olusturma methodu
		
		this.answerD = answerD;
		
	} // end method setAnswerD
	
	public void setRightAnswer(String rightAnswer) { // dogru cevabi olusturma methodu
		
		this.rightAnswer = rightAnswer;
		
	} // end method setRigtAnswer
	
	public void setMoney(int money) { // yarismacinin kazanacagi parayi olusturma methodu
		
		this.money = money;
		
	} // end method setMoney
	
	@Override
		
	public String toString() { // toString methodunu soru ve siklari bastiracak sekilde override ediyoruz
		
		return query + "\n" + "\n" + "A: " + answerA + "\t" + "B: " + answerB + "\n" + "C: " + answerC + "\t" + "D: " + answerD;
				
	} // end method toString
	
	public static void main(String[] args) { // main method
		
		
	} // end method main

} // end class question
