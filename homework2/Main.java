package homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;


public class Main {

	public static void main(String args[]) throws FileNotFoundException, IOException {
		
		ArrayList<String> arrayList = new ArrayList<>(); // dosyayi okutacagimiz arrayList

		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) { // dosyayi arrayliste okutuyoruz
		    while (br.ready()) {
		        arrayList.add(br.readLine());
		    } // end while

		} // end try
	
		
		String[][] inPut = new String[arrayList.size()][4]; // arraylListi aktaracagimiz 2D String array
		
		for (int i = 0; i < arrayList.size(); i++) { // arraylisti 2D string arraye aktariyoruz
			String [] str1 = arrayList.get(i).split("\t");
			for(int j = 0; j < str1.length; j++) {
				inPut[i][j] = str1[j];				
			} // end for 2
			
		} // end for 1
		
		
		/**
		 * fixtures.txt dosyasýný okuttuktan sonra, 2D arraydeki 1. takim ve 2. takimlarin hepsini ayri ayri 
		 * Futbol, Basketbol ve Voleybol string arraylerine alacagiz. Daha sonra bu string arraylerdeki duplikeleri
		 * ayiklayip ayrý bir arraye duplikesiz halde yazacagiz. Daha sonra bu yeni string arraydeki elemanlari 
		 * objelerin constructorina parametre olarak alýp obje arrayimize objeler halinde kopyalayacagiz.
		 */
		
		// arraylistler icin data fields
		
		ArrayList<String> footballTableTemp = new ArrayList<String>(); // futbol tablosu icin gecici arraylist
		ArrayList<String> basketballTableTemp = new ArrayList<String>(); // basketbol tablosu icin gecici arraylist
		ArrayList<String> volleyballTableTemp = new ArrayList<String>(); // voleybol tablosu icin gecici arraylist
		
		ArrayList<String> footballTable = new ArrayList<String>(); // futbol tablosundaki duplikelerin cikarilmis hali icin arraylist
		ArrayList<String> basketballTable = new ArrayList<String>(); // basketbol tablosundaki duplikelerin cikarilmis hali icin arraylist
		ArrayList<String> volleyballTable = new ArrayList<String>(); // voleybol tablosundaki duplikelerin cikarilmis hali icin arraylist
		
		ArrayList<Football> footballTableFinal = new ArrayList<Football>(); // futbol objelerini aktaracagimiz arraylist
		ArrayList<Basketball> basketballTableFinal = new ArrayList<Basketball>(); // basketbol objelerini aktaracagimiz arraylist
		ArrayList<Volleyball> volleyballTableFinal = new ArrayList<Volleyball>(); // voleybol objelerini aktaracigimiz arraylist
		
		
		// veri dosyasindaki maclari siniflara gore ayirip string arraylere aliyoruz
		
		for(int i = 0; i < inPut.length; i++) {
			
			if (inPut[i][0].equals("F")) { // futbol maclari icin
				
				footballTableTemp.add(inPut[i][1]); // ilk takimi string arraylistimize aliyoruz
				footballTableTemp.add(inPut[i][2]);	// ikinci takimi string arraylistimize aliyoruz	
				
				
			} else if (inPut[i][0].equals("B")) { // basketbol maclari icin
				
				basketballTableTemp.add(inPut[i][1]); // ilk takimi string arraylistimize aliyoruz
				basketballTableTemp.add(inPut[i][2]); // ikinci takimi string arraylistimize aliyoruz	
				
			} else if (inPut[i][0].equals("V")) { // voleybol maclari icin
				
				volleyballTableTemp.add(inPut[i][1]); // ilk takimi string arraylistimize aliyoruz
				volleyballTableTemp.add(inPut[i][2]); // ikinci takimi string arraylistimize aliyoruz
			
			} // end if 
				
			
		} // end for
				

		// futbol duplikelerini cikariyoruz ve diger tabloya aktariyoruz
		
		for (String team : footballTableTemp) {
		
            if (!footballTable.contains(team)) {
  
            	footballTable.add(team);
            } // end if
        } // end for
				
	
		// basketbol duplikelerini cikariyoruz ve diger tabloya aktariyoruz
		
		for (String team : basketballTableTemp) {
			
            if (!basketballTable.contains(team)) {
  
            	basketballTable.add(team);
            } // end if
        } // end for
	
		// voleyboll duplikelerini cikariyoruz ve diger tabloya aktariyoruz
		
