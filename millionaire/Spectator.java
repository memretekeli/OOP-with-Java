package millionaire;

import java.util.Random;
import java.lang.Math;

public class Spectator extends Joker {
	
	/* Spectator sinifi Joker sinifindan inherit eder. Milyoner yarismasinda Seyirciye Sor joker hakki objesini olusturan sinftir.
	 * Bu sinifin kendine ait data field alani bulunmamaktadir. Tek methodu Joker sinifindan inherit edilen abstract printRightAnswer
	 * methodudur. Bu methodu Override ederek joker hakki kullanilan kisimda seyircilerin cevap oranlarini random dagitarak ekrana basar.
	 */

	
	public Spectator(int jokerRight) { // sadece joker hakkini 1 olarak tanimlamamiz yeterli
		
		this.jokerRight = jokerRight;
		
	} // end constructor
	
	
	/* Bu method parametre bir adet question nesnesi ve bir integer alir. Bu aldigi sorunun dogru cevabini bulur.
	 * Sonra min degerine gore sorunun zorulugu arttikca daha rastgele olacak sekilde cevap yuzdeleri uretir.
	 * Alinan soru ne kadar kolaysa dogru cevap yuzdesi o kadar yuksek olur. Soru ne kadar zorsa daha az ihtimalle
	 * dogru cevap yuzdesi kendini seceneklerde belli eder.
	 */
	
	public static int[] randomer (Question question, int min) {
		
		int rndA = 0; // cevap a yuzdesi
		int rndB = 0; // cevap b yuzdesi
		int rndC = 0; // cevap c yuzdesi
		int rndD = 0; // cevap d yuzdesi
		
		Random rnd = new Random();
		
		if (question.getAnswerA().equals(question.getRightAnswer())) { // eger dogru cevap a ise
			
			rndA = (int)Math.floor(Math.random()*(95-min+1)+min); 
			
			rndB = rnd.nextInt(100 - rndA);
			
			rndC = rnd.nextInt(100 - (rndA + rndB));
			
			rndD = 100 - (rndA + rndB + rndC);				
			
		} else if (question.getAnswerB().equals(question.getRightAnswer())) { // eger dogru cevap b ise
			
			rndB = (int)Math.floor(Math.random()*(95-min+1)+min);
			
			rndA = rnd.nextInt(100 - rndB);
			
			rndC = rnd.nextInt(100 - (rndB + rndA));
			
			rndD = 100 - (rndA + rndB + rndC);	
			
		} else if (question.getAnswerC().equals(question.getRightAnswer())) { // eger dogru cevap c ise
			
			rndC = (int)Math.floor(Math.random()*(95-min+1)+min);
			
			rndA = rnd.nextInt(100 - rndC);
			
			rndB = rnd.nextInt(100 - (rndA + rndC));
			
			rndD = 100 - (rndA + rndB + rndC);
			
		} else if (question.getAnswerD().equals(question.getRightAnswer())) { // eger dogru cevap d ise
			
			rndD = (int)Math.floor(Math.random()*(95-min+1)+min);
			
			rndA = rnd.nextInt(100 - rndD);
			
			rndB = rnd.nextInt(100 - (rndA + rndD));
			
			rndC = 100 - (rndA + rndB + rndD);
			
		} // end if
		
		int[] finalArray = new int[4];
		
		finalArray[0] = rndA; // A secenegi
		finalArray[1] = rndB; // B secenegi
		finalArray[2] = rndC; // C secenegi
		finalArray[3] = rndD; // D secenegi
		
		return finalArray;
			
				
	} // end method randomer
	
	/* printRightAnswer methodu Joker sinifindan inherit edilen abstract methoddur. Bu method bu sinifa ait randomer fonksiyonunu kullanarak
	 * milyoner yarismasindaki seyirciye sor jokeri icin cikti uretir. Soru ne kadar kolaysa dogru cevabin yuzdesinin yuksek olma ihtimali fazladir.
	 * Method cikti olarak her bir secenek icin yaninda bir yuzde verir. Bu yuzdeler toplami 100 olacak sekilde dizayn edilmistir.
	 */

	@Override
	public String printRightAnswer(Question question) {
		
		
		
		int[] rndArray = new int[4];
		
		
		if (question.getQueryType().equals("1")) {
			
			rndArray = randomer(question, 92);
								
		} else if (question.getQueryType().equals("2")) {
			
			rndArray = randomer(question, 90);			
			
		} else if (question.getQueryType().equals("3")) {
			
			rndArray = randomer(question, 80);
			
		} else if (question.getQueryType().equals("4")) {
			
			rndArray = randomer(question, 70);
						
		} else if (question.getQueryType().equals("5")) {
			
			rndArray = randomer(question, 60);
						
		} else if (question.getQueryType().equals("6")) {
			
			rndArray = randomer(question, 50);
		
		} else if (question.getQueryType().equals("7")) {
			
			rndArray = randomer(question, 45);
			
		} else if (question.getQueryType().equals("8")) {
			
			rndArray = randomer(question, 37);
			
			
		} else if (question.getQueryType().equals("9")) {
			
			rndArray = randomer(question, 29);
			
			
		} else if (question.getQueryType().equals("10")) {
			
			rndArray = randomer(question, 22);
			
			
		} else if (question.getQueryType().equals("11")) {
			
			rndArray = randomer(question, 15);
			
			
		} else if (question.getQueryType().equals("12")) {
			
			rndArray = randomer(question, 10);
			
			
		} // end if
		
		return "A: " + "%" + rndArray[0] + "\n" + "B: " + "%" +  rndArray[1] + "\n" + "C: " + "%" +  rndArray[2] + "\n" + "D: " + "%" +  rndArray[3]; // yuzdeleri ekrana basar
	
		
	} // end method printRightAnswer

	
	public static void main(String[] args) { // main method
		
		

	} // end method main

} // end class Spectator
