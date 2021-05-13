
// Mahmut Emre Tekeli - N20233102 - emre.tekeli@hacettepe.edu.tr

public class homework1 {
	
	  /** num_digits methodu input olarak aldigi tamsayinin basamak sayisini sayar ve
	   * counter adli degiskene tanimlar. Method ekrana cikti vermez, return degeri olarak
	   * counter degiskenini geri dondurur.
	   */
		  
	  public static int num_digits(int num) {
		
		 if (num <= 0) { // num degiskeni 0 dan kucuk ise -1 ile carpip pozitif hale getiriyoruz.
			 
			 num = num * (-1);
			 
		 } // end if
			
		int counter = 1; // Sayac tanimliyoruz.
					
		while (num >= 10) {
			
			num /= 10; // num sayisini her 10 a boldugunde bolum kisimini tekrar numa tanimliyoruz.			
			counter++; // her dongude counter 1 artiyor ve num 10 dan kucuk olunca donguden cikiyor.	
			
			} // end while
						
		return counter;
	
	  } // end method num_digits
	  
	  
	  /** number_matrix methodu input olarak aldigi r ve c integer sayilarini
	   * r = satir sayisi, c = sutun sayisi olarak kullanarak bir array olusturur
	   * ve bu arrayi ekrana basar. Bu array ilk satirda 1 den baslar ve ardisik
	   * olarak sutun sayisi kadar birer artarak devam eder. 2. satira gecince
	   * 2 den baslar ve ayni sekilde devam eder. Bu sekilde her satir ayni sekilde
	   * devam eder ve satir sayisi bitince array sonlanir.
	   */ 	  
	 
	  public static void number_matrix(int r, int c) {
		  
		  int[][] newMatrix = new int[r][c]; // newMatrix ismi ile r satir ve c sutun sayili array tanimliyoruz.
		  
		  for (int x = 0; x < r; x++) {
			  
			  for (int y = 0; y < c; y++) {
			  
			  newMatrix[x][y] = x + y + 1; // arrayin ilk satirinin 1 den baslamasi icin 1 ekliyoruz
			  
			  } // 2. for
			  
		  } // 1. for
		  
		  for (int row = 0; row < newMatrix.length; row++) { // matrix yazdirma
			  
			  for (int column = 0; column < newMatrix[row].length; column++) {
				  
				  System.out.print(newMatrix[row][column ] + " ");
				  
			  } // 2. for
			  
			  System.out.println();
			  
		  } // 1.for
	  		  	 		  
	  } // end method number_matrix
	  
	  
	  /** str_replace methodu 3 adet string parametre alır. Ilk aldigi stringin icinde
	   * ikinci stringi arar, eger yoksa ilk stringi dondurur. Eger 2. string ilk stringin
	   * icinde varsa 2. stringin yerine 3. stringi yazar ve bu yeni olusan stringi dondurur.
	   * Ekrana herhangi bir cikti vermez.
	   */
	    
	  public static String str_replace(String str1, String str2, String str3) {
						
			String finalString; // dondurecegimiz string			
			finalString = str1; // ikinci stringin olmamasi durumunda ilk stringin donmesi icin esitleme			
			int l1 = str1.length(); // ilk stringin uzunlugu			
			int l2 = str2.length(); // ikinci stringin uzunlugu, yer belirlerken lazim olacak
				
			while (finalString.contains(str2)) { // string 2'yi string 1'in icinde ariyoruz
				
				int start = str1.indexOf(str2); // 2. stringin yerini belirleme				
				String part1, part2, part3; // string concat islemi icin kullanacgımız degiskenler
				
				if (start == 0){	// eger aradigimiz string bastaysa
													
					part2 = str1.substring(l2, l1);						
					finalString = str3 + part2;										
					
				} else if (start > 0 && start < l1) { // eger aradigimiz string ortada veya sondaysa
					
					part1 = str1.substring(0, start);					
					part2 = str1.substring(start, start + l2);					
					part3 = str1.substring(start + l2, l1);					
					finalString = part1 + str3 + part3;
					
				} // end if
							
			} // end while
					
			return finalString;
			
		} // end method str_replace
	  
	  
	  /** compute_letter methodu 4 adet double girdi alır. Bunlar 3 adet odev notu
	   * ve bir adet final notudur. Odev notlarini 0.2, final notunu 0.4 sayisi ile 
	   * carparak nihai notu bulur. Buldugu notu en yakin tamsayiya yuvarlar ve
	   * bu degerin karsiligi olan harf notunu dondurur. Ekrana cikti vermez.
	   */
	  	  