		for (String team : volleyballTableTemp) {
			
            if (!volleyballTable.contains(team)) {
  
            	volleyballTable.add(team);
            } // end if
        } // end for
		
				
		// aldigimiz siniflari obje arraylerine kopyaliyoruz.
		
		for (String team : footballTable) { // futbol stringlerini objelerin ismi olacak sekilde obje arrayine aktariyoruz
			
			footballTableFinal.add(new Football(team));		
			
		} // end for
		
		for (String team : basketballTable) { // basketbol stringlerini objelerin ismi olacak sekilde obje arrayine aktariyoruz
			
			basketballTableFinal.add(new Basketball(team));		
			
		} // end for
		
		for (String team : volleyballTable) { // voleybol stringlerini objelerin ismi olacak sekilde obje arrayine aktariyoruz
			
			volleyballTableFinal.add(new Volleyball(team));		
			
		} // end for		
		
		
		/**
		 * Obje arraylistlerimiz futbol, basketbol ve voleybol icin hazir. Simdi girdi aldigimiz fixtures string arrayimize
		 * dongu yazacagiz ve her bir dongude 1. takim ve 2. takimin obje arraylerindeki yerlerini bulup indexlerini tutacagiz.
		 * Daha sonra skor kismini da ayirip 2 ayri skor degiskeninde tutacagiz. Sonra bu indexleri ve skor girdilerini kullanarak
		 * siniflarin icinde ayri ayri tanimlanmis mac yapma methodlarini kullanarak obje arraylistlerimizdeki objelerin data field
		 * kisimlarini güncelleyecegiz. Olusan obje arraylistlerini ayri ayri sort edip sonrasýnda out dosyalarini olusturacagiz.
		 */
		
		int index1 = 0; // arraylistlerde erisim saglayacagimiz 1. takim indexini tutan degisken
		int index2 = 0; // arraylistlerde erisim saglayacagimiz 2. takim indexini tutan degisken
		int tempScore1 = 0; // 1. takim skorunu tutan degisken
		int tempScore2 = 0; // 2. takim skorunu tutan degisken
		String[] tempScore = new String[2]; // Skor kismini : ile ayirip tutacagimiz string arrayi
		
		
		for(int i = 0; i < inPut.length; i++) {
			
			if (inPut[i][0].equals("F")) { // futbol maclari icin
				
				for (Football tempf : footballTableFinal) { // futbol tablosunu geziyoruz
					
					if (tempf.teamName.equals(inPut[i][1])) // 1. takimin objesini bulup indeksini tutuyoruz
						index1 = footballTableFinal.indexOf(tempf);
										
				} // for 1
				
				for (Football tempf : footballTableFinal) { // futbol tablosunu geziyoruz
					
					if (tempf.teamName.equals(inPut[i][2])) // 2. takimin objesini bulup indeksini tutuyoruz
						index2 = footballTableFinal.indexOf(tempf);
						
				} // for 2
				
				tempScore = inPut[i][3].split("\\ : "); // skor kismini ayiriyoruz
				tempScore1 = Integer.parseInt(tempScore[0]);
				tempScore2 = Integer.parseInt(tempScore[1]);
				
				// mac methodunu calistirip data fieldlari guncelliyoruz
				homework2.Football.match(footballTableFinal.get(index1), footballTableFinal.get(index2), tempScore1, tempScore2 );
						
				
			} else if (inPut[i][0].equals("B")) { // basketbol maclari icin
				
				for (Basketball tempf : basketballTableFinal) { //basketbol tablosunu geziyoruz
					
					if (tempf.teamName.equals(inPut[i][1])) // 1. takimin objesini bulup indeksini tutuyoruz
						index1 = basketballTableFinal.indexOf(tempf);
					
				} // for 1
				
				for (Basketball tempf : basketballTableFinal) { //basketbol tablosunu geziyoruz
					
					if (tempf.teamName.equals(inPut[i][2])) // 2. takimin objesini bulup indeksini tutuyoruz
						index2 = basketballTableFinal.indexOf(tempf);
					
				} // for 2
				
				tempScore = inPut[i][3].split("\\ : "); // skor kismini ayiriyoruz
				tempScore1 = Integer.parseInt(tempScore[0]);
				tempScore2 = Integer.parseInt(tempScore[1]);
				
				
				// mac methodunu calistirip data fieldlari guncelliyoruz
				homework2.Basketball.match(basketballTableFinal.get(index1), basketballTableFinal.get(index2), tempScore1, tempScore2 );
				
				
				
			} else if (inPut[i][0].equals("V")) { // voleybol maclari icin
				
				for (Volleyball tempf : volleyballTableFinal) { //voleybol tablosunu geziyoruz
					
					if (tempf.teamName.equals(inPut[i][1])) // 1. takimin objesini bulup indeksini tutuyoruz
						index1 = volleyballTableFinal.indexOf(tempf);
					
				} // for 1
				
				for (Volleyball tempf : volleyballTableFinal) { //voleybol tablosunu geziyoruz
					
					if (tempf.teamName.equals(inPut[i][2])) // 2. takimin objesini bulup indeksini tutuyoruz
						index2 = volleyballTableFinal.indexOf(tempf);
					
				} // for 2
				
				tempScore = inPut[i][3].split("\\ : "); // skor kismini ayiriyoruz
				tempScore1 = Integer.parseInt(tempScore[0]);
				tempScore2 = Integer.parseInt(tempScore[1]);
				
				
				// mac methodunu calistirip data fieldlari guncelliyoruz
				homework2.Volleyball.match(volleyballTableFinal.get(index1), volleyballTableFinal.get(index2), tempScore1, tempScore2 );
										
				
			} // end if 
				
				
		} // end for 
		
				
		// football tablosunu siraliyoruz
		Collections.sort(footballTableFinal, new FootballChainComparator(
                new FootballPointsComparator(),
                new FootballAverageComparator())
        ); // end sorter
	
