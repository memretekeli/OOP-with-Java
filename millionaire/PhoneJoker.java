package millionaire;

import java.util.Random;

public class PhoneJoker extends Joker {
	
	/* PhoneJoker sinifi Joker sinifindan inherit eder. Yarismacinin Milyoner oyununda kullanacagi telefon jokeri hakki
	 * icin tasarlanan bir siniftir. PhoneJoker objeleri 3 adet veri alanina, bu verilerin get ve set methodlarida ve 
	 * telefon jokeri kullanimi icin olusturulmus bir methoda sahiptir. Bu method Joker sinifindan inhert edilen abstract
	 * method uzerine override edilmistir.
	 */
	
	private String friend1; // telefon jokerinde aranacak 1. arkadas
	private String friend2; // telefon jokerinde aranacak 2. arkadas
	private String friend3; // telefon jokerinde aranacak 3. arkadas
	
	/* Aslýnda 3 farklý kisinin bu programin calismasinda herhangi bir etkisi yok. Sadece yarismanin 
	 * orjinali ile uyumlu olsun diye bu 3 kisiyi ekleme geregi duydum.
	 */
	
	public PhoneJoker(String friend1, String friend2, String friend3, int jokerRight) { // PhoneJoker objesi 3 kisi ismi ve bir de joker hakki ile olusturulur.
		
		this.friend1 = friend1;
		this.friend2 = friend2;
		this.friend3 = friend3;
		this.jokerRight = jokerRight;
		
	} // end constructor

	
	// getter ve setter methods
	
	public String getFriend1() { // 1. telefon jokeri arkadasi cagirma methodu
		
		return friend1;
		
	} // end method getFriend1
	
	public String getFriend2() { // 2. telefon jokeri arkadasi cagirma methodu
		
		return friend2;
		
	} // end method getFriend2
	
	public String getFriend3() { // 3. telefon jokeri arkadasi cagirma methodu
		
		return friend3;
		
	} // end method getFriend3
	
	public void setFriend1(String friend1) { // 1. telefon jokeri arkadasi olusturma methodu
		
		this.friend1 = friend1;
		
	} // end method setFriend1
	
	public void setFriend2(String friend2) { // 2. telefon jokeri arkadasi olustruma methodu
		
		this.friend2 = friend2;
		
	} // end method setFriend2
	
	public void setFriend3(String friend3) { // 3. telefon jokeri arkadasi olustruma methodu
		
		this.friend3 = friend3;
		
	} // end method setFriend3
	
	
	/** printRightAnswer methodu Joker sinifindan inherit edilen abstract methoddur. Bu methodu yarismada kullanabilmek icin
	 * Override ediyoruz. Method su sekilde calisiyor:
	 * 
	 * Method parametre olarak Question sinifindan bir nesne aliyor. Daha sonra question nesnesinin soru numarasini cekip
	 * her bir soru icin sorunun zorlugu kontrol ediliyor. Daha sonra kontrole gore soru numarasi buyudukce soruyu dogru cevaplama
	 * orani kuculecek sekilde dogru cevabi ekrana bastiriyor. Bunu her bir soru icin rastgele sayilar uretip o sayilara bagli kosul ile 
	 * dogru cevap verip vermeyecegine karar vererek gerceklestiriyor.. Bu sekilde gercek hayata yakin bir joker deneyimi elde
	 * edilecek. Ýlk sorularda daha dogru son sorularda ise daha yanlis olma olasiligi yuksek cevaplar donecek.
	 */