	  public static String compute_letter(double a1, double a2, double a3, double f) {
		  
		  double avgGrade = 0.2 * a1 + 0.2 * a2 + 0.2 * a3 + 0.4 * f;
		  avgGrade = java.lang.Math.round(avgGrade); // notlari en yakin tamsayi degerine yuvarliyoruz.
		  
		  String letterGrade;
		  
		  if (avgGrade >= 95 && avgGrade <= 100)
			  letterGrade = "A1";
		  else if (avgGrade >= 90 && avgGrade < 95)
			  letterGrade = "A2";
		  else if (avgGrade >= 85 && avgGrade < 90)
			  letterGrade = "A3";
		  else if (avgGrade >= 80 && avgGrade < 85)
			  letterGrade = "B1";
		  else if (avgGrade >= 75 && avgGrade < 80)
			  letterGrade = "B2";
		  else if (avgGrade >= 70 && avgGrade < 75)
			  letterGrade = "B3";
		  else if (avgGrade >= 65 && avgGrade < 70)
			  letterGrade = "C1";
		  else if (avgGrade >= 60 && avgGrade < 65)
			  letterGrade = "C2";
		  else if (avgGrade >= 55 && avgGrade < 60)
			  letterGrade = "C3";
		  else if (avgGrade >= 40 && avgGrade < 55)
			  letterGrade = "D";
		  else
			  letterGrade = "F";	    
		  
		  return letterGrade; 
		  
	  } // end method compute_letter
	  
	  
	  /** binary_to_decimal methodu 1 adet string parametreyi girdi olarak alir. Bu string
	   * parametre '.' ve '-' lerden olusur. Her '.' 1 sayisini ve her '-' 0 sayisini temsil
	   * ederek bir binary degere karsilik gelir. Method bu binary degeri ondalik olarak hesaplayip
	   * dondurur. Ekrana herhangi bir cikti vermez. 
	   */
	  	  
	  public static int binary_to_decimal(String val) {
		  	  
		  char[] pointArray = new char[val.length()]; // string degerinin char tipinde bir arraye cevirmek icin bos bir array olusturuyoruz
		  	       	  
	        for (int i = 0; i < val.length(); i++) { // her bir karakteri pointArray'e kopyaliyoruz
	        	
	            pointArray[i] = val.charAt(i);
	            
	        } // end for
	        
	        int[] binArray = new int[pointArray.length]; // nokta ve cizgilerden olusan arrayimizi 1 ve 0 lardan olusan arraye ceviriyoruz
	        
	        for (int i = 0; i < pointArray.length; i++) {
	        	
	        	if (pointArray[i] == '.') {
	        		
	        		binArray[i] = 1;
	        		
	        	} else if (pointArray[i] == '-') {
	        		
	        		binArray[i] = 0;
	        			        		
	        	} // end if
	        	
	        } // end for
	        
	        StringBuilder strNum = new StringBuilder(); 

	        for (int bin : binArray){
	        	
	             strNum.append(bin);
	             
	        } // end for
	        
	        int intBin = Integer.parseInt(strNum.toString()); // stringe cevirdigimiz arrayi integer olarak parse ediyoruz
	        
	        int decValue = 0;	        
		    int base = 1;	 		    
	        int temp = intBin;
	        
	        while (temp > 0) {
	        	
	            int last_digit = temp % 10; // son rakami alabilmek icin modulo 10 yapiyoruz	            
	            temp /= 10; // temp degerinin son digitini atiyoruz	 
	            decValue += last_digit * base; // base ile last digiti carpıyoruz ve her seferinde dec_value uzerine ekliyoruz	 
	            base = base * 2; // her bir sonraki rakama gectiginde 2'nin kuvvetlerini arttiriyoruz
	            
	        } // end while
	 
	        return decValue; 
		  			  		  
	  } // end method binary_to_decimal
	  
	  
	  public static void main(String[] args) {
		  
		  String letter;
		  letter = compute_letter(50, 60, 100, 70);
		  System.out.println("Emre'nin final notu: " + letter);
		 
		 		 		    		  
	  } // end method main
	  	  
	  
} // end class homework1
	

