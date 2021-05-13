package homework3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ArrayList<String> arrayList = new ArrayList<>(); // dosyayi okutacagimiz arrayList

		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) { // dosyayi arrayliste okutuyoruz
			
		    while (br.ready()) {
		    	
		        arrayList.add(br.readLine());
		        
		    } // end while

		} catch (FileNotFoundException f) {
			
			System.out.println("Dosya okunamadi...");
			
		} // end try catch
	
		
		String[][] inPut = new String[arrayList.size()][4]; // arraylListi aktaracagimiz 2D String array
		
		for (int i = 0; i < arrayList.size(); i++) { // arraylisti 2D string arraye aktariyoruz
			
			String [] str1 = arrayList.get(i).split(" ");
			
			for(int j = 0; j < str1.length; j++) {
				
				inPut[i][j] = str1[j];				
				
			} // end for 2
			
		} // end for 1
		
		
		// Dosyayi contact objeleri olarak arrayliste aktariyoruz
		
		ArrayList<Contact> ContactsArrayList = new ArrayList<Contact>(); // contact arraylisti
		
		
		for (int i = 0; i < inPut.length; i++) {
			
			ContactsArrayList.add(new Contact (inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3])); // constructor ile obje olusturup arrayliste ekliyoruz
			
		} // end for
		
		
		/* hasCode'un calisabilmesi icin phoneNumber alaninin String yerine integer olarak tutulmasi gerekmekte
		 * Bunun icin String phoneNumber kismini "-"ler ile ayirarak 3 ayri stringe donusturecegiz.
		 * Daha sonra bu 3 stringi concar edip Integer olarak parse edecegiz.
		 */
		
		
		for (Contact c : ContactsArrayList) { 
			
			String [] PhoneNumberArray = c.getPhoneNumber().split("\\-"); // "-"ler ile ayiriyoruz
			String temp = PhoneNumberArray[0] + PhoneNumberArray[1] + PhoneNumberArray[2]; // ayridigimiz kisimalari concat ediyoruz.
			int tempnumber = Integer.parseInt(temp); // Concat edilmis stringi integer olarak parse ediyoruz
			c.setIntPhoneNumber(tempnumber); // integer degeri Contact nesnelerimize tanimliyoruz
			
		} // end for		
		

		
		PrintStream output1 = new PrintStream(new File("ContactsArrayList.txt")); // outputu ContactsArrayList.txt ye yazacak sekilde ayarliyoruz
		  
		System.setOut(output1);
		
		
		for (Contact c : ContactsArrayList) { // arraylist uzerinde gezip her elemani print ediyoruz.
			
			System.out.println(c);
			
		} // end for
		
		
		
		PrintStream output2 = new PrintStream(new File("ContactsArrayListOrderByLastName.txt")); // outputu ContactsArrayListOrderByLastName.txt ye yazacak sekilde ayarliyoruz
		
		System.setOut(output2); 
		
		
		Collections.sort(ContactsArrayList, new LastNameComparator()); // LastNameComparator sinifindan bir nesne kullanarak soyada gore siraliyoruz
		
		
		for (Contact c : ContactsArrayList) {
						
			System.out.println(c); // arraylist uzerinde gezip her elemani print ediyoruz.
			
		} // end for
		

		
		PrintStream output3 = new PrintStream(new File("ContactsHashSet.txt")); // outputu ContactsHashSet.txt ye yazacak sekilde ayarliyoruz
		
		System.setOut(output3); 

		
		HashSet<Contact> ContactsHashSet= new HashSet<Contact>(); // HashSet olusturuyoruz
		
		ContactsHashSet.addAll(ContactsArrayList); // ContactsArrayList icindeki tum elemanlari HashSet'e aktariyoruz
		
		
		for (Contact c : ContactsHashSet) { // HashSet uzerinde gezip her elemani print ediyoruz.
						
			System.out.println(c);
			
		} // end for
		
		
		
		PrintStream output4 = new PrintStream(new File("ContactsTreeSet.txt")); // outputu ContactsTreeSet.txt ye yazacak sekilde ayarliyoruz
		
		System.setOut(output4); 

		
		TreeSet<Contact> ContactsTreeSet= new TreeSet<Contact>(); // TreeSet olusturuyoruz
		
		ContactsTreeSet.addAll(ContactsArrayList); // ContactsArrayList icindeki tum elemanlari TreeSet'e aktariyoruz
		
		
		for (Contact c : ContactsTreeSet) { // TreeSet uzerinde gezip her elemani print ediyoruz.
						
			System.out.println(c);
			
		} // end for
		
		
		
		PrintStream output5 = new PrintStream(new File("ContactsTreeSetOrderByLastName.txt")); // outputu ContactsTreeSetOrderByLastName.txt ye yazacak sekilde ayarliyoruz
		
		System.setOut(output5); 
		
		
		TreeSet<Contact> ContactsTreeSetOrderByLastName = new TreeSet<Contact>(new LastNameComparator()); // TreeSeti LastNameComparator ile siralayacak sekilde olusturyoruz
		
		ContactsTreeSetOrderByLastName.addAll(ContactsArrayList); // ContactsArrayList icindeki tum elemanlari TreeSet'e aktariyoruz
		
		
		for (Contact c : ContactsTreeSetOrderByLastName) { // TreeSet uzerinde gezip her elemani print ediyoruz. 
						
			System.out.println(c);
			
		} // end for
		
		
		
		PrintStream output6 = new PrintStream(new File("ContactsHashMap.txt")); // outputu ContactsHashMap.txt ye yazacak sekilde ayarliyoruz
		
		System.setOut(output6); 
		
		
		HashMap<String, Contact> ContactsHashMap = new HashMap<String, Contact>(); // Key olarak String deger ve Value olarak Contact deger alacak sekilde HashMap olusturuyoruz
		
		for (int i = 0; i < ContactsArrayList.size(); i++) { // ContactsArrayList üzerinde gezip phoneNumber'i key nesnenin kendisini de value alacak sekilde hashMapi dolduruyoruz
			
			ContactsHashMap.put(ContactsArrayList.get(i).getPhoneNumber(), ContactsArrayList.get(i));
			
			
		} // end for
		
		for (Contact c : ContactsHashMap.values()) { // HashMap uzerinde gezip sadece degerleri tek tek bastiriyoruz
						
			System.out.println(c);
			
		} // end for
		
		
	} // end method main

} // end class Main
