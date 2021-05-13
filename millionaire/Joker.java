package millionaire;

public abstract class Joker {
	
	/* Joker sinifi Milyoner yarismasinda kullanilabilir olan joker haklarinin olusturulacagi soyut
	 * siniftir. 4 adet joker hakki bu siniftan inherit eder. 
	 */
	
	// data fields
	
	protected int jokerRight; // joker objesinin kullanilabilir olmasi icin Joker hakki degiskeni. Dogasi geregi 1 ya da 0 olabilir.
	// Alt siniflardan rahat erisebilmek icin protected olarak tanimlanmistir.
	
	
	// getter ve setter methodlar
	
	public int getJokerRight() { // joker hakkini cagiran method
		
		return jokerRight;
		
	} // end method getJokerRight
	
	public void setJokerRight(int jokerRight) { // joker hakkini tanimlayan method
		
		this.jokerRight = jokerRight;
		
	} // end method setJokerRight
		
	
	
	public abstract String printRightAnswer(Question question); // Joker haklarinin kullanilma yontemi icin absract method. Alt siniflarda tanimlanacak.

	public static void main(String[] args) { // main method
	

	} // end method main

} // end anstract class Joker