	@Override
	public String printRightAnswer(Question question) { // Main classta joker kullanma methodu olarak calisacak
		
		String temp = null;
		
		if (question.getAnswerA().equals(question.getRightAnswer())) {
			
			temp = "a";
			
		} else if (question.getAnswerB().equals(question.getRightAnswer())) {
			
			temp = "b";
			
		} else if (question.getAnswerC().equals(question.getRightAnswer())) {
			
			temp = "c";
			
		} else if (question.getAnswerD().equals(question.getRightAnswer())) {
			
			temp = "d";
			
		} // end if
		
		Random rnd = new Random(); // Random sinifindan bir nesne olusturuyoruz
		
		String returnValue = null;
		
		if (question.getQueryType().equals("1")) { // eger secilen soru 1. sorular grubundan ise
			
			returnValue = "Bu sorunun cevabýnýn " + question.getRightAnswer() + " olduguna %100 eminim."; // direkt olarak dogru cevabi basiyor
			
		
		} else if (question.getQueryType().equals("2")) { // 2. soru grubu icin
						
			int r = rnd.nextInt(11); // 0 ile 11 arasinda rastgele bir sayi uretiyor
			
			if( r > 0) { // 12 sayinin 11 tanesi icin dogru cevabi basacak
				
				returnValue = "Bu sorunun cevabinin " + question.getRightAnswer() + " oldugunu dusunuyorum.";
				
			} else { // tasarlanmis bir cevap gelecek
				
				if (temp.equals("a")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerD() + " oldugunu dusunuyorum.";
				
				} else if (temp.equals("b")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerC() + " oldugunu dusunuyorum.";
					
				} else if (temp.equals("c")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";
					
				}  else if (temp.equals("d")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerA() + " oldugunu dusunuyorum.";
					
				}  // end if
				
			} // end if type 2
			
		} else if (question.getQueryType().equals("3")) { // 3. soru grubu icin
			
			int r = rnd.nextInt(11);
			
			if( r > 1) { // 12 sayinin 10 tanesi icin dogru cevap
				
				returnValue = "Bu sorunun cevabinin " + question.getRightAnswer() + " oldugunu dusunuyorum.";
				
			} else { // tasarlanmis bir cevap gelecek
				
				if (temp.equals("a")) {
					
					returnValue = "Bu sorunun cevabinin " + question.getAnswerD() + " oldugunu dusunuyorum.";
				
				} else if (temp.equals("b")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerC() + " oldugunu dusunuyorum.";
					
				} else if (temp.equals("c")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";
					
				}  else if (temp.equals("d")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerA() + " oldugunu dusunuyorum.";
					
				}  // end if
				
			} // end if type 3
			
		} else if (question.getQueryType().equals("4")) { // 4. soru grubu icin
			
			int r = rnd.nextInt(11);
			
			if( r > 2) { // 12 sayinin 9 tanesi icin
				
				returnValue = "Bu sorunun cevabinin " + question.getRightAnswer() + " oldugunu dusunuyorum.";
				
			} else { // tasarlanmis bir cevap gelecek
				
				if (temp.equals("a")) {
					
					returnValue = "Bu sorunun cevabinin " + question.getAnswerD() + " oldugunu dusunuyorum.";
				
				} else if (temp.equals("b")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerC() + " oldugunu dusunuyorum.";
					
				} else if (temp.equals("c")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";
					
				}  else if (temp.equals("d")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerA() + " oldugunu dusunuyorum.";
					
				}  // end if
				
			} // end if type 4
						
		} else if (question.getQueryType().equals("5")) { // 5 . soru grubu icin
			
			int r = rnd.nextInt(11);
			
			if( r > 3) { // 12 Sayinin 8 tanesi icin
				
				returnValue = "Bu sorunun cevabinin " + question.getRightAnswer() + " oldugunu dusunuyorum.";
				
			} else { // tasarlanmis bir cevap gelecek
				
				if (temp.equals("a")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerD() + " oldugunu dusunuyorum.";
				
				} else if (temp.equals("b")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerC() + " oldugunu dusunuyorum.";
					
				} else if (temp.equals("c")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";
					
				}  else if (temp.equals("d")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerA() + " oldugunu dusunuyorum.";
					
				}  // end if
				
			} // end if type 5
						
		} else if (question.getQueryType().equals("6")) {
			
			int r = rnd.nextInt(11);
			
			if( r > 4) {
				
				returnValue = "Bu sorunun cevabinin " + question.getRightAnswer() + " oldugunu dusunuyorum.";
				
			} else {
				
				if (temp.equals("a")) {
					
					returnValue = "Bu sorunun cevabinin " + question.getAnswerD() + " oldugunu dusunuyorum.";
				
				} else if (temp.equals("b")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerC() + " oldugunu dusunuyorum.";
					
				} else if (temp.equals("c")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";
					
				}  else if (temp.equals("d")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerA() + " oldugunu dusunuyorum.";
					
				}  // end if
				
			} // end if type 6
		
		} else if (question.getQueryType().equals("7")) {
			
			int r = rnd.nextInt(11);
			
			if( r > 5) {
				
				returnValue = "Bu sorunun cevabinin " + question.getRightAnswer() + " oldugunu dusunuyorum.";
				
			} else {
				
				if (temp.equals("a")) {
					
					returnValue = "Bu sorunun cevabinin " + question.getAnswerD() + " oldugunu dusunuyorum.";
				
				} else if (temp.equals("b")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerC() + " oldugunu dusunuyorum.";
					
				} else if (temp.equals("c")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";
					
				}  else if (temp.equals("d")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerA() + " oldugunu dusunuyorum.";
					
				}  // end if
				
			} // end if type 7
			
			
		} else if (question.getQueryType().equals("8")) {
			
			int r = rnd.nextInt(11);
			
			if( r > 6) {
				
				returnValue = "Bu sorunun cevabinin " + question.getRightAnswer() + " oldugunu dusunuyorum.";
				
			} else {
				
				if (temp.equals("a")) {
					
					returnValue = "Bu sorunun cevabinin " + question.getAnswerD() + " oldugunu dusunuyorum.";
				
				} else if (temp.equals("b")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerC() + " oldugunu dusunuyorum.";
					
				} else if (temp.equals("c")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";
					
				}  else if (temp.equals("d")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerA() + " oldugunu dusunuyorum.";
					
				}  // end if
				
			} // end if type 8
			
			
		} else if (question.getQueryType().equals("9")) {
			
			int r = rnd.nextInt(11);
			
			if( r > 7) {
				
				returnValue = "Bu sorunun cevabinin " + question.getRightAnswer() + " oldugunu dusunuyorum.";
				
			} else {
				
				if (temp.equals("a")) {
					
					returnValue = "Bu sorunun cevabinin " + question.getAnswerD() + " oldugunu dusunuyorum.";
				
				} else if (temp.equals("b")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerC() + " oldugunu dusunuyorum.";
					
				} else if (temp.equals("c")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";
					
				}  else if (temp.equals("d")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerA() + " oldugunu dusunuyorum.";
					
				}  // end if
				
			} // end if type 9
			
			
		} else if (question.getQueryType().equals("10")) {
			
			int r = rnd.nextInt(11);
			
			if( r > 8) {
				
				returnValue = "Bu sorunun cevabinin " + question.getRightAnswer() + " oldugunu dusunuyorum.";
				
			} else {
				
				returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";if (temp.equals("a")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerD() + " oldugunu dusunuyorum.";
				
				} else if (temp.equals("b")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerC() + " oldugunu dusunuyorum.";
					
				} else if (temp.equals("c")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";
					
				}  else if (temp.equals("d")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerA() + " oldugunu dusunuyorum.";
					
				}  // end if
				
			} // end if type 10
			
		} else if (question.getQueryType().equals("11")) {
			
			int r = rnd.nextInt(11);
			
			if( r > 9) {
				
				returnValue = "Bu sorunun cevabinin " + question.getRightAnswer() + " oldugunu dusunuyorum.";
				
			} else {
				
				if (temp.equals("a")) {
					
					returnValue = "Bu sorunun cevabinin " + question.getAnswerD() + " oldugunu dusunuyorum.";
				
				} else if (temp.equals("b")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerC() + " oldugunu dusunuyorum.";
					
				} else if (temp.equals("c")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";
					
				}  else if (temp.equals("d")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerA() + " oldugunu dusunuyorum.";
					
				}  // end if
				
			} // end if type 11
			
		} else if (question.getQueryType().equals("12")) {
			
			int r = rnd.nextInt(11);
			
			if( r > 10) {
				
				returnValue = "Bu sorunun cevabinin " + question.getRightAnswer() + " oldugunu dusunuyorum.";
				
			} else {
				
				if (temp.equals("a")) {
					
					returnValue = "Bu sorunun cevabinin " + question.getAnswerD() + " oldugunu dusunuyorum.";
				
				} else if (temp.equals("b")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerC() + " oldugunu dusunuyorum.";
					
				} else if (temp.equals("c")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerB() + " oldugunu dusunuyorum.";
					
				}  else if (temp.equals("d")) {
				
					returnValue = "Bu sorunun cevabinin " + question.getAnswerA() + " oldugunu dusunuyorum.";
					
				}  // end if
				
			} // end if type 12
			
		} // end if
		
		return returnValue;
		
				
	} // end method printRightAnswer
	
	@Override
	
	public String toString() { // Bu method ise yarismada telefon jokeri kullanilacagi zaman arkadas secimi sirasinda calisacak
		
		return "Hangi arkadasini aramak istiyorsun?\n" + "1." + friend1 + "\n" + "2." + friend2 + "\n" + "3." + friend3;
		
	} // end method toString


	public static void main(String[] args) { // main method
		
	} // end method main


} // end class PhoneJoker