		// basketball tablosunu siraliyoruz
		Collections.sort(basketballTableFinal, new BasketballChainComparator(
                new BasketballPointsComparator(),
                new BasketballAverageComparator())
        ); // end sorter
		
		// volleyball tablosunu siraliyoruz
		Collections.sort(volleyballTableFinal, new VolleyballChainComparator(
                new VolleyballPointsComparator(),
                new VolleyballAverageComparator())
        ); // end sorter
		 
		
		
		// futbol tablosunu yazdiriyoruz
		// football.out dosyasýný temsil edecek f nesnesi
		PrintStream f = new PrintStream(new File(args[1]));
		  		  
		// outputu f nesnesine yazýlacak sekilde ayarlama
		System.setOut(f);
				
		for(int i = 0; i < footballTableFinal.size(); i++) {
					
			System.out.println(i+1 + "." + "\t" + footballTableFinal.get(i).teamName + "\t" + footballTableFinal.get(i).totalPlayedGames + "\t" + footballTableFinal.get(i).totalWin + "\t" + footballTableFinal.get(i).totalTie + "\t" + footballTableFinal.get(i).totalLoss + "\t" + footballTableFinal.get(i).totalGoal + ":" + footballTableFinal.get(i).totalConcededGoal + "\t" + footballTableFinal.get(i).totalPoints);
					
		} // end for
				
		// basketbol tablosunu yazdiriyoruz
		// basketball.out dosyasýný temsil edecek b nesnesi
		PrintStream b = new PrintStream(new File(args[2]));
		  
		// outputu b nesnesine yazýlacak sekilde ayarlama
		System.setOut(b);
				
		for(int i = 0; i < basketballTableFinal.size(); i++) {
					
			System.out.println(i+1 + "." + "\t" + basketballTableFinal.get(i).teamName + "\t" + basketballTableFinal.get(i).totalPlayedGames + "\t" + basketballTableFinal.get(i).totalWin + "\t" + basketballTableFinal.get(i).totalLoss + "\t" + basketballTableFinal.get(i).totalShot + ":" + basketballTableFinal.get(i).totalConcededShot + "\t" + basketballTableFinal.get(i).totalPoints);
					
		} // end for
				
		// voleybol tablosunu yazdiriyoruz
		// volelyball.out dosyasýný temsil edecek v nesnesi
		PrintStream v = new PrintStream(new File(args[3]));
		  		  
		// outputu v nesnesine yazýlacak sekilde ayarlama
		System.setOut(v);
				
		for(int i = 0; i < volleyballTableFinal.size(); i++) {
					
			System.out.println(i+1 + "." + "\t" + volleyballTableFinal.get(i).teamName + "\t" + volleyballTableFinal.get(i).totalPlayedGames + "\t" + volleyballTableFinal.get(i).totalWin + "\t" + volleyballTableFinal.get(i).totalLoss + "\t" + volleyballTableFinal.get(i).totalSet + ":" + volleyballTableFinal.get(i).totalConcededSet + "\t" + volleyballTableFinal.get(i).totalPoints);
					
		} // end for
			        
	
	} // end method main
	

} // end class Main
