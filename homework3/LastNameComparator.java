package homework3;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Contact>{
	
	/* LastNameComparator classi Contact objesisinin lastName data fieldi uzerinden karsilastirma yapar ve Contact objelerini
	 * kucukten buyuge siralamak icin kullanilir.
	 */

	public static void main(String[] args) { // main method

	} // end method main

	@Override
	public int compare(Contact c1, Contact c2) {
	
		return c1.getLastName().compareTo(c2.getLastName());
	}

} // end class LastNameComparator
