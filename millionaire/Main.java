package millionaire;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Random;


public class Main {

	
	/* Milyoner yarismasi icin daha onceden cikmis sorularin oldugu bir sorular.txt dosyasi olustrudum. Bu dosyada her bir satirda sirasiyla
	 * sorunun daha onceden kacinci soru olarak soruldugu, sorunun kendisi, sorunun a secenegi, b secenegi, c secenegi, d secenegi, dogru secenegi
	 * bulunmakta. Bunlari txt dosyasina kaydederken tab ile ayirdim. Simdi bu dosyayi satir satir okutmak icin BufferedReader kullanacagiz.
	 * Dosyadaki her bir satiri bir arrayliste aktaracagiz. 
	 * 
	 */
		
		public static void main(String args[]) throws FileNotFoundException, IOException {
			
			ArrayList<String> arrayList = new ArrayList<>(); // dosyayi okutacagimiz arrayList

			try (BufferedReader br = new BufferedReader(new FileReader("sorular.txt"))) { // dosyayi arrayliste okutuyoruz
			    while (br.ready()) {
			        arrayList.add(br.readLine());
			        
			    } // end while

			} catch (Exception e) {
				
				System.out.println("Dosya okunamadi...");
			} // end try catch
			
			/* Sorulari satir satir okuttuk. Ama her bir satir bir string oldugu icin elemanlara ayri ayri erisim saglamamiz gerekiyor.
			 * Bunu saglamak icin tablarla ayirdigimiz elemanlari 2 boyutlu bir string arraye kopyaliyoruz.
			 */
			
			
			String[][] inPut = new String[arrayList.size()][7]; // arraylListi aktaracagimiz 2D String array
			
			for (int i = 0; i < arrayList.size(); i++) { // arraylisti 2D string arraye aktariyoruz
				String [] str1 = arrayList.get(i).split("\t");
				for(int j = 0; j < str1.length; j++) {
					inPut[i][j] = str1[j];				
				} // end for 2
				
			} // end for 1			
			
			
			/* String arraydeki sorularimizi ayri ayri obje arraylerine almak icin 13 tane arraylist olusturacagiz. Her bir soru gurubu icin
			 * bir arraylist olacak. Yani daha onceden 1. soru olarak sorulmus sorular ayri, 2 ler ayri .... 12ler ayri sekilde tutulacak. Bunu
			 * yarismanin giderek zorlasmasi icin yapiyoruz. Cunku yarisma sirasinda her bir soru icin ilgili arraylistten random secim yapýp ona gore
			 * soru getirecegiz. Bu sekilde oyun her seferinde farklý senaryo sunacak. 13. arraylist ise tum soru arraylistlerini bir arada tutacagimiz ayri
			 * bir arraylist olacak.  
			 */
			
			// arraylistler icin data fields
			
			ArrayList<Question> q1List = new ArrayList<Question>(); // 1. sorular icin arraylist
			ArrayList<Question> q2List = new ArrayList<Question>(); // 2. sorular icin arraylist
			ArrayList<Question> q3List = new ArrayList<Question>(); // 3. sorular icin arraylist
			ArrayList<Question> q4List = new ArrayList<Question>(); // 4. sorular icin arraylist
			ArrayList<Question> q5List = new ArrayList<Question>(); // 5. sorular icin arraylist
			ArrayList<Question> q6List = new ArrayList<Question>(); // 6. sorular icin arraylist
			ArrayList<Question> q7List = new ArrayList<Question>(); // 7. sorular icin arraylist
			ArrayList<Question> q8List = new ArrayList<Question>(); // 8. sorular icin arraylist
			ArrayList<Question> q9List = new ArrayList<Question>(); // 9. sorular icin arraylist
			ArrayList<Question> q10List = new ArrayList<Question>(); // 10. sorular icin arraylist
			ArrayList<Question> q11List = new ArrayList<Question>(); // 11. sorular icin arraylist
			ArrayList<Question> q12List = new ArrayList<Question>(); // 12. sorular icin arraylist
			ArrayList<ArrayList<Question>> questionList = new ArrayList<ArrayList<Question>>(); // soru arraylistlerini kapsayacak arraylist
			
			
			/* String arrayin 0. kolunundaki elemanlari kontrol ederek soru grubuna gore her bir dongude yeni bir Ouestion objesi olusturuyoruz.
			 * Bu objeleri de tek tek ilgili arrayliste kaydediyoruz. 
			 */
			
			for (int i = 0; i < inPut.length; i++) {
						
					if (inPut[i][0].equals("1")) {
						
						q1List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} else if (inPut[i][0].equals("2")) {
						
						q2List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} else if (inPut[i][0].equals("3")) {
						
						q3List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} else if (inPut[i][0].equals("4")) {
						
						q4List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} else if (inPut[i][0].equals("5")) {
						
						q5List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} else if (inPut[i][0].equals("6")) {
						
						q6List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} else if (inPut[i][0].equals("7")) {
						
						q7List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} else if (inPut[i][0].equals("8")) {
						
						q8List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} else if (inPut[i][0].equals("9")) {
						
						q9List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} else if (inPut[i][0].equals("10")) {
						
						q10List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} else if (inPut[i][0].equals("11")) {
						
						q11List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} else if (inPut[i][0].equals("12")) {
						
						q12List.add(new Question(inPut[i][0], inPut[i][1], inPut[i][2], inPut[i][3], inPut[i][4], inPut[i][5], inPut[i][6]));
						
					} // end if
					
			} // end for
			
			// Olusturdugumuz soru listelerinin eksik olan kazanilan para kismini ekliyoruz.
			
			
			for (Question question : q1List) {
				
				question.setMoney(500);
				
			} // end q1 for
			
			for (Question question : q2List) {
				
				question.setMoney(1000);
				
			} // end q2 for
			
			for (Question question : q3List) {
				
				question.setMoney(2000);
				
			} // end q3 for
			
			for (Question question : q4List) {
				
				question.setMoney(3000);
				
			} // end q4 for
			
			for (Question question : q5List) {
				
				question.setMoney(5000);
				
			} // end q5 for
			
			for (Question question : q6List) {
				
				question.setMoney(7500);
				
			} // end q6 for
			
			for (Question question : q7List) {
				
				question.setMoney(15000);
				
			} // end q7 for
			
			for (Question question : q8List) {
				
				question.setMoney(30000);
				
			} // end q8 for
			
			for (Question question : q9List) {
				
				question.setMoney(60000);
				
			} // end q9 for
			
			for (Question question : q10List) {
				
				question.setMoney(125000);
				
			} // end q10 for
			
			for (Question question : q11List) {
				
				question.setMoney(250000);
				
			} // end q11 for
			
			for (Question question : q12List) {
				
				question.setMoney(1000000);
				
			} // end q12 for
			
			// Son olarak ayri ayri olusturdugumuz soru arraylistlerini buyuk bir arraylistte topluyoruz.
			
			questionList.add(q1List);
			questionList.add(q2List);
			questionList.add(q3List);
			questionList.add(q4List);
			questionList.add(q5List);
			questionList.add(q6List);
			questionList.add(q7List);
			questionList.add(q8List);
			questionList.add(q9List);
			questionList.add(q10List);
			questionList.add(q11List);
			questionList.add(q12List);
			
			// Buradan sonra artik oyuna basliyoruz
			
			/* Oyun ilk olarak bilgilendirme mesajlari ile baslayacak. Bu sirada bazi inputlar ile oyuna hazirlik yapacagiz.
			 */
			
			
			Scanner keyboard = new Scanner(System.in); // kullanicidan input almak icin bir Scanner nesnesi olusturuyoruz.
			
			System.out.println();
			System.out.println();
			System.out.println("***         ***  **  **      **      **  *********  ***    **  ********  ********* ");
			System.out.println("** **     ** **  **  **        **  **    **     **  ** **  **  **        **     ** ");
			System.out.println("**  **   **  **  **  **          **      **     **  **  ** **  ********  ********* ");
			System.out.println("**   ** **   **  **  **          **      **     **  **   ****  **        **    **  ");
			System.out.println("**    ***    **  **  ********    **      *********  **    ***  ********  **     **");
			
			System.out.println();
			System.out.println();
		
			System.out.println("Kim Milyoner Olmak Ister'e hos geldin! \n");
			
			System.out.println("Oyuna baslamak icin lutfen enter'a bas...");
			
			try{System.in.read();}
			        catch(Exception e){}
								
			System.out.println();
			
			System.out.print("Lutfen ismini gir:");
			
			String userNameInput = keyboard.next(); // kullancinin ismini girdi aliyoruz
			
			User user1 = new User(userNameInput); // kullanicinin ismi ile yeni bir User objesi tanimliyoruz.
			
			System.out.println();
			System.out.println("Merhaba " + user1.getUserName() + " :)\n");
			
			System.out.println("Oyun oncesi bilgilendirme almak icin <b>'ye, hemen oyuna baþlamak icin ise <o>'ya bas.");
			
			String info = keyboard.next();
			char infoChar = info.charAt(0);
			
			if (infoChar == 'b') {
			
			System.out.println("Oyun toplam 12 sorudan olusmakta. Bu sorulari cevaplandirip belirli oranlarda para odulu kazanacaksin :)");
			System.out.println();
			System.out.println("Ýlk 7 soru icin 45 saniye zamanin olacak. Bu 45 saniye sorunun altinda bir bar halinde ilerleyecek.");
			System.out.println("Eger 45 saniye icinde soruya cevap vermezsen yarismadan eleneceksin...");
			System.out.println("7. sorudan sonraki sorular icin zaman kisitin olmayacak.");
			System.out.println();
			System.out.println("Her bir soru icin kazanabilecegin para odullerini gormek icin d yazip enter'a bas.");
			System.out.println();
			
			String null2 = keyboard.next(); // Bu input aslinda bir ise yaramiyor. Mesajlar arasi akisi kullanicinin yonetebilmesi icin koyulmus bos bir input.
			
			System.out.println(" ------------------------ ");
			System.out.println("| 12. Soru   1.000.000 TL |");
			System.out.println("| 11. Soru     250.000 TL |");
			System.out.println("| 10. Soru     125.000 TL |");
			System.out.println("| 9. Soru       60.000 TL |");
			System.out.println("| 8. Soru       30.000 TL |");
			System.out.println("| 7. Soru       15.000 TL |");
			System.out.println("| 6. Soru        7.500 TL |");
			System.out.println("| 5. Soru        5.000 TL |");
			System.out.println("| 4. Soru        3.000 TL |");
			System.out.println("| 3. Soru        2.000 TL |");
			System.out.println("| 2. Soru        1.000 TL |");
			System.out.println("| 1. Soru          500 TL |");
			System.out.println(" ------------------------ ");
			System.out.println();
			
			System.out.println("Bu sorulardan 2. soru ve 7. soru baraj sorusu.");
			System.out.println("Yani 2. soruyu gectiginde 1.000 TL, 7. soruyu gectiginde ise 15.000 TL kazanci garantilemis oluyorsun.");
			System.out.println();
			System.out.println("Eger bu sorular haricindeki bir soruda yanlis cevap verirsen en yakin alt barajdaki para odulunu kazanmis oluyorsun.");
			System.out.println("Ya da bilemedigin soruda yarismadan cekilip bir onceki bildigin sorunun para odulune sahip olabilirsin :) (Devam etmek icin d + enter)");
			
			String null3 = keyboard.next(); // Bu input aslinda bir ise yaramiyor. Mesajlar arasi akisi kullanicinin yonetebilmesi icin koyulmus bos bir input.
			
			System.out.println();
			System.out.println("Yarismada kullanabilecegin toplam 4 tane joker hakkin bulunmakta.\nBu jokerlerin 3 tanesi yarismaya basladigin anda kullanilabilir olacak.");
			System.out.println();
			System.out.println("Bunlar:");
			System.out.println();
			System.out.println(" -------------------------");
			System.out.println("| 1. Telefon Jokeri       |");
			System.out.println("| 2. 50:50 Jokeri         |");
			System.out.println("| 3. Seyirciye Sor Jokeri |");
			System.out.println(" -------------------------");
			System.out.println();
			System.out.println("4. Joker ise 7. soruyu gectikten sonra acilacak. 4. jokeri gormek icin d + enter:");
			
			String null4 = keyboard.next(); // Bu input aslinda bir ise yaramiyor. Mesajlar arasi akisi kullanicinin yonetebilmesi icin koyulmus bos bir input.
			
			System.out.println();
			System.out.println(" ----------------------");
			System.out.println("| 4. Cift Cevap Jokeri |");
			System.out.println(" ----------------------");
			System.out.println();
			System.out.println("Bu jokerlerin ne ise yaradigini kisaca aciklayayim.");
			System.out.println();
			System.out.println("Telefon jokerini 3 arkadasindan birini arayip soruyu tartisman icin kullanabilirsin. Birazdan bu arkadaslarinin bilgilerini senden alacagim. ");
			System.out.println();
			System.out.println("50:50 jokerini kullandidigin zaman yanlis olan 2 secenek elenecek. Kalan 2 secenek arasindan secim yapacaksin.");
			System.out.println();
			System.out.println("Seyirciye sor jokerinde seyircilerimiz soruyu senin icin cevaplayacak, her bir secenek icin belirli bir yuzde olusacak.");
			System.out.println();
			System.out.println("Son jokerimiz olan Cift Cevap jokerini kullandigin zaman ise o soru icin 2 kere cevap verme hakkina sahip olacaksin.");
			System.out.println("Ama dikkat etmen gereken bir nokta var. Eger Cift Cevap jokerini kullanirsan o soruda yarismadan cekilme hakkin olmayacak.");
			System.out.println();
			
			System.out.println("Bilgilendirmemiz bu kadar :) Hazirsan oyuna baslayalim. Baslamak icin d + enter.");
			
			String null5 = keyboard.next(); // Bu input aslinda bir ise yaramiyor. Mesajlar arasi akisi kullanicinin yonetebilmesi icin koyulmus bos bir input.
			
			} // end info char
			
			System.out.println();
			
			System.out.println("O zaman oyuna basliyoruz :) Telefon jokerin icin aramak istedigin 3 arkadasinin ismini gir lutfen :)");
			
			String friend1 = keyboard.next(); // kullanicidan 1. telefon jokeri arkadasi ismi aliyoruz.
			String friend2 = keyboard.next(); // kullanicidan 2. telefon jokeri arkadasi ismi aliyoruz.
			String friend3 = keyboard.next(); // kullanicidan 3. telefon jokeri arkadasi ismi aliyoruz.
			
			PhoneJoker phoneJoker = new PhoneJoker(friend1, friend2, friend3, 1); // kullancidan aldigimiz inputlar ile telefon jokeri nesnesi olusturuyoruz.
			FiftyFifty fiftyFiftyJoker = new FiftyFifty(1); // 50:50 jokeri nesnesi olusturuyoruz
			Spectator spectatorJoker = new Spectator(1); // Seyirciye Sor jokeri nesnesi olusturuyoruz.
			DoubleAnswer doubleAnswerJoker = new DoubleAnswer(0); // Cift cevap jokeri nesnesi olusturuyoruz.
			
			// Burada Cift Cevap 0 digerleri 1 ile olusturuldu. Cunku cift cevap jokeri 7. sorudan sonra hak ediliyor. Onu o zaman 1 yapacagiz.
			
			user1.setPhoneJoker(phoneJoker); // User objesine telefon jokeri tanimliyoruz.
			user1.setFiftyFiftyJoker(fiftyFiftyJoker); // User objesine 50:50 jokeri tanimliyoruz.
			user1.setExpertJoker(spectatorJoker); // User objesine Seyirciye Sor jokeri tanimliyoruz.
			user1.setDoubleAnswerJoker(doubleAnswerJoker); // Cift cevap jokeri nesnesi olusturuyoruz.
			
			System.out.println("Tamamdir. Arkadaslarini kaydettim. Joker kullanmak istediginde hangi arkadasini aramak istedigini soracagim.");
			
			
			System.out.println();
			
			System.out.println("Eger hazirsan ilk soruyla baslayalim. Hazir oldugunda d + enter'a bas.");
			
			String null6= keyboard.next(); // yine ise yaramayan input
			
			
			/* Yarisma burada basliyor. Yarismayi 12 adim donen bir for dongusu ile yapacagiz. Ayni zamanda bir de flag tanimlayarak
			 * bazi durumlarda yarismanin sonlanabilmesi icin o flag ile donguyu sonlandiracagiz. Her bir dongude ilgili soru arraylistinie ulasip
			 * oradan rastgele bir soru getirecek ve bu soruyu kullaniciya soracak. Kullanicinin inputlari ile yarisma sekillenecek. Ve son olarak
			 * yarismanin bittigi durumda kullanciya kazandigi parayi bildirip donguyu sonlandiracak.
			 * 
			 */
			
			Random rnd = new Random(); // soru arraylistlerimizden random soru secebilmek icin bir Random nesnesi olusturuyoruz.
						
			boolean flag = true; // for dongusunden gerekli oldugu durumlarda cikabilmek icin bir degisken
			
						
			for (int i = 0; flag == true && i < 12; i++ ) {
				
				boolean timerFlag = true; // zamanlayiciyi durdurabilmek icin bir degisken
				
				if (i == 2) { // 2. soru yani 1. baraj sorusu dogru olduktan sonra kazanilan parayi sabitleyen ve kullaniciya bildiren kisim
					
					user1.setWinMoney(user1.getTempMoney()); // kullanicinin kazandigi parayi baraj degerine sabitliyor
					
					System.out.println("Tebrikler! 1. baraj sorusunu gectigin icin 1.000 TL odulu garantilemis oldun!");
					System.out.println();	
					
				} // end if 2
				
				
				
				if (i == 7) { // 7. soru yani 2. baraj sorusu dogru cevaplandiktan sonra kullanicini parasini baraja sabitleyen kisim
					
					user1.getDoubleAnswerJoker().setJokerRight(1); // Kullaniciya Cifte Cevap jokeri tanimliyoruz
					
					System.out.println("Tebrikler! 7. soruyu tamamladigin icin artik Cift Cevap jokerini kullanabilirsin!");
					System.out.println();
					
					user1.setWinMoney(user1.getTempMoney()); // kullanicinin kazandigi parayi baraj degerine sabitliyor
					
					System.out.println("Ayný zamanda 2. baraj sorusunu da gectigin icin 15.000 TL odulu garantilemis oldun!");
					System.out.println();
					
					System.out.println("Artýk sorularda 45 saniye zaman kisitin olmayacak, istedigin kadar dusunebilirsin :)");
					System.out.println();
					
				} // end if 7
				
									
				System.out.println("Soruyu gormek icin lutfen d + enter'a bas. (Yarismadan cekilmek icin x'e bas.)");
				
				String null7 = keyboard.next(); // kullanicidan yarismaya baslamak icin input aliyoruz
				char null8 = null7.toLowerCase().charAt(0); // alinan inputun ilk harfi(kelime yazilmasi durumunu engellemek icin)
				
				if (null8 == 'x') { // eger kullanici yarismadan cikmak isterse
					
					user1.setWinMoney(user1.getTempMoney()); // o ana kadarki kazandigi parayi kazanilana sabitliyoruz 
					System.out.println("----------------------------------------------------------------------------------------------------------------");
					System.out.println("Sevgili " + user1.getUserName() + ", seni yarismadan " + user1.getWinMoney() + " TL ile ugurluyoruz. Hoscakal.");
					System.out.println("----------------------------------------------------------------------------------------------------------------");
					flag = false; // donguden cikiyoruz
					
				} else { // kullanici yarismaya devam ederse (d degeri yazdim ama herhangi bir deger ile devam edebilecek)
					
					
															
					int r = rnd.nextInt(questionList.get(i).size()); // soru grubunun buyuklugu kadar bir random sayi uretiyor
					String tempAnswer = null;
					
					System.out.println((i+1) + ". sorumuz geliyor.");
					System.out.println();
					System.out.println("-------------------------------------------------------------------------------------------------------------------------");
					System.out.println(questionList.get(i).get(r)); // urettigi random deger ile soru listesinden bir soru secip bastiriyor
					System.out.println("-------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					
					// Joker haklari oldugu durumda joker kullanabildigine dair bildirim
					if (user1.getPhoneJoker().getJokerRight() == 1 || user1.getFiftyFiftyJoker().getJokerRight() == 1 || user1.getSpectatorJoker().getJokerRight() == 1 || user1.getDoubleAnswerJoker().getJokerRight() == 1) { 
						
						System.out.print("Cevabýn (Eger joker kullanmak istiyorsan j'ye, yarismadan cekilmek istiyorsan x'e bas):");
						System.out.println();
						
					} else { // Joker hakki bitince joker kullanmasin diye farkli bir bildirim
						
						System.out.print("Cevabýn (Eger yarismadan cekilmek istiyorsan x'e bas):");
						System.out.println();
						
					}
					
					int timeCounter = 1; // 1. saniyeden basliyor
					
					if ( i <= 6) { // ilk 7 sorudaki zamanlayici
								
						
						long lastSec = 0;
						while (timerFlag && System.in.available() == 0) { // sistemden bir girdi alana kadar ve timerFlag true iken calisacak
							
						    long sec = System.currentTimeMillis() / 1000; // o anki sistem saniyesi
						    
						    if (sec != lastSec) { 
						    	
						       System.out.print("*"); // yan yana yildizlar yaziyoruz
						       timeCounter++; // saniye sayaci
						       lastSec = sec;
						       
						    } // end if
						    
						       
						     if (timeCounter == 45) { // 45 saniye dolunca
							    	
							    System.out.println();
							    System.out.println("----------------------------------------------------------------------------------------------------------------");
							    System.out.println("Uzgunum, sorunun suresi doldu :(");
							    System.out.println("Sevgili " + user1.getUserName() + ", seni yarismadan " + user1.getWinMoney() + " TL ile ugurluyoruz. Hoscakal.");
							    System.out.println("----------------------------------------------------------------------------------------------------------------");
							    timerFlag = false; // zamanlayici duruyor
							    flag = false; // tum yarismadan cikiyoruz					    
						    
						    } // end if  						       
						      						       
						}// end while
						
						
					} // end if
					
										
					String answerInput = keyboard.next(); // kullanicidan sorunun cevabini aliyoruz
					char answer = answerInput.toLowerCase().charAt(0); // kelime girerse ilk harfi aliyoruz
					
					
					
					if (answer == 'j') { // eger kullanici joker kullanmak isterse
						
						boolean jokerFlag = true; // joker dongusunden cikabilmek icin bir flag tanimliyoruz
						
						while (jokerFlag) {
						
							user1.getJokers(); // kullanicinin jokerlerini ekrana basiyoruz
						
							System.out.println();
						
							System.out.println("Hangi jokerini kullanmak istiyorsun? Lutfen numarasini gir: (Joker menusunden cikmak icin 0 a bas.)");
						
							int jokerNumber = keyboard.nextInt(); // kullanici joker secimini yapiyor
						
							if (jokerNumber == 1 && user1.getPhoneJoker().getJokerRight() == 1) { // telefon jokeri secerse
							
								user1.getPhoneJokerString(); // telefon jokerinde kimi aramak istedigini soruyoruz
							
								int phoneJokerNumber = keyboard.nextInt(); // kisiyi secmek icin input aliyoruz
							
								if (phoneJokerNumber == 1) // 1. arkadas
									System.out.println(user1.getPhoneJoker().getFriend1() + " araniyor...");
								else if (phoneJokerNumber == 2) // 2.arkadas
									System.out.println(user1.getPhoneJoker().getFriend2() + " araniyor...");
								else if (phoneJokerNumber == 2) // 3.arkadas
									System.out.println(user1.getPhoneJoker().getFriend3() + " araniyor...");
							
								System.out.println(user1.getPhoneJoker().printRightAnswer(questionList.get(i).get(r))); // soru icin telefon jokeri methodunu calistiriyoruz
								System.out.println();
							
								if (user1.getFiftyFiftyJoker().getJokerRight() == 1 || user1.getSpectatorJoker().getJokerRight() == 1 || user1.getDoubleAnswerJoker().getJokerRight() == 1) { 
									
									System.out.print("Cevabýn (Eger yeniden joker kullanmak istiyorsan j'ye, yarismadan cekilmek istiyorsan x'e bas):");
									System.out.println();
									
								} else { // Joker hakki bitince joker kullanmasin diye farkli bir bildirim
									
									System.out.print("Cevabýn (Eger yarismadan cekilmek istiyorsan x'e bas):");
									System.out.println();
									
								} // end if
								
								// zaman kisiti olan sorularda joker kullanildiktan sonra saniye ilerlemeye devam ediyor
								
								if ( i <= 6) { // ilk 7 sorudaki zamanlayici
																
									long lastSec = 0;
									while (timerFlag && System.in.available() == 0) { // sistemden bir girdi alana kadar ve timerFlag true iken calisacak
										
									    long sec = System.currentTimeMillis() / 1000; // o anki sistem saniyesi
									    
									    if (sec != lastSec) { 
									    	
									       System.out.print("*"); // yan yana yildizlar yaziyoruz
									       timeCounter++; // saniye sayaci
									       lastSec = sec;
									       
									    } // end if
									    
									       
									     if (timeCounter == 45) { // 45 saniye dolunca
										    	
										    System.out.println();
										    System.out.println("----------------------------------------------------------------------------------------------------------------");
										    System.out.println("Uzgunum, sorunun suresi doldu :(");
										    System.out.println("Sevgili " + user1.getUserName() + ", seni yarismadan " + user1.getWinMoney() + " TL ile ugurluyoruz. Hoscakal.");
										    System.out.println("----------------------------------------------------------------------------------------------------------------");
										    timerFlag = false; // zamanlayici duruyor
										    flag = false; // tum yarismadan cikiyoruz					    
									    
									    } // end if  						       
									      						       
									}// end while
									
									
								} // end if
								
								answerInput = keyboard.next(); // cevabi aliyoruz
								answer = answerInput.toLowerCase().charAt(0);
								
								if (answer == 'j') { // eger tekrar joker kullanmak istiyorsa
									
									user1.getPhoneJoker().setJokerRight(0); // telefon jokeri hakkini sifirliyoruz
									jokerFlag = true; // dongu tekrar donuyor
									
								} else if  (answer == 'x') { // yarismadan cekilmek istiyorsa

									jokerFlag = false; // joker dongusunden cik
									
									
								} else { // cevabi girmesi durumunda 
										
									user1.getPhoneJoker().setJokerRight(0); // telefon jokeri hakki sifirlaniyor
									jokerFlag = false; // joker dongusunden cikiyor
										
								} // end answer if
					
						
							} else if (jokerNumber == 2 && user1.getFiftyFiftyJoker().getJokerRight() == 1) { // 50:50 Jokerini kullanmak istemesi durumunda
								
								System.out.println("Yanlis olan iki secenegi eliyorum...");
								
								System.out.println();
								
								System.out.println(user1.getFiftyFiftyJoker().printRightAnswer(questionList.get(i).get(r))); // 50:50 jokeri kullaniyoruz
								System.out.println();
								
								if (user1.getPhoneJoker().getJokerRight() == 1 || user1.getSpectatorJoker().getJokerRight() == 1 || user1.getDoubleAnswerJoker().getJokerRight() == 1) { 
									
									System.out.print("Cevabýn (Eger yeniden joker kullanmak istiyorsan j'ye, yarismadan cekilmek istiyorsan x'e bas):");
									System.out.println();
									
								} else { // Joker hakki bitince joker kullanmasin diye farkli bir bildirim
									
									System.out.print("Cevabýn (Eger yarismadan cekilmek istiyorsan x'e bas):");
									System.out.println();
									
								} // end if
								
								// zaman kisiti olan sorularda joker kullanildiktan sonra saniye ilerlemeye devam ediyor
								
								if ( i <= 6) { // ilk 7 sorudaki zamanlayici
									
									long lastSec = 0;
									while (timerFlag && System.in.available() == 0) { // sistemden bir girdi alana kadar ve timerFlag true iken calisacak
										
									    long sec = System.currentTimeMillis() / 1000; // o anki sistem saniyesi
									    
									    if (sec != lastSec) { 
									    	
									       System.out.print("*"); // yan yana yildizlar yaziyoruz
									       timeCounter++; // saniye sayaci
									       lastSec = sec;
									       
									    } // end if
									    
									       
									     if (timeCounter == 45) { // 45 saniye dolunca
										    	
										    System.out.println();
										    System.out.println("----------------------------------------------------------------------------------------------------------------");
										    System.out.println("Uzgunum, sorunun suresi doldu :(");
										    System.out.println("Sevgili " + user1.getUserName() + ", seni yarismadan " + user1.getWinMoney() + " TL ile ugurluyoruz. Hoscakal.");
										    System.out.println("----------------------------------------------------------------------------------------------------------------");
										    timerFlag = false; // zamanlayici duruyor
										    flag = false; // tum yarismadan cikiyoruz					    
									    
									    } // end if  						       
									      						       
									}// end while
									
									
								} // end if
								
								answerInput = keyboard.next(); // Cevabi aliyoruz
								answer = answerInput.toLowerCase().charAt(0);
								
								if (answer == 'j') { // tekrar joker kullanmak isterse
									
									user1.getFiftyFiftyJoker().setJokerRight(0); // 50:50 jokeri hakkini sifirliyoruz
									jokerFlag = true; // joker dongusu devam ediyor
									
								} else if  (answer == 'x') { // yarismadan cekilmek isterse
									

									jokerFlag = false; // joker dongusunden cik
									
									
								} else { // cevap verdigi durumda
										
									user1.getFiftyFiftyJoker().setJokerRight(0); // joker hakkini sifirliyoruz
									jokerFlag = false; // joker dongusunden cik
										
								} // end answer if
								
							} else if (jokerNumber == 3 && user1.getSpectatorJoker().getJokerRight() == 1) { // Seyirciye sor jokeri secilirse
								
								System.out.println("Simdi seyircilerimize soruyu soruyoruz... ");
								System.out.println();
								System.out.println("Seyirciler soruyu cevapliyor...");
								System.out.println();
								
								System.out.println(user1.getSpectatorJoker().printRightAnswer(questionList.get(i).get(r))); // Seyirciye sor jokerini calistiriyoruz
								System.out.println();
								
								if (user1.getPhoneJoker().getJokerRight() == 1 || user1.getFiftyFiftyJoker().getJokerRight() == 1 || user1.getDoubleAnswerJoker().getJokerRight() == 1) { 
									
									System.out.print("Cevabýn (Eger joker kullanmak istiyorsan j'ye, yarismadan cekilmek istiyorsan x'e bas):");
									System.out.println();
									
								} else { // Joker hakki bitince joker kullanmasin diye farkli bir bildirim
									
									System.out.print("Cevabýn (Eger yarismadan cekilmek istiyorsan x'e bas):");
									System.out.println();
									
								} // end if
								
								// zaman kisiti olan sorularda joker kullanildiktan sonra saniye ilerlemeye devam ediyor
								
								if ( i <= 6) { // ilk 7 sorudaki zamanlayici
									
									long lastSec = 0;
									while (timerFlag && System.in.available() == 0) { // sistemden bir girdi alana kadar ve timerFlag true iken calisacak
										
									    long sec = System.currentTimeMillis() / 1000; // o anki sistem saniyesi
									    
									    if (sec != lastSec) { 
									    	
									       System.out.print("*"); // yan yana yildizlar yaziyoruz
									       timeCounter++; // saniye sayaci
									       lastSec = sec;
									       
									    } // end if
									    
									       
									     if (timeCounter == 45) { // 45 saniye dolunca
										    	
										    System.out.println();
										    System.out.println("----------------------------------------------------------------------------------------------------------------");
										    System.out.println("Uzgunum, sorunun suresi doldu :(");
										    System.out.println("Sevgili " + user1.getUserName() + ", seni yarismadan " + user1.getWinMoney() + " TL ile ugurluyoruz. Hoscakal.");
										    System.out.println("----------------------------------------------------------------------------------------------------------------");
										    timerFlag = false; // zamanlayici duruyor
										    flag = false; // tum yarismadan cikiyoruz					    
									    
									    } // end if  						       
									      						       
									}// end while
									
									
								} // end if
								
								answerInput = keyboard.next(); // Cevabi aliyoruz
								answer = answerInput.toLowerCase().charAt(0);
								
								if (answer == 'j') { // Bir daha joker kullanilmak istenirse
									
									user1.getSpectatorJoker().setJokerRight(0); // Seyirciye sor joker hakkini sifirliyoruz
									jokerFlag = true; // Joker dongusu devam ediyor
									
								} else if  (answer == 'x') { // yarismadan cekilirse
									
									jokerFlag = false; // joker dongusunden cikiyoruz
								
								} else { // cevabi verirse
										
									user1.getSpectatorJoker().setJokerRight(0); // Seyirciye sor joker hakkini sifirliyoruz
									jokerFlag = false; // joker dongusunden cikiyoruz
										
								} // end answer if
															
																
								
							} else if (jokerNumber == 4 && user1.getDoubleAnswerJoker().getJokerRight() == 1) { // Cift cevap jokerini kullanmak isterse
								
								System.out.println("Cift cevap joker hakkini kullanmayi sectin...");
								System.out.println();
								System.out.println("Lutfen ilk cevabini gir:");
								System.out.println();
								String answerString = null;
								answerString = user1.getDoubleAnswerJoker().printRightAnswer(questionList.get(i).get(r));
								answer = answerString.charAt(0);
								
								user1.getDoubleAnswerJoker().setJokerRight(0); // Joker hakkini sifirliyoruz				
								jokerFlag = false; // joker dongusunden cikmasi icin
								
								
							} else if (jokerNumber == 0) {
								
								System.out.println();
								System.out.println("Cevabýn:");
;								answerInput = keyboard.next(); // kullanicidan sorunun cevabini aliyoruz
								answer = answerInput.toLowerCase().charAt(0);
															
								jokerFlag = false;
								
								
							} else {
								
								System.out.println();
								System.out.println("Sectiginiz joker hakkiniz bulunmamaktadir. Lutfen tekrar deneyiniz.");
								System.out.println();
								jokerFlag = true;
								
								
							} // end joker if		
												
						} // end joker while
						
					} //end joker if
					
											
						if (answer == 'a' || answer == 'b' || answer == 'c' || answer == 'd') { // gecerli cevaplardan biriyse
					
							if (answer == 'a') // eger a secenegi secilmisse
								tempAnswer = questionList.get(i).get(r).getAnswerA();
							else if (answer == 'b') // eger b secenegi secilmisse
								tempAnswer = questionList.get(i).get(r).getAnswerB();
							else if (answer == 'c') // eger c secenegi secilmisse
								tempAnswer = questionList.get(i).get(r).getAnswerC();
							else if (answer == 'd') // eger d secenegi secilmisse
								tempAnswer = questionList.get(i).get(r).getAnswerD();
					
							if (tempAnswer.equals(questionList.get(i).get(r).getRightAnswer())){ // eger secilen cevap dogruysa
								System.out.println(" ------------------------------------------------------------------------------------");
								System.out.println("|                                                                                     |");
								System.out.println("      Tebrikler " + user1.getUserName() + " soruyu dogru cevapladin, " + questionList.get(i).get(r).getMoney() + " TL odul kazandin!");
								System.out.println("|                                                                                     |");
								System.out.println(" ------------------------------------------------------------------------------------");
								System.out.println();
								user1.setTempMoney(questionList.get(i).get(r).getMoney()); // yarismacinin gecici tuttugumuz parasini odule esitliyoruz
						
							} else { // eger yanlis cevap verilmisse
								System.out.println("----------------------------------------------------------------------------------------------------------------");
								System.out.println("Uzgunum " + user1.getUserName() + " yanlis cevap :( Seni yarismadan " + user1.getWinMoney() + " TL ile ugurluyoruz. Hoscakal.");
								System.out.println("Dogru cevap: " + questionList.get(i).get(r).getRightAnswer() + ".");
								System.out.println("----------------------------------------------------------------------------------------------------------------");
								flag = false;
							} // end if
							
						} else { // eger a b c d harici bir deger girildiyse direkt yarisma bitiyor :)
							
							user1.setWinMoney(user1.getTempMoney());
							System.out.println("----------------------------------------------------------------------------------------------------------------");
							System.out.println("Sevgili " + user1.getUserName() + ", seni yarismadan " + user1.getWinMoney() + " TL ile ugurluyoruz. Hoscakal.");
							System.out.println("Dogru cevap: " + questionList.get(i).get(r).getRightAnswer() + ".");
							System.out.println("----------------------------------------------------------------------------------------------------------------");
							flag = false;
							
						} // end if input x
					
														
				} // end if input x first
				
				user1.setAnsweredQuestions(i);
				
			} // end for
			
						
			keyboard.close(); // klavye acik kalmasin :)
			
			System.out.println();
			System.out.println();
			System.out.println("***         ***  **  **      **      **  *********  ***    **  ********  ********* ");
			System.out.println("** **     ** **  **  **        **  **    **     **  ** **  **  **        **     ** ");
			System.out.println("**  **   **  **  **  **          **      **     **  **  ** **  ********  ********* ");
			System.out.println("**   ** **   **  **  **          **      **     **  **   ****  **        **    **  ");
			System.out.println("**    ***    **  **  ********    **      *********  **    ***  ********  **     **");
			System.out.println();
			
			
			PrintStream output = new PrintStream(new File("yarismaci.txt")); // outputu yarismaci.txt ye yazacak sekilde ayarliyoruz
			  
			System.setOut(output);
			
			System.out.println(user1);
			
					
	} // end method main

} // end class Main
