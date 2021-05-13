package homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Volleyball extends Sports {
	
	
	// data fields	
	public int totalSet; // toplam kazanilan set sayisi
	public int totalConcededSet; // toplam kaybedilen set sayisi
	public int totalAverageV; // toplam kazanilan - toplam kaybedilen set
	
	
	// constructor
	public Volleyball(String name) {
		super(name);
	} // end constructor

	// mac yapma methodu
	public static void match(Volleyball team1 , Volleyball team2, int score1, int score2) {
		
		if ((score1 == 3 && score2 == 0) || (score1 == 3 && score2 == 1)) { // 3-0 veya 3-1 bitmesi durumunda
			
			team1.totalPoints += 3;
			team1.totalSet += score1;
			team2.totalSet+= score2;
			team1.totalConcededSet += score2;
			team2.totalConcededSet += score1;
			team1.totalWin += 1;
			team2.totalLoss += 1;
			
			} else if (score1 == 3 && score2 == 2) { // 3-2 bitmesi durumunda
				
				team1.totalPoints += 2;
				team2.totalPoints += 1;
				team1.totalSet += score1;
				team2.totalSet += score2;
				team1.totalConcededSet += score2;
				team2.totalConcededSet += score1;
				team1.totalWin += 1;
				team2.totalLoss += 1;
				
			} else if ((score1 == 0 && score2 == 3) || (score1 == 1 && score2 == 3)) { // 0-3 veya 1-3 bitmesi durumunda
				
				team2.totalPoints += 3;
				team1.totalSet += score1;
				team2.totalSet += score2;
				team1.totalConcededSet += score2;
				team2.totalConcededSet += score1;
				team1.totalLoss += 1;
				team2.totalWin += 1;
				
			} else if (score1 == 2 && score2 == 3) { // 2-3 bitmesi durumunda
				
				team1.totalPoints += 1;
				team2.totalPoints += 2;
				team1.totalSet += score1;
				team2.totalSet += score2;
				team1.totalConcededSet += score2;
				team2.totalConcededSet += score1;
				team1.totalLoss += 1;
				team2.totalWin += 1;
				
			} // end if
		
		team1.totalPlayedGames += 1;
		team2.totalPlayedGames += 1;
		team1.totalAverageV += score1 - score2;
		team2.totalAverageV += score2- score1;
					
					
	} // end method match

	public static void main(String[] args) {
		
			

	} // end method main

} // end class Volleyball

/*
 * Burada voleybol sinifi için lig tablosunu siralayabilecegimiz bir Chained Comparator
 * yazacagiz. Bu comparator once puana göre siralama yapacak sonra ise avaraja gore
 * esit olanlari kendi aralarinda siralayacak. 
 */

class VolleyballChainComparator implements Comparator<Volleyball> {
	 
    private List<Comparator<Volleyball>> listComparators;
 
    @SafeVarargs
    public VolleyballChainComparator(Comparator<Volleyball>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(Volleyball v1, Volleyball v2) {
        for (Comparator<Volleyball> comparator : listComparators) {
            int result = comparator.compare(v1, v2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
} // end class VolleyballChainComparator

class VolleyballPointsComparator implements Comparator<Volleyball> {
	 
    @Override
    public int compare(Volleyball v1, Volleyball v2) {
        return v2.totalPoints - v1.totalPoints;
    }
} // end class VolleyballPointsComparator

class VolleyballAverageComparator implements Comparator<Volleyball> {
	 
    @Override
    public int compare(Volleyball v1, Volleyball v2) {
        return v2.totalAverageV - v1.totalAverageV;
    }
} // end class VolleyballAverageComparator
