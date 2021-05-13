package millionaire;

import java.util.Scanner;

public class DoubleAnswer extends Joker{
	
	/* DoubleAnswer sinifi Joker sinifindan inherit eder. Milyoner yarismasindaki Cift Cevap jokerini kullanabilmek icin
	 * olusturulmustur. Kendi data field alani yoktur. Tek method olarak Joker sinifinin abstract methodunu override eder.
	 */
	
	
	public DoubleAnswer(int jokerRight) {
		
		this.jokerRight = jokerRight;
		
	} // end constructor

	
	/* printRightAnswer methodu, Joker sinifindan inherit edilen abstract methoddur. Parametre olarak bir adet question nesnesi alir.
	 * Daha sonra o question nesnesinin dogru cevabini ve diger cevaplarini tutar. Yarismacinin 2 cevap verebilmesi icin if-else kullanir.
	 * Alinan ilk cevap dogruysa cevabi return eder ve cikar. Eger yanlissa ikinci cevabi ister ve cevabi return eder cikar.
	 */
	
	@Override
	public String printRightAnswer(Question question) {
		
		String returnValue = null; // return edecegimiz string degisken
		String answerInput; // ilk cevabi alacagimiz degisken
		char answer1; // ilk cevabin ilk harfini char olarak alacagimiz degisken
		String answerInput2; // ikinci cevabi alacagimiz degisken
		char answer2; // ikinci cevabin ilk harfini char olarak alacagimiz degisken
		String tempAnswer = null; // ilk girilen cevabi kontrol edebilmek icin gecici degisken
		
		Scanner keyboard = new Scanner(System.in);
		
		answerInput = keyboard.next(); // ilk cevabi aliyoruz
		answer1 = answerInput.toLowerCase().charAt(0);
		String answer1str = String.valueOf(answer1);
		
		if (answer1 == 'a') // a secenegi secilmisse
			tempAnswer = question.getAnswerA();
		else if (answer1 == 'b') // b secenegi secilmisse
			tempAnswer = question.getAnswerB();
		else if (answer1 == 'c') // c secenegi secilmise
			tempAnswer = question.getAnswerC();
		else if (answer1 == 'd') // d secenegi secilmisse
			tempAnswer = question.getAnswerD();
		
		if (tempAnswer.equals(question.getRightAnswer())){ // eger cevap dogruysa
			
			returnValue = answer1str; // ilk cevabi return edip cikiyor
			
			} else { // eger ilk cevap yanlissa
				System.out.println();
				System.out.println("Yanlis cevap verdin, lutfen 2. cevabini gir:");
				System.out.println();
				

				answerInput2 = keyboard.next(); // tekrar cevap aliyoruz
				answer2 = answerInput2.toLowerCase().charAt(0);
				String answer2str = String.valueOf(answer2);
				
				returnValue = answer2str; // 2. cevabin dogrulugunu kontrol etmeden return ediyor. Yarismanin kendi dongusunde dogruluk kontrol edilcek.
			}
			
		return returnValue; 
		
	} // end method printRightAnswer
	
	
	public static void main(String[] args) { // main method
		

	} // end method main
	

} // end class DoubleAnswer
