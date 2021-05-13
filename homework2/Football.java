package homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Football extends Sports{
	
	// data fields
	public int totalTie; // takimin berbare kaldigi mac sayisi
	public int totalGoal; // takimin toplam attigi gol sayisi
	public int totalConcededGoal; // takimin toplam yedigi gol sayisi
	public int totalAverageF; // toplam atilan gol sayisi - toplam yenilen gol sayisi

	// constructor
	public Football(String name) {
		super(name);		
	} // end constructor


	// mac yapma methodu
	public static void match(Football team1 , Football team2, int score1, int score2) {
	
		if (score1 > score2) { // 1. takim yenerse
			team1.totalPoints += 3;
			team1.totalGoal += score1;
			team2.totalGoal += score2;
			team1.totalConcededGoal += score2;
			team2.totalConcededGoal += score1;
			team1.totalWin += 1;
			team2.totalLoss += 1;
			
			} else if (score2 > score1) { // ikinci takim yenerse
				team2.totalPoints += 3;
				team1.totalGoal += score1;
				team2.totalGoal += score2;
				team1.totalConcededGoal += score2;
				team2.totalConcededGoal += score1;
				team1.totalLoss += 1;
				team2.totalWin += 1;
				
			} else { // beraberlik durumunda
				team1.totalPoints += 1;
				team2.totalPoints += 1;
				team1.totalGoal += score1;
				team2.totalGoal += score2;
				team1.totalConcededGoal += score2;
				team2.totalConcededGoal += score1;
				team1.totalTie += 1;
				team2.totalTie += 1;
				
			} // end if
		
		team1.totalPlayedGames += 1;
		team2.totalPlayedGames += 1;
		team1.totalAverageF += score1 - score2;
		team2.totalAverageF += score2- score1;
					
	} // end method match

	public static void main(String[] args) {
		
	} // end method main


} // end class Football

/*
 * Burada futbol sinifi için lig tablosunu siralayabilecegimiz bir Chained Comparator
 * yazacagiz. Bu comparator once puana göre siralama yapacak sonra ise avaraja gore
 * esit olanlari kendi aralarinda siralayacak. 
 */

class FootballChainComparator implements Comparator<Football> {
	 
    private List<Comparator<Football>> listComparators;
 
    @SafeVarargs
    public FootballChainComparator(Comparator<Football>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(Football f1, Football f2) {
        for (Comparator<Football> comparator : listComparators) {
            int result = comparator.compare(f1, f2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
} // end class FootballChainComparator

class FootballPointsComparator implements Comparator<Football> {
	 
    @Override
    public int compare(Football f1, Football f2) {
        return f2.totalPoints - f1.totalPoints;
    }
} // end class FootballPointsComparator

class FootballAverageComparator implements Comparator<Football> {
	 
    @Override
    public int compare(Football f1, Football f2) {
        return f2.totalAverageF - f1.totalAverageF;
    }
} // end class FootballAverageComparator
