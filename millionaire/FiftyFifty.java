package millionaire;

public class FiftyFifty extends Joker {
	
	/* FiftyFifty sinifi Joker sinifindan inherit eder. Milyoner yarismasindaki 50:50 Joker hakkinin kullanimi icin olusturulmustur.
	 * Bu sinifin kendi data field alani yoktur. Tek method olarak Joker sinifindan inherit ettigi abstract methodu override eder.
	 */


	
	public FiftyFifty(int jokerRight) { // JokerRight'i 1 yaparak obje olusturuyoruz.
		
		this.jokerRight = jokerRight;
		
	} // end constructor
	
	/* printRightAnswer methodu yarismadaki 50:50 jokerini kullanmak icin olusturulmustur. Methodu parametre olarak Question sinifindan
	 * bir obje alir. Bu aldigi soru objesisinin dogru cevabini tutar ve iki yanlis cevabi silerek ekrana bir dogru bir de yanlis cevap bastirir.
	 * Kullanici bu cevaplardan secim yaparak ilerler. Ekrana bastirilacak yanlis cevap konusunda tam bir rastgelesellik olusturamadim. A dogru cevaplari
	 * D ile birlikte B dogru cevaplari C ile birlikte ve bunlarin tam tersi olacak sekilde dizayn ettim. Kullanicinin bunu fark edip bundan kendine
	 * bir sonuc cikarmasi mumkun ama bunu fark edebilmesi icin cok fazla oyun oynamasi gerekecegi icin bu kucuk ihtimali goz ardi ettim :)
	 */

	@Override
	public String printRightAnswer(Question question) {
		
		String returnValue = null; // return edecegimiz degisken
			
		String tempAnswer = question.getRightAnswer(); // sorunun dogru cevabini gecici bir stringe tanimliyoruz
		
		if (question.getAnswerA().equals(tempAnswer)) { // A secenegi dogru cevapsa
			
			returnValue = "\n" + "\n" + "A: " + question.getAnswerA() + "\n" + "D: " + question.getAnswerD(); // A ve D seceneklerini bastiriyor
			
		} else if (question.getAnswerB().equals(tempAnswer)) { // B secenegi dogru cevapsa
			
			returnValue = "\n" + "\n" + "B: " + question.getAnswerB() + "\n" + "C: " + question.getAnswerC(); // B ve C bastiriyor
			
		} else if (question.getAnswerC().equals(tempAnswer)) { // C secenegi dogru cevapsa
			
			returnValue = "\n" + "\n" + "B: " + question.getAnswerB() + "\n" + "C: " + question.getAnswerC(); // B ve C bastiriyor
			
		} else if (question.getAnswerD().equals(tempAnswer)) { // D secenegi dogru cevapsa
			
			returnValue = "\n" + "\n" + "A: " + question.getAnswerA() + "\n" + "D: " + question.getAnswerD(); // A ve D bastiriyor
			
		} // end if 
		
		return returnValue;
				
		
	} // end method printRightAnswer
	


	public static void main(String[] args) { // main method

	} // end method main
	

} // end class FiftyFity
