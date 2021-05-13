package homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Basketball extends Sports {
	
	// data fields
	public int totalShot; // toplam atilan sut sayisi
	public int totalConcededShot; // toplam yenilen sut sayisi
	public int totalAverageB; // toplam atilan - toplam yenilen sut
	
	// constructor
	public Basketball(String name) {
		super(name);
	}

	// mac yapma methodu
	public static void match(Basketball team1 , Basketball team2, int score1, int score2) {
		
		if (score1 > score2) { // 1. takimin kazandigi durumda
			team1.totalPoints += 2;
			team2.totalPoints += 1;
			team1.totalShot += score1;
			team2.totalShot += score2;
			team1.totalConcededShot += score2;
			team2.totalConcededShot += score1;
			team1.totalWin += 1;
			team2.totalLoss += 1;
			
			} else { // ikinci takimin kazandigi durumda
				team1.totalPoints += 1;
				team2.totalPoints += 2;
				team1.totalShot += score1;
				team2.totalShot += score2;
				team1.totalConcededShot += score2;
				team2.totalConcededShot += score1;
				team1.totalLoss += 1;
				team2.totalWin += 1;
				
			} // end if
		
		team1.totalPlayedGames += 1;
		team2.totalPlayedGames += 1;
		team1.totalAverageB += score1 - score2;
		team2.totalAverageB += score2- score1;
					
					
	} // end method match

		
	public static void main(String[] args) {
				
			
	} // end method main

} // end class Basketball

/*
 * Burada basketbol sinifi için lig tablosunu siralayabilecegimiz bir Chained Comparator
 * yazacagiz. Bu comparator once puana göre siralama yapacak sonra ise avaraja gore
 * esit olanlari kendi aralarinda siralayacak. 
 */


class BasketballChainComparator implements Comparator<Basketball> {
	 
    private List<Comparator<Basketball>> listComparators;
 
    @SafeVarargs
    public BasketballChainComparator(Comparator<Basketball>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(Basketball b1, Basketball b2) {
        for (Comparator<Basketball> comparator : listComparators) {
            int result = comparator.compare(b1, b2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
} // end class BasketballChainComparator

class BasketballPointsComparator implements Comparator<Basketball> {
	 
    @Override
    public int compare(Basketball b1, Basketball b2) {
        return b2.totalPoints - b1.totalPoints;
    }
} // end class BasketballPointsComparator

class BasketballAverageComparator implements Comparator<Basketball> {
	 
    @Override
    public int compare(Basketball b1, Basketball b2) {
        return b2.totalAverageB - b1.totalAverageB;
    }
} // end class BasketballAverageComparator
